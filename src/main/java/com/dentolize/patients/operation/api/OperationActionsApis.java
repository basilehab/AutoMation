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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static engine.Helper.setVariable;

public class OperationActionsApis {
    private final SHAFT.API restActions;
    protected SearchApis searchApis;
    protected PatientApis patientApis;
    Map<String, Object> variables;

    public OperationActionsApis(SHAFT.API restActions) {
        this.restActions = restActions;
        searchApis = new SearchApis(restActions);
        patientApis = new PatientApis(restActions);
    }

    @Step("Update Operation status [ {operationIds} ]")
    public Response updateOperationStatus(String cookie, List<String> operationIds, JSONFileManager operationData, String objName) {
        Map<String, Object> operationStatusVariables = new HashMap<>();
        operationStatusVariables.put("operations", operationIds);
        setVariable(operationStatusVariables, "status", operationData.getTestData(objName + ".status"));
        setVariable(operationStatusVariables, "createItems", operationData.getTestData(objName + ".createItems"), Boolean.class);
        Response response = GraphQlActions.sendGraphQlRequest(OperationsActionsSchema.getInstance().UPDATE_OPERATIONS_STATUS_MUTATION, operationStatusVariables, cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }

    @Step("Update Operation Price and Amount [ {operationIds} ]")
    public Response updateOperationPriceAndAmount(String cookie, List<String> operationIds, JSONFileManager operationData, String objName) {
        List<Map<String, Object>> operations = new ArrayList<>();
        for (int i = 0; i < operationIds.size(); i++) {
            String operationId = operationIds.get(i);
            Map<String, Object> operation = new HashMap<>();
            operation.put("id", operationId);
            operation.put("price", Float.parseFloat(operationData.getTestData(objName + "[" + i + "].price")));
            operation.put("amount", Integer.parseInt(operationData.getTestData(objName + "[" + i + "].amount")));
            operations.add(operation);
        }

        // Final variables map
        Map<String, Object> variables = new HashMap<>();
        variables.put("operations", operations);
        Response response = GraphQlActions.sendGraphQlRequest(OperationsActionsSchema.getInstance().UPDATE_OPERATION_PRICE_AMOUNT_MUTATION, variables, cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }

//    //TODO: check if we need to update price and amount separately
//    @Step("Update price and amount ")
//    public Response updateOperationPriceAndAmount(String cookie, String operationId, JSONFileManager operationData, String objName) {
//        Map<String, Object> operationPriceVariables = new HashMap<>();
//        setVariable(operationPriceVariables, "operation", operationId);
//        setVariable(operationPriceVariables, "price", operationData.getTestData(objName + ".price"));
//        setVariable(operationPriceVariables, "amount", operationData.getTestData(objName + ".amount"));
//        return GraphQlActions.sendGraphQlRequest(OperationsActionsSchema.getInstance().UPDATE_OPERATION_PRICE_AMOUNT_MUTATION, operationPriceVariables, cookie);
//    }
}
