package com.dentolize.patients.operation.api;

import com.dentolize.patients.info.api.PatientApis;
import com.dentolize.search.SearchApis;
import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import engine.CustomReporter;
import engine.Verifications;
import engine.actions.GraphQlActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static engine.Helper.setVariable;

public class OperationStepsApis {
    private final SHAFT.API restActions;
    protected SearchApis searchApis;
    protected PatientApis patientApis;
    Map<String, Object> variables;

    public OperationStepsApis(SHAFT.API restActions) {
        this.restActions = restActions;
        searchApis = new SearchApis(restActions);
        patientApis = new PatientApis(restActions);
    }

    @Step("Update Operation steps data details [ {operationStepsId} ]")
    public Response updateOperationSteps(String cookie, String operationStepsId, String appointmentId, JSONFileManager operationData, String objName) {
        Map<String, Object> updateOperationStepsVariables = editOperationStepVariables(cookie, operationData, objName);
        updateOperationStepsVariables.put("operationStep", operationStepsId);
        if (!appointmentId.isEmpty()) {
            updateOperationStepsVariables.put("appointment", appointmentId);
        }
        Response response = GraphQlActions.sendGraphQlRequest(OperationStepsSchema.getInstance().EDIT_OPERATION_STEP_MUTATION, updateOperationStepsVariables, cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }

    @Step("Get edit operation step id")
    public String getEditOperationStepId(Response response) {
        String operationStepId = RestActions.getResponseJSONValue(response, "data.operationDetails.steps[0].id");
        CustomReporter.getInstance().logInfoStep("Operation step ID: [ " + operationStepId + " ]");
        return operationStepId;
    }

    @Step("Read Operation steps details [ {operationStepId} ]")
    public Response readOperationStepsDetails(String cookie, String operationStepId) {
        Response response = GraphQlActions.sendGraphQlRequest(OperationStepsSchema.getInstance().OPERATION_STEP_DETAILS, Map.of("operationStep", operationStepId), cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }

    private Map<String, Object> editOperationStepVariables(String cookie, JSONFileManager jsonData, String objName) {
        variables = new HashMap<>();
        // Required variables
        setVariable(variables, "branch", searchApis.getBranchId(cookie, jsonData.getTestData(objName + ".branch"))); // ID!
        setVariable(variables, "forOperator", jsonData.getTestData(objName + ".forOperator"), Float.class); // Float!
        setVariable(variables, "forLab", jsonData.getTestData(objName + ".forLab"), Float.class); // Float!
        // Optional variables
        setVariable(variables, "details", jsonData.getTestData(objName + ".details")); // String
        setVariable(variables, "appointment", jsonData.getTestData(objName + ".appointment")); // ID
        setVariable(variables, "doctor", searchApis.getUserId(cookie, jsonData.getTestData(objName + ".doctor"))); // ID
        setVariable(variables, "createdAt", jsonData.getTestData(objName + ".createdAt")); // DateTime
        setVariable(variables, "start", jsonData.getTestData(objName + ".start")); // DateTime
        setVariable(variables, "end", jsonData.getTestData(objName + ".end")); // DateTime
        setVariable(variables, "status", jsonData.getTestData(objName + ".status").toUpperCase()); // OperationStatusType
        return variables;
    }

}
