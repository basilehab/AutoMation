package com.dentolize.patients.invoice.api;

import com.dentolize.patients.appointments.api.AppointmentsSchema;
import com.dentolize.search.SearchApis;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import engine.Helper;
import engine.Verifications;
import engine.actions.GraphQlActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static engine.Helper.setVariable;

public class InvoiceApis {
    private final SHAFT.API restActions;
    protected SearchApis searchApis;
    Map<String, Object> variables;

    public InvoiceApis(SHAFT.API restActions) {
        this.restActions = restActions;
        searchApis = new SearchApis(restActions);
    }

    @Step("Create New Invoice")
    public Response createInvoice(String cookie, JSONFileManager invoiceData, String objName) {
        Map<String, Object> addNewInvoiceVariables = prepareInvoiceVariables(cookie, invoiceData, objName);
        addNewInvoiceVariables.put("generatedID", Helper.generateUuid());
        Response response = GraphQlActions.sendGraphQlRequest(InvoiceSchema.getInstance().CREATE_NEW_INVOICE_MUTATION, addNewInvoiceVariables, cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }

    @Step("Read Invoice details [ {invoiceId} ]")
    public Response readAppointmentDetails(String cookie, String invoiceId) {
        Response response = GraphQlActions.sendGraphQlRequest(InvoiceSchema.getInstance().INVOICE_DETAILS_QUERY, Map.of("invoice", invoiceId), cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }
    private Map<String, Object> prepareInvoiceVariables(String cookie, JSONFileManager jsonData, String objName) {
        variables = new HashMap<>();
        // Required variables// ID!
        setVariable(variables, "pendingPaymentPercent", jsonData.getTestData(objName + ".pendingPaymentPercent"), Float.class); // Float!
        variables.put("operations", jsonData.getTestDataAsList(objName + ".operations")); // [ID!]!
        setVariable(variables, "patient", searchApis.getPatientId(cookie, jsonData.getTestData(objName + ".patient"))); // ID!
        setVariable(variables, "branch", searchApis.getBranchId(cookie, jsonData.getTestData(objName + ".branch"))); // ID!
        setVariable(variables, "doctor", searchApis.getUserId(cookie, jsonData.getTestData(objName + ".doctor"))); // ID!
        variables.put("lineItems", jsonData.getTestDataAsList(objName + ".lineItems")); // [InvoiceLineItem!]!
        // Optional variables
        variables.put("users", jsonData.getTestDataAsList(objName + ".users")); // [ID]
        setVariable(variables, "markAppointmentsCompleted", jsonData.getTestData(objName + ".markAppointmentsCompleted"), Boolean.class);
        setVariable(variables, "createdAt", jsonData.getTestData(objName + ".createdAt")); // DateTime
        setVariable(variables, "sms", jsonData.getTestData(objName + ".sms"), Boolean.class);
        setVariable(variables, "invoiceId", jsonData.getTestData(objName + ".invoiceId")); // String
        setVariable(variables, "details", jsonData.getTestData(objName + ".details")); // String
        setVariable(variables, "referenceId", jsonData.getTestData(objName + ".referenceId"), Float.class);
        setVariable(variables, "treasury", jsonData.getTestData(objName + ".treasury")); // ID
        setVariable(variables, "appointment", jsonData.getTestData(objName + ".appointment")); // ID
        setVariable(variables, "patientPartAlertShown", jsonData.getTestData(objName + ".patientPartAlertShown"), Boolean.class);
        setVariable(variables, "preAuth", jsonData.getTestData(objName + ".preAuth")); // String
        setVariable(variables, "patientTaxPercent", jsonData.getTestData(objName + ".patientTaxPercent"), Float.class);
        setVariable(variables, "insuranceTaxPercent", jsonData.getTestData(objName + ".insuranceTaxPercent"), Float.class);

        return variables;
    }

}
