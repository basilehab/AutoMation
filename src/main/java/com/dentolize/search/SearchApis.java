package com.dentolize.search;

import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import engine.CustomReporter;
import engine.actions.GraphQlActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class SearchApis {
    private final SHAFT.API restActions;
    private final String searchTerm = "searchTerm";

    public SearchApis(SHAFT.API restActions) {
        this.restActions = restActions;
    }

    public Response searchBranches(String cookie, String branchName) {
        return GraphQlActions.sendGraphQlRequest(SearchSchema.getInstance().BRANCHES_QUERY_SEARCH, Map.of(searchTerm, branchName), cookie);
    }

    @Step("Get branch id by name [ {branchName} ] ")
    public String getBranchId(String cookie, String branchName) {
        Response searchResponse = searchBranches(cookie, branchName);
        return RestActions.getResponseJSONValue(searchResponse, "data.searchBranches[0].id");
    }

    public Response searchUsers(String cookie, String userName) {
        return GraphQlActions.sendGraphQlRequest(SearchSchema.getInstance().USERS_QUERY_SEARCH, Map.of(searchTerm, userName), cookie);
    }

    @Step("Get User id by name [ {userName} ] ")
    public String getUserId(String cookie, String userName) {
        if (userName != null && !userName.isEmpty()) {
            Response searchResponse = searchUsers(cookie, userName);
            return RestActions.getResponseJSONValue(searchResponse, "data.searchUsers[0].id");
        } else {
            CustomReporter.getInstance().logInfoStep("User name is empty, returning empty string as user id");
        }
        return "";
    }

    public Response searchPatient(String cookie, String searchPatient) {
        return GraphQlActions.sendGraphQlRequest(SearchSchema.getInstance().PATIENT_QUERY_SEARCH, Map.of(searchTerm, searchPatient), cookie);
    }

    @Step("Get patient id by name [ {patientName} ] ")
    public String getPatientId(String cookie, String patientName) {
        if (patientName != null && !patientName.isEmpty()) {
            Response searchResponse = searchPatient(cookie, patientName);
            return RestActions.getResponseJSONValue(searchResponse, "data.searchPatients[0].id");
        } else {
            CustomReporter.getInstance().logInfoStep("Patient name is empty, returning empty string as patent id");
        }
        return "";
    }

    public Response searchProcedures(String cookie, String chartType, String procedureName) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("chartType", chartType);
        variables.put("searchTerm", procedureName);
        return GraphQlActions.sendGraphQlRequest(SearchSchema.getInstance().PROCEDURES_QUERY_SEARCH, variables, cookie);
    }

    @Step("Get Procedure id by name [ {procedureName} ] from chart type [ {chartType} ] ")
    public String getProcedureId(String cookie, String chartType, String procedureName) {
        if (procedureName != null && !procedureName.isEmpty()) {
            Response searchResponse = searchProcedures(cookie, chartType, procedureName);
            return RestActions.getResponseJSONValue(searchResponse, "data.searchProcedures[0].id");
        } else {
            CustomReporter.getInstance().logInfoStep("procedureName name is empty, returning empty string as procedure id");
        }
        return "";
    }

    public Response searchPriceList(String cookie, String searchPriceList) {
        return GraphQlActions.sendGraphQlRequest(SearchSchema.getInstance().PRICE_LIST_QUERY_SEARCH, Map.of(searchTerm, searchPriceList), cookie);
    }

    @Step("Get price list id by name [ {priceListName} ] ")
    public String getPriceListId(String cookie, String priceListName) {
        if (priceListName != null && !priceListName.isEmpty()) {
            Response searchResponse = searchPriceList(cookie, priceListName);
            return RestActions.getResponseJSONValue(searchResponse, "data.searchPriceLists[0].id");
        } else {
            CustomReporter.getInstance().logInfoStep("priceListName name is empty, returning empty string as priceList id");
        }
        return "";
    }

    public Response searchInsuranceCompany(String cookie, String searchInsurance) {
        return GraphQlActions.sendGraphQlRequest(SearchSchema.getInstance().INSURANCE_QUERY_SEARCH, Map.of(searchTerm, searchInsurance), cookie);
    }

    @Step("Get insurance id by name [ {searchInsurance} ] ")
    public String getInsuranceId(String cookie, String searchInsurance) {
        if (searchInsurance != null && !searchInsurance.isEmpty()) {
            Response searchResponse = searchInsuranceCompany(cookie, searchInsurance);
            return RestActions.getResponseJSONValue(searchResponse, "data.searchInsuranceCompanies[0].id");
        } else {
            CustomReporter.getInstance().logInfoStep("searchInsurance name is empty, returning empty string as Insurance id");
        }
        return "";
    }

    @Step("Search for Permission Groups [ {permissionGroupName} ] ")
    public Response searchPermissionGroups(String cookie, String permissionGroupName) {
        return GraphQlActions.sendGraphQlRequest(SearchSchema.getInstance().PERMISSION_GROUP_QUERY_SEARCH, Map.of(searchTerm, permissionGroupName), cookie);
    }

    @Step("Search for Inventory [ {searchInventory} ] ")
    public Response searchInventory(String cookie, String searchInventory) {
        return GraphQlActions.sendGraphQlRequest(SearchSchema.getInstance().QUERY_SEARCH_INVENTORIES, Map.of(searchTerm, searchInventory), cookie);
    }

    @Step("Search for Master Inventory [ {searchMasterInventory} ] ")
    public Response searchMasterInventory(String cookie, String searchMasterInventory) {
        return GraphQlActions.sendGraphQlRequest(SearchSchema.getInstance().QUERY_SEARCH_MASTER_INVENTORIES, Map.of(searchTerm, searchMasterInventory), cookie);
    }

    @Step("Search for Labs [ {searchLabs} ] ")
    public Response searchLabs(String cookie, String searchLabs) {
        return GraphQlActions.sendGraphQlRequest(SearchSchema.getInstance().LABS_QUERY_SEARCH, Map.of(searchTerm, searchLabs), cookie);
    }

    @Step("Search for Labs Item  [ {searchLabsItem} ] ")
    public Response searchLabsItem(String cookie, String searchLabsItem) {
        return GraphQlActions.sendGraphQlRequest(SearchSchema.getInstance().LABS_ITEM_QUERY_SEARCH, Map.of(searchTerm, searchLabsItem), cookie);
    }

}
