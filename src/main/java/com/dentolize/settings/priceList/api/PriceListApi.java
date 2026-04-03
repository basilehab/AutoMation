package com.dentolize.settings.priceList.api;

import com.shaft.driver.SHAFT;
import engine.actions.GraphQlActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceListApi {
    private final SHAFT.API restActions;

    public PriceListApi(SHAFT.API restActions) {
        this.restActions = restActions;
    }

    @Step("Add Price List")
    public Response addNewPriceList(String cookie, String name, List branchIds, String syncToPriceListId, Boolean keepInSync, String whichWay, int discount) {
        Map<String, Object> variables = createVariables(name, branchIds, syncToPriceListId, keepInSync, whichWay, discount);
        return GraphQlActions.sendGraphQlRequest(PriceListSchema.getInstance().MUTATION_ADD_PRICE_LIST, variables, cookie);
    }

    @Step("Edit Price List")
    public Response editPriceList(String cookie, String priceListId, String name, List branchIds, String syncToPriceListId, Boolean keepInSync, String whichWay, int discount) {
        Map<String, Object> variables = createVariables(name, branchIds, syncToPriceListId, keepInSync, whichWay, discount);
        variables.put("priceList", priceListId);
        return GraphQlActions.sendGraphQlRequest(PriceListSchema.getInstance().MUTATION_EDIT_PRICE_LISTS, variables, cookie);
    }

    @Step("Delete Price List")
    public Response deletePriceList(String cookie, String priceListId) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("priceList", priceListId);
        return GraphQlActions.sendGraphQlRequest(PriceListSchema.getInstance().MUTATION_DELETE_PRICE_LISTS, variables, cookie);
    }

    private Map<String, Object> createVariables(String name, List branchIds, String syncToPriceListId, Boolean keepInSync, String whichWay, int discount) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("name", name);
        variables.put("branches", branchIds);
        variables.put("syncTo", syncToPriceListId);
        variables.put("keepInSync", keepInSync);
        variables.put("whichWay", whichWay);
        variables.put(whichWay.equals("percentage") ? "percentage" : "difference", discount);
        return variables;
    }
}