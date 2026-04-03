package tests.settings;

import com.dentolize.search.SearchApis;
import com.dentolize.settings.procedures.api.ProceduresApi;
import com.shaft.api.RestActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.ApiBaseTests;
import engine.Helper;


import java.util.List;

@Epic( "Settings >> Procedures" )
@Feature( "API" )
@Test( groups = {"apis"} )
public class Api_CRUD_Procedures_Tests extends ApiBaseTests {
    @Story( "As a User, I want to \"Add New Procedures Group\"" )
    @Test( description = "Verify the User can Add Procedures Group" )
    @Severity( SeverityLevel.CRITICAL )
    @TmsLink( "Test Cases" )
    public void addNewProceduresGroup() {
        Response addNewProceduresGroupResponse = proceduresApi.addNewProceduresGroup(COOKIE, name, code, image, order);
        procedureGroup_id = RestActions.getResponseJSONValue(addNewProceduresGroupResponse, "data.addNewProcedureGroup.id");
        Validations.verifyThat().response(addNewProceduresGroupResponse).extractedJsonValue("data.addNewProcedureGroup.id").isEqualTo(procedureGroup_id).perform();
        Validations.verifyThat().response(addNewProceduresGroupResponse).extractedJsonValue("data.addNewProcedureGroup.name").isEqualTo(name).perform();
        Validations.verifyThat().response(addNewProceduresGroupResponse).extractedJsonValue("data.addNewProcedureGroup.code").isEqualTo(code).perform();
        Validations.verifyThat().response(addNewProceduresGroupResponse).extractedJsonValue("data.addNewProcedureGroup.image").isEqualTo(image).perform();
        int orderR = Integer.parseInt(RestActions.getResponseJSONValue(addNewProceduresGroupResponse, "data.addNewProcedureGroup.order"));
        Validations.verifyThat().number(orderR).isEqualTo(order).perform();
    }


    @Story( "As a User, I want to \"Edit Procedures Group\"" )
    @Test( dependsOnMethods = "addNewProceduresGroup", description = "Verify the User can Edit Procedures Group" )
    @Severity( SeverityLevel.CRITICAL )
    @TmsLink( "Test Cases" )
    public void editProceduresGroup() {
        Response editProceduresGroupResponse = proceduresApi.editProceduresGroup(COOKIE, procedureGroup_id, _name, _code, _image, _order);
        Validations.verifyThat().response(editProceduresGroupResponse).extractedJsonValue("data.editProcedureGroup.id").isEqualTo(procedureGroup_id).perform();
        Validations.verifyThat().response(editProceduresGroupResponse).extractedJsonValue("data.editProcedureGroup.name").isEqualTo(_name).perform();
        Validations.verifyThat().response(editProceduresGroupResponse).extractedJsonValue("data.editProcedureGroup.code").isEqualTo(_code).perform();
        Validations.verifyThat().response(editProceduresGroupResponse).extractedJsonValue("data.editProcedureGroup.image").isEqualTo(_image).perform();
        int _orderR = Integer.parseInt(RestActions.getResponseJSONValue(editProceduresGroupResponse, "data.editProcedureGroup.order"));
        Validations.verifyThat().number(_orderR).isEqualTo(_order).perform();
    }


    @Story( "As a User, I want to \"Delete Procedures Group\"" )
    @Test( dependsOnMethods = "editProceduresGroup", description = "Verify the User can Delete Procedures Group" )
    @Severity( SeverityLevel.CRITICAL )
    @TmsLink( "Test Cases" )
    public void deleteProceduresGroup() {
        Response deleteProceduresGroup = proceduresApi.deleteProceduresGroup(COOKIE, procedureGroup_id);
        Validations.verifyThat().response(deleteProceduresGroup).extractedJsonValue("data.deleteProcedureGroup.id").isEqualTo(procedureGroup_id);
    }

    //*****************************************************//
    //********************// Set Up //*********************//
    //*****************************************************//

    private ProceduresApi proceduresApi;
    String procedureGroup_id, name, code, image, _name, _code, _image;
    int order, _order;
    List<List<String>> procedures, _procedures;

    @BeforeClass
    public void loadTestData() {
        searchApis = new SearchApis(restActions);
        proceduresApi = new ProceduresApi(restActions);
        JSONFileManager procedures_TD = new JSONFileManager(System.getProperty("procedureApisJson"));
        // Test Data for add procedures Group
        name = procedures_TD.getTestData("procedureGroup1.name") + Helper.getTimestamp();
        code = procedures_TD.getTestData("procedureGroup1.code");
        image = procedures_TD.getTestData("procedureGroup1.image");
        order = Integer.parseInt(procedures_TD.getTestData("procedureGroup1.order"));
        procedures = (List<List<String>>) procedures_TD.getTestDataAsList("procedures");
        // Test Data for edit procedures Group
        _name = procedures_TD.getTestData("procedureGroup2.name") + Helper.getTimestamp();
        _code = procedures_TD.getTestData("procedureGroup2.code");
        _image = procedures_TD.getTestData("procedureGroup2.image");
        _order = Integer.parseInt(procedures_TD.getTestData("procedureGroup2.order"));
        _procedures = (List<List<String>>) procedures_TD.getTestDataAsList("procedureGroup2.procedures[0]");
    }

}

