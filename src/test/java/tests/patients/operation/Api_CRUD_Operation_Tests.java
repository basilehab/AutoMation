package tests.patients.operation;

import com.dentolize.patients.operation.api.OperationActionsApis;
import com.dentolize.patients.operation.api.OperationApis;
import com.dentolize.patients.operation.api.OperationStepsApis;
import com.dentolize.search.SearchApis;
import com.shaft.tools.io.JSONFileManager;
import engine.CustomReporter;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.ApiBaseTests;

import java.util.ArrayList;
import java.util.List;

@Epic("Operation Module")
@Feature("API")
@Test(groups = {"apis"})
public class Api_CRUD_Operation_Tests extends ApiBaseTests {
    private List<String> operationIds;
    private String operation_id;
    private JSONFileManager createOperationData, updateOperationData, updateOperationStatusData, updateOperationPriceData, updateOperationSteps;
    private OperationApis operationApis;
    private OperationActionsApis operationActionsApis;
    private OperationStepsApis operationStepsApis;

    @Story("As a User, I want to \"Create New Operation\"")
    @Test(description = "Verify the User can Add New Operation details")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test Cases")
    public void createNewOperation() {
        Response addFirstOperation = operationApis.createOperation(COOKIE, createOperationData, "create_1");
        operation_id = operationApis.getCreatedOperationId(addFirstOperation);
        operationIds.add(operation_id);
        operationApis.readOperationDetails(COOKIE, operation_id);
        Response addSecondOperation = operationApis.createOperation(COOKIE, createOperationData, "create_2");
        String operation_id_2 = operationApis.getCreatedOperationId(addSecondOperation);
        operationIds.add(operation_id_2);
        operationApis.readOperationDetails(COOKIE, operation_id_2);
    }

    @Story("As a User, I want to \"Update Operation\"")
    @Test(dependsOnMethods = "createNewOperation", description = "Verify the User can Update Operation details")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test Cases")
    public void updateOperation() {
        CustomReporter.getInstance().logInfoStep("Total Operations to be updated: [ " + operationIds.size() + " ]");
        for (String operationId : operationIds) {
            CustomReporter.getInstance().logInfoStep("--- Update Operation ID: [ " + operationId + " ] ---");
            // Update Operation
            operationApis.updateOperation(COOKIE, operationId, updateOperationData, "update_1");
            Response operationDetailsresponse = operationApis.readOperationDetails(COOKIE, operationId);
            // Get Operation Step ID
            String operationStepId = operationStepsApis.getEditOperationStepId(operationDetailsresponse);
            operationStepsApis.readOperationStepsDetails(COOKIE, operationStepId);
            // Update Operation Step
            operationStepsApis.updateOperationSteps(COOKIE, operationStepId, "", updateOperationSteps, "update_steps_1");
            operationStepsApis.readOperationStepsDetails(COOKIE, operationStepId);
        }
        // Update Operation Status
        operationActionsApis.updateOperationStatus(COOKIE, operationIds, updateOperationStatusData, "update_status_1");
        // Update Operation Price and Amount
        operationActionsApis.updateOperationPriceAndAmount(COOKIE, operationIds, updateOperationPriceData, "update_price_1");
    }

    @Story("As a User, I want to \"Delete Operation \"")
    @Test(enabled = false, dependsOnMethods = "updateOperation", description = "Verify the User can Delete Operation")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test Cases")
    public void deleteOperation() {
        operationApis.deleteOperation(COOKIE, operation_id);
    }


    @BeforeClass
    public void loadTestData() {
        searchApis = new SearchApis(restActions);
        operationApis = new OperationApis(restActions);
        operationActionsApis = new OperationActionsApis(restActions);
        operationStepsApis = new OperationStepsApis(restActions);
        operationIds = new ArrayList<>();
        createOperationData = new JSONFileManager("src/test/resources/testDataFiles/patients/operation/createOperation.json");
        updateOperationData = new JSONFileManager("src/test/resources/testDataFiles/patients/operation/updateOperation.json");
        updateOperationStatusData = new JSONFileManager("src/test/resources/testDataFiles/patients/operation/updateOperationStatus.json");
        updateOperationPriceData = new JSONFileManager("src/test/resources/testDataFiles/patients/operation/updateOperationPrice.json");
        updateOperationSteps = new JSONFileManager("src/test/resources/testDataFiles/patients/operation/updateOperationSteps.json");
    }

}



