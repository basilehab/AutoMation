package com.dentolize.settings.branch.api;

import com.shaft.driver.SHAFT;
import engine.ApiBase;
import engine.actions.GraphQlActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BranchesApis {
    private final SHAFT.API restActions;

    public BranchesApis(SHAFT.API restActions) {
        this.restActions = restActions;
    }

    @Step("Add New Branch")
    public Response addNewBranch(String cookie, String name, String address, List phones, List usersId, String defaultPriceListId, List availablePriceListsId, Float diagnosticFee, List rooms, List openDays, List opens, List closes, Boolean viewClosedTimes) {
        Map<String, Object> addNewBranch_Variables = new HashMap<>();
        addNewBranch_Variables.put("name", name);
        addNewBranch_Variables.put("address", address);
        addNewBranch_Variables.put("phones", phones);
        addNewBranch_Variables.put("users", usersId);
        addNewBranch_Variables.put("defaultPriceList", defaultPriceListId);
        addNewBranch_Variables.put("availablePriceLists", availablePriceListsId);
        addNewBranch_Variables.put("diagnosticFee", diagnosticFee);
        addNewBranch_Variables.put("rooms", rooms);
        addNewBranch_Variables.put("openDays", openDays);
        addNewBranch_Variables.put("opens", opens);
        addNewBranch_Variables.put("closes", closes);
        addNewBranch_Variables.put("viewClosedTimes", viewClosedTimes);
        return GraphQlActions.sendGraphQlRequest(ApiBase.BASE_URL, BranchesSchema.MUTATION_ADD_NEW_BRANCH,
                addNewBranch_Variables, "cookie", cookie, "uncrunch");
    }

    @Step("Edit Branch")
    public Response editBranch(String cookie, String branch, String name, String address, List phones, List users, String defaultPriceList, List availablePriceLists, Float diagnosticFee, List rooms, List openDays, List opens, List closes, Boolean viewClosedTimes) {
        Map<String, Object> editBranch_Variables = new HashMap<>();
        editBranch_Variables.put("branch", branch);
        editBranch_Variables.put("name", name);
        editBranch_Variables.put("address", address);
        editBranch_Variables.put("phones", phones);
        editBranch_Variables.put("users", users);
        editBranch_Variables.put("defaultPriceList", defaultPriceList);
        editBranch_Variables.put("availablePriceLists", availablePriceLists);
        editBranch_Variables.put("diagnosticFee", diagnosticFee);
        editBranch_Variables.put("rooms", rooms);
        editBranch_Variables.put("openDays", openDays);
        editBranch_Variables.put("opens", opens);
        editBranch_Variables.put("closes", closes);
        editBranch_Variables.put("viewClosedTimes", viewClosedTimes);
        return GraphQlActions.sendGraphQlRequest(ApiBase.BASE_URL, BranchesSchema.MUTATION_EDIT_BRANCH,
                editBranch_Variables, "cookie", cookie, "uncrunch");
    }

    @Step("Get Branch details")
    public Response getBranchDetails(String cookie, String branchId) {
        Map<String, Object> getBranchDetails_Variables = new HashMap<>();
        getBranchDetails_Variables.put("branch", branchId);
        return GraphQlActions.sendGraphQlRequest(ApiBase.BASE_URL, BranchesSchema.QUERY_BRANCH_DETAILS,
                getBranchDetails_Variables, "cookie", cookie, "uncrunch");
    }

    @Step("Get all Branches")
    public Response getAllBranches(String cookie, int skip, int take, String orderBy, String searchTerm, String id) {
        Map<String, Object> getBranches_Variables = new HashMap<>();
        getBranches_Variables.put("skip", skip);
        getBranches_Variables.put("take", take);
        getBranches_Variables.put("orderBy", orderBy);
        getBranches_Variables.put("searchTerm", searchTerm);
        getBranches_Variables.put("id", id);
        return GraphQlActions.sendGraphQlRequest(ApiBase.BASE_URL, BranchesSchema.QUERY_GET_BRANCHES,
                getBranches_Variables, "cookie", cookie, "uncrunch");
    }


    @Step("Disable Branch")
    public Response disableBranch(String cookie, String branchId, Boolean disabled) {
        Map<String, Object> disableBranch_Variables = new HashMap<>();
        disableBranch_Variables.put("branch", branchId);
        disableBranch_Variables.put("disabled", disabled);
        return GraphQlActions.sendGraphQlRequest(ApiBase.BASE_URL, BranchesSchema.MUTATION_DISABLE_BRANCH,
                disableBranch_Variables, "cookie", cookie, "uncrunch");
    }

}
