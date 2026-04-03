package com.dentolize.settings.users.api;

import com.shaft.driver.SHAFT;
import engine.actions.GraphQlActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersApi {
    private final SHAFT.API restActions;

    public UsersApi(SHAFT.API restActions) {
        this.restActions = restActions;
    }

    @Step("Add New User")
    public Response addNewUser(String cookie, String name, String phoneNumber, String phoneNumber2, List branches, String job, Float salary, String permissionGroupsId, String dentalNotation, String loginMethod, String email, String username, String password, Boolean isDoctor, Float doctorPercentage, String expensesFrom, Boolean automaticExpenses, Boolean automaticPaid, List customFields) {
        Map<String, Object> variables = createUserVariables(name, phoneNumber, phoneNumber2, branches, job, salary, permissionGroupsId, dentalNotation, loginMethod, email, username, password, isDoctor, doctorPercentage, expensesFrom, automaticExpenses, automaticPaid, customFields);
        return GraphQlActions.sendGraphQlRequest(UsersSchema.getInstance().MUTATION_ADD_NEW_USER, variables, cookie);
    }

    @Step("Edit User")
    public Response editUser(String cookie, String userId, String name, String phoneNumber, String phoneNumber2, List branches, String job, Float salary, String permissionGroupsId, String dentalNotation, String loginMethod, String email, String username, String password, Boolean isDoctor, Float doctorPercentage, String expensesFrom, Boolean automaticExpenses, Boolean automaticPaid, List customFields) {
        Map<String, Object> variables = createUserVariables(name, phoneNumber, phoneNumber2, branches, job, salary, permissionGroupsId, dentalNotation, loginMethod, email, username, password, isDoctor, doctorPercentage, expensesFrom, automaticExpenses, automaticPaid, customFields);
        variables.put("user", userId);
        return GraphQlActions.sendGraphQlRequest(UsersSchema.getInstance().MUTATION_ADD_NEW_USER, variables, cookie);
    }

    @Step("Get Users")
    public Response getUsers(String cookie, String searchTerm) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("skip", 0);
        variables.put("take", 5);
        variables.put("orderBy", "createdAt-desc");
        variables.put("searchTerm", searchTerm);
        variables.put("rangeDate", List.of());
        return GraphQlActions.sendGraphQlRequest(UsersSchema.getInstance().QUERY_GET_USERS, variables, cookie);
    }

    @Step("Disable User")
    public Response disableUser(String cookie, String userId, Boolean disabled) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("user", userId);
        variables.put("disabled", disabled);
        return GraphQlActions.sendGraphQlRequest(UsersSchema.getInstance().MUTATION_DISABLE_USER, variables, cookie);
    }

    private Map<String, Object> createUserVariables(String name, String phoneNumber, String phoneNumber2, List branches, String job, Float salary, String permissionGroupsId, String dentalNotation, String loginMethod, String email, String username, String password, Boolean isDoctor, Float doctorPercentage, String expensesFrom, Boolean automaticExpenses, Boolean automaticPaid, List customFields) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("name", name);
        variables.put("phoneNumber", phoneNumber);
        variables.put("phoneNumber2", phoneNumber2);
        variables.put("branches", branches);
        variables.put("job", job);
        variables.put("salary", salary);
        variables.put("group", permissionGroupsId);
        variables.put("dentalNotation", dentalNotation);
        if ("email".equals(loginMethod)) {
            variables.put("email", email);
        } else if ("username".equals(loginMethod)) {
            variables.put("username", username);
        }
        variables.put("password", password);
        variables.put("isDoctor", isDoctor);
        variables.put("doctorPercentage", doctorPercentage);
        variables.put("expensesFrom", expensesFrom);
        variables.put("automaticExpenses", automaticExpenses);
        variables.put("automatic", automaticPaid);
        variables.put("customFields", customFields);
        return variables;
    }
}