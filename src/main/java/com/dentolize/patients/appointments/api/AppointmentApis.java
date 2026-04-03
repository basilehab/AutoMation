package com.dentolize.patients.appointments.api;

import com.dentolize.search.SearchApis;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import engine.CustomReporter;
import engine.Helper;
import engine.Verifications;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import engine.actions.GraphQlActions;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static engine.Helper.setVariable;

public class AppointmentApis {

    private final SHAFT.API restActions;
    protected SearchApis searchApis;
    Map<String, Object> variables;

    public AppointmentApis(SHAFT.API restActions) {
        this.restActions = restActions;
        searchApis = new SearchApis(restActions);
    }


    @Step("Create New Appointment")
    public Response createAppointment(String cookie, JSONFileManager appointmentData, String objName) {
        Map<String, Object> addNewAppointmentVariables = prepareAppointmentVariables(cookie, appointmentData, objName);
        addNewAppointmentVariables.put("generatedID", Helper.generateUuid());
        Response response = GraphQlActions.sendGraphQlRequest(AppointmentsSchema.getInstance().ADD_NEW_APPOINTMENT_MUTATION, addNewAppointmentVariables, cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }

    @Step("Read Appointment details [ {appointmentId} ]")
    public Response readAppointmentDetails(String cookie, String appointmentId) {
        Response response = GraphQlActions.sendGraphQlRequest(AppointmentsSchema.getInstance().APPOINTMENTS_DETAILS_QUERY, Map.of("appointment", appointmentId), cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }

    @Step("Update Appointment details [ {appointmentId} ]")
    public Response updateAppointment(String cookie, String appointmentId, JSONFileManager appointmentData, String objName) {
        Map<String, Object> updateAppointmentVariables = prepareAppointmentVariables(cookie, appointmentData, objName);
        updateAppointmentVariables.put("appointment", appointmentId);
        Response response = GraphQlActions.sendGraphQlRequest(AppointmentsSchema.getInstance().EDIT_APPOINTMENT_MUTATION, updateAppointmentVariables, cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }
    @Step("Delete Appointment [ {appointmentId} ]")
    public Response deleteAppointment(String cookie, String appointmentId,String branchId) {
        Response response = GraphQlActions.sendGraphQlRequest(AppointmentsSchema.getInstance().DELETE_APPOINTMENT_MUTATION, Map.of("appointment", appointmentId,"branch",branchId), cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }

    @Step("Collect Diagnostic Fee for Appointment [ {appointmentId} ]")
    public Response collectDiagnosticFee(String cookie, String appointmentId, JSONFileManager jsonData, String objName) {
        Map<String, Object> collectDiagnosticFeeVariables = new HashMap<>();
        String amount = jsonData.getTestData(objName + ".collectDiagnosticFee");
        if (Float.parseFloat(amount) > 0) {
            setVariable(collectDiagnosticFeeVariables, "appointment", appointmentId);
            setVariable(collectDiagnosticFeeVariables, "generatedInvoiceID", Helper.generateUuid());
            setVariable(collectDiagnosticFeeVariables, "generatedPaymentID", Helper.generateUuid());
            setVariable(collectDiagnosticFeeVariables, "amount", amount);
            setVariable(collectDiagnosticFeeVariables, "tax", jsonData.getTestData(objName + ".tax"));
            setVariable(collectDiagnosticFeeVariables, "taxPercent", jsonData.getTestData(objName + ".taxPercent"));
            setVariable(collectDiagnosticFeeVariables, "type", jsonData.getTestData(objName + ".type"));
            setVariable(collectDiagnosticFeeVariables, "chart", jsonData.getTestData(objName + ".chart"));
            Response response =GraphQlActions.sendGraphQlRequest(AppointmentsSchema.getInstance().COLLECT_DIAGNOSTIC_FEES_MUTATION, collectDiagnosticFeeVariables, cookie);
            Verifications.verifyResponseTimeAndStatusCode(response);
            return response;
        } else {
            CustomReporter.getInstance().logInfoStep("Diagnostic Fee amount is 0, skipping Collect Diagnostic Fee API call.");
            return null;
        }
    }


    private Map<String, Object> prepareAppointmentVariables(String cookie, JSONFileManager jsonData, String objName) {
        variables = new HashMap<>();
        setVariable(variables, "branch", searchApis.getBranchId(cookie, jsonData.getTestData(objName + ".branch")));
        setVariable(variables, "doctor", searchApis.getUserId(cookie, jsonData.getTestData(objName + ".doctor")));
        setVariable(variables, "patient", searchApis.getPatientId(cookie, jsonData.getTestData(objName + ".patient")));
        setVariable(variables, "chart", jsonData.getTestData(objName + ".chart").toUpperCase());
        setVariable(variables, "urgent", jsonData.getTestData(objName + ".urgent"), Boolean.class);
        setVariable(variables, "isOnline", jsonData.getTestData(objName + ".isOnline"), Boolean.class);
        setVariable(variables, "alert", jsonData.getTestData(objName + ".alert"));
        setVariable(variables, "room", jsonData.getTestData(objName + ".room"));
        setVariable(variables, "day", Helper.getTimestamp(Helper.TimeFormat.ISO_INSTANT_DATE));
        setVariable(variables, "start", Helper.getTimestamp(Helper.TimeFormat.ISO_INSTANT_DATE));
        setVariable(variables, "end", Helper.getTimestamp(Helper.TimeFormat.ISO_INSTANT_DATE, 30));
        setVariable(variables, "status", jsonData.getTestData(objName + ".status").toUpperCase());
        variables.put("customFields", jsonData.getTestDataAsList(objName + ".customFields"));
        variables.put("patientCustomFields", jsonData.getTestDataAsList(objName + ".patientCustomFields"));
        variables.put("users", jsonData.getTestDataAsList(objName + ".users"));
        setVariable(variables, "appointmentType", jsonData.getTestData(objName + ".appointmentType"));
        addDiagnosticFeesOption(jsonData, objName);
        return variables;
    }

    /**
     * Case 1 - None -> diagnosticFee = 0, diagnosticFeeInvoice= 0
     * Case 2 - Collected -> diagnosticFeeInvoice= float, type:"CASH", paymentOther=String, generatedInvoiceID:uuid, generatedPaymentID:uuid
     * Case 3 - Add to Next Invoice -> diagnosticFee = float
     * Case 4 - Collect Diagnostic Fee -> Call COLLECT_DIAGNOSTIC_FEES api set (appointmentId, amount, tax, taxPercent, type, paymentOther, chart, generatedInvoiceID, generatedPaymentID)
     */
    @Step("Add Diagnostic Fees Option")
    private void addDiagnosticFeesOption(JSONFileManager jsonData, String objName) {
        String collectFeeFromAppointment = jsonData.getTestData(objName + ".diagnosticFeeInvoice");
        String addToNextInvoice = jsonData.getTestData(objName + ".diagnosticFee");
        if (Float.parseFloat(collectFeeFromAppointment) > 0) { // Case 2 = Collected
            setVariable(variables, "diagnosticFeeInvoice", collectFeeFromAppointment, Float.class);
            setVariable(variables, "type", jsonData.getTestData(objName + ".type"));
            setVariable(variables, "paymentOther", jsonData.getTestData(objName + ".paymentOther"));
            setVariable(variables, "generatedInvoiceID", Helper.generateUuid());
            setVariable(variables, "generatedPaymentID", Helper.generateUuid());
            CustomReporter.getInstance().logInfoStep(" invoiceId: [ " + variables.get("generatedInvoiceID") + "]  paymentId: [ " + variables.get("generatedPaymentID") + " ]");
        } else if (Float.parseFloat(addToNextInvoice) > 0) { // Case 3 = Add to Next Invoice
            setVariable(variables, "diagnosticFee", addToNextInvoice, Float.class);
        } else {
            setVariable(variables, "diagnosticFee", "0", Float.class);
            setVariable(variables, "diagnosticFeeInvoice", "0", Float.class);
        }

    }
}
