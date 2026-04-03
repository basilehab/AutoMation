package com.dentolize.patients.operation.api;

import com.dentolize.patients.info.api.PatientApis;
import com.dentolize.search.SearchApis;
import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import engine.CustomReporter;
import engine.Helper;
import engine.Verifications;
import engine.actions.GraphQlActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static engine.Helper.setVariable;

public class OperationApis {
    private final SHAFT.API restActions;
    protected SearchApis searchApis;
    protected PatientApis patientApis;
    Map<String, Object> variables;

    public OperationApis(SHAFT.API restActions) {
        this.restActions = restActions;
        searchApis = new SearchApis(restActions);
        patientApis = new PatientApis(restActions);
    }

    @Step("Create New Operation")
    public Response createOperation(String cookie, JSONFileManager operationData, String objName) {
        Map<String, Object> createOperationVariables = createVariables(cookie, operationData, objName);
        createOperationVariables.put("generatedID", Helper.generateUuid());
        Response response = GraphQlActions.sendGraphQlRequest(OperationsSchema.getInstance().CREATE_NEW_OPERATIONS_MUTATION, createOperationVariables, cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }

    @Step("Read Operation details [ {operationId} ]")
    public Response readOperationDetails(String cookie, String operationId) {
        Response response = GraphQlActions.sendGraphQlRequest(OperationsSchema.getInstance().OPERATION_DETAILS_QUERY, Map.of("operation", operationId), cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }

    @Step("Read all Operation details for patient details [ {patient} ]")
    public Response readAllOperationsForPatient(String cookie, String patient, String chart) {
        String patientId = searchApis.getPatientId(cookie, patient);
        Response response = GraphQlActions.sendGraphQlRequest(OperationsSchema.getInstance().GET_PATIENT_OPERATIONS_QUERY, Map.of("patient", patientId, "chart", chart.toUpperCase()), cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }

    @Step("Update Operation data details [ {operationId} ]")
    public Response updateOperation(String cookie, String operationId, JSONFileManager operationData, String objName) {
        Map<String, Object> updateAppointmentVariables = editVariables(cookie, operationData, objName);
        updateAppointmentVariables.put("operation", operationId);
        Response response = GraphQlActions.sendGraphQlRequest(OperationsSchema.getInstance().EDIT_NEW_OPERATIONS_MUTATION, updateAppointmentVariables, cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }

    // TODO: Check if we need to delete operation or not
    @Step("Delete Operation [ {operationId} ]")
    public Response deleteOperation(String cookie, String operationId) {
        Response response = GraphQlActions.sendGraphQlRequest(OperationsSchema.getInstance().DELETE_OPERATIONS_MUTATION, Map.of("operation", operationId), cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }

    @Step("Get created operation id")
    public String getCreatedOperationId(Response response) {
        String procedureId = RestActions.getResponseJSONValue(response, "data.createNewOperations.id");
        CustomReporter.getInstance().logInfoStep("Created procedure ID: [ " + procedureId + " ]");
        return procedureId;
    }

    @Step("Get edit operation id")
    public String getEditOperationId(Response response) {
        String operationId = RestActions.getResponseJSONValue(response, "data.editOperationWithoutInvoice.id");
        CustomReporter.getInstance().logInfoStep("Edited operation ID: [ " + operationId + " ]");
        return operationId;
    }


    private Map<String, Object> createVariables(String cookie, JSONFileManager jsonData, String objName) {
        variables = new HashMap<>();
        String chartType = jsonData.getTestData(objName + ".chart").toUpperCase();
        variables = patientApis.addPatient(cookie, jsonData, objName, variables);
        // Required variables
        setVariable(variables, "status", jsonData.getTestData(objName + ".status").toUpperCase());
        variables.put("tooth", jsonData.getTestDataAsList(objName + ".tooth")); // since it's [Int!]!
        setVariable(variables, "doctor", searchApis.getUserId(cookie, jsonData.getTestData(objName + ".doctor")));
        setVariable(variables, "branch", searchApis.getBranchId(cookie, jsonData.getTestData(objName + ".branch")));
        setVariable(variables, "child", jsonData.getTestData(objName + ".child"), Boolean.class);
        // Optional variables
        setVariable(variables, "name", jsonData.getTestData(objName + ".name"));
        setVariable(variables, "code", jsonData.getTestData(objName + ".code"));
        setVariable(variables, "price", jsonData.getTestData(objName + ".price"), Float.class);
        setVariable(variables, "cost", jsonData.getTestData(objName + ".cost"), Float.class);
        setVariable(variables, "procedure", searchApis.getProcedureId(cookie, chartType, jsonData.getTestData(objName + ".procedure")));
        setVariable(variables, "condition", jsonData.getTestData(objName + ".condition"));
        variables.put("toothPart", jsonData.getTestDataAsList(objName + ".toothPart"));
        setVariable(variables, "appointment", jsonData.getTestData(objName + ".appointment"));
        setVariable(variables, "priceList", jsonData.getTestData(objName + ".priceList"));
        setVariable(variables, "insuranceDiscount", jsonData.getTestData(objName + ".insuranceDiscount"), Boolean.class);
        setVariable(variables, "insuranceValue", jsonData.getTestData(objName + ".insuranceValue"), Integer.class);
        setVariable(variables, "details", jsonData.getTestData(objName + ".details"));
        setVariable(variables, "productPriceId", jsonData.getTestData(objName + ".productPriceId"));
        setVariable(variables, "sms", jsonData.getTestData(objName + ".sms"), Boolean.class);
        setVariable(variables, "createItems", jsonData.getTestData(objName + ".createItems"), Boolean.class);
        setVariable(variables, "counter", jsonData.getTestData(objName + ".counter"));
        setVariable(variables, "globalCondition", jsonData.getTestData(objName + ".globalCondition"));
        setVariable(variables, "manualPrice", jsonData.getTestData(objName + ".manualPrice"), Boolean.class);
        setVariable(variables, "chart", chartType);
        return variables;
    }

    private Map<String, Object> editVariables(String cookie, JSONFileManager jsonData, String objName) {
        variables = new HashMap<>();
        // Required variables
        setVariable(variables, "operation", jsonData.getTestData(objName + ".operation")); // ID!
        setVariable(variables, "cost", jsonData.getTestData(objName + ".cost"), Float.class);
        variables.put("tooth", jsonData.getTestDataAsList(objName + ".tooth"));
        setVariable(variables, "branch", searchApis.getBranchId(cookie, jsonData.getTestData(objName + ".branch")));
        setVariable(variables, "forOperator", jsonData.getTestData(objName + ".forOperator"), Float.class);
        setVariable(variables, "child", jsonData.getTestData(objName + ".child"), Boolean.class);
        // Optional variables
        setVariable(variables, "details", jsonData.getTestData(objName + ".details"));
        setVariable(variables, "appointment", jsonData.getTestData(objName + ".appointment")); // ID
        setVariable(variables, "doctor", searchApis.getUserId(cookie, jsonData.getTestData(objName + ".doctor"))); // ID
        setVariable(variables, "createdAt", jsonData.getTestData(objName + ".createdAt")); // DateTime
        setVariable(variables, "status", jsonData.getTestData(objName + ".status")); // OperationStatusType
        setVariable(variables, "expires", jsonData.getTestData(objName + ".expires")); // DateTime
        setVariable(variables, "start", jsonData.getTestData(objName + ".start")); // DateTime
        setVariable(variables, "end", jsonData.getTestData(objName + ".end")); // DateTime
        return variables;
    }


}
