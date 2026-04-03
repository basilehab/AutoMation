package com.dentolize.settings.procedures.api;

import com.shaft.driver.SHAFT;
import engine.actions.GraphQlActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProceduresApi {
    private final SHAFT.API restActions;

    public ProceduresApi(SHAFT.API restActions) {
        this.restActions = restActions;
    }

    @Step("Add Procedures Group")
    public Response addNewProceduresGroup(String cookie, String name, String code, String image, int order) {
        return sendRequest(ProceduresSchema.getInstance().MUTATION_ADD_PROCEDURE_GROUP, cookie,
                Map.of("name", name, "code", code, "image", image, "order", order));
    }

    @Step("Edit Procedures Group")
    public Response editProceduresGroup(String cookie, String procedureGroupId, String name, String code, String image, int order) {
        return sendRequest(ProceduresSchema.getInstance().MUTATION_EDIT_PROCEDURE_GROUP, cookie,
                Map.of("procedureGroup", procedureGroupId, "name", name, "code", code, "image", image, "order", order));
    }

    @Step("Delete Procedures Group")
    public Response deleteProceduresGroup(String cookie, String proceduresGroupId) {
        return sendRequest(ProceduresSchema.getInstance().MUTATION_DELETE_PROCEDURE_GROUP, cookie,
                Map.of("procedureGroup", proceduresGroupId));
    }

    @Step("Save Procedures")
    public Response saveProcedures(String cookie, List<List<String>> procedures) {
        return sendRequest(ProceduresSchema.getInstance().MUTATION_SAVE_PROCEDURES, cookie,
                Map.of("procedures", procedures));
    }

    @Step("Delete Procedures")
    public Response deleteProcedures(String cookie, String proceduresId) {
        return sendRequest(ProceduresSchema.getInstance().MUTATION_DELETE_PROCEDURE, cookie,
                Map.of("procedure", proceduresId));
    }

    private Response sendRequest(String mutation, String cookie, Map<String, Object> variables) {
        return GraphQlActions.sendGraphQlRequest(mutation, variables, cookie);
    }
}