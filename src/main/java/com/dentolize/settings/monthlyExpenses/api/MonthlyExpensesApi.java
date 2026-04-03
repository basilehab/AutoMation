package com.dentolize.settings.monthlyExpenses.api;

import com.shaft.driver.SHAFT;
import engine.ApiBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import engine.actions.GraphQlActions;

import java.util.HashMap;

import java.util.Map;

public class MonthlyExpensesApi {
    private final SHAFT.API restActions;

    //****** constructor ******//
    public MonthlyExpensesApi(SHAFT.API restActions) {
        this.restActions = restActions;
    }

    //*****************************************************//
    //***************// Business Actions //****************//
    //*****************************************************//
    @Step( "Add Monthly Expenses" )
    public Response addNewMonthlyExpenses(String cookie, String name, Float amount, Boolean automaticPaid, String type, String user_id, String branch_id, String details) {
        Map<String, Object> addNewBranch_Variables = new HashMap<>();
        addNewBranch_Variables.put("name", name);
        addNewBranch_Variables.put("amount", amount);
        addNewBranch_Variables.put("automatic", automaticPaid);
        addNewBranch_Variables.put("type", type);
        addNewBranch_Variables.put("user", user_id);
        addNewBranch_Variables.put("branch", branch_id);
        addNewBranch_Variables.put("details", details);
        return GraphQlActions.sendGraphQlRequest(ApiBase.BASE_URL, MonthlyExpensesSchema.MUTATION_ADD_NEW_MONTHLY_EXPENSE,
                addNewBranch_Variables, "cookie", cookie, "uncrunch");
    }

    @Step( "Edit Monthly Expenses" )
    public Response editMonthlyExpenses(String cookie, String monthlyExpense_id, String name, Float amount, Boolean automaticPaid, String type, String user_id, String branch_id, String details) {
        Map<String, Object> editBranch_Variables = new HashMap<>();
        editBranch_Variables.put("monthlyExpense", monthlyExpense_id);
        editBranch_Variables.put("name", name);
        editBranch_Variables.put("amount", amount);
        editBranch_Variables.put("automaticPaid", automaticPaid);
        editBranch_Variables.put("type", type);
        editBranch_Variables.put("user", user_id);
        editBranch_Variables.put("branch", branch_id);
        editBranch_Variables.put("details", details);
        return GraphQlActions.sendGraphQlRequest(ApiBase.BASE_URL, MonthlyExpensesSchema.MUTATION_EDIT_MONTHLY_EXPENSE,
                editBranch_Variables, "cookie", cookie, "uncrunch");
    }

    @Step( "Get Monthly Expenses details" )
    public Response getMonthlyExpenses(String cookie, String searchTerm, String filters) {
        Map<String, Object> getMonthlyExpenses_Variables = new HashMap<>();
        getMonthlyExpenses_Variables.put("skip", 0);
        getMonthlyExpenses_Variables.put("take", 5);
        getMonthlyExpenses_Variables.put("orderBy", "createdAt-desc");
        getMonthlyExpenses_Variables.put("searchTerm", searchTerm);
        getMonthlyExpenses_Variables.put("filters", filters);
        return GraphQlActions.sendGraphQlRequest(ApiBase.BASE_URL, MonthlyExpensesSchema.QUERY_GET_MONTHLY_EXPENSES,
                getMonthlyExpenses_Variables, "cookie", cookie, "uncrunch");
    }

    @Step( "Delete Monthly Expenses" )
    public Response deleteMonthlyExpenses(String cookie, String monthlyExpense_id) {
        Map<String, Object> deleteMonthlyExpenses_Variables = new HashMap<>();
        deleteMonthlyExpenses_Variables.put("monthlyExpense", monthlyExpense_id);
        return GraphQlActions.sendGraphQlRequest(ApiBase.BASE_URL, MonthlyExpensesSchema.MUTATION_DELETE_MONTHLY_EXPENSE,
                deleteMonthlyExpenses_Variables, "cookie", cookie, "uncrunch");
    }
}
