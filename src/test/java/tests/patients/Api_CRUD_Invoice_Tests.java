package tests.patients;

import com.dentolize.patients.invoice.api.InvoiceApis;
import com.dentolize.patients.operation.api.OperationApis;
import com.dentolize.search.SearchApis;
import com.shaft.api.RestActions;
import com.shaft.tools.io.JSONFileManager;
import engine.CustomReporter;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.ApiBaseTests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Epic("Invoice Module")
@Feature("API")
@Test(groups = {"apis"})
public class Api_CRUD_Invoice_Tests extends ApiBaseTests {
    List<String> operationIds;
    List<Object> itemsList;
    String invoice_id, operation_id;
    private JSONFileManager createInvoiceData, updateInvoiceData, createOperationData;
    private OperationApis operationApis;
    private InvoiceApis invoiceApis;

    @Story("As a User, I want to \"Create New Appointment\"")
    @Test(description = "Verify the User can Add New Appointment details")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test Cases")
    public void createNewAppointment() {
        getDataFromOperationResponse();
//        String patientName = createOperationData.getTestData("create_1.patient");
//        String chart = createOperationData.getTestData("create_1.chart");
//        Response getAllOperations = operationApis.readAllOperationsForPatient(COOKIE, patientName, chart);
//        // list of operation ids to be used in invoice creation
//        // listOfItems
//        Response addNewPatientResponse = invoiceApis.createInvoice(COOKIE, createInvoiceData, "create_1");
//        invoice_id = RestActions.getResponseJSONValue(addNewPatientResponse, "data.addNewInvoice.id");
//        invoiceApis.readAppointmentDetails(COOKIE, invoice_id);
    }


    @BeforeClass
    public void loadTestData() {
        searchApis = new SearchApis(restActions);
        operationApis = new OperationApis(restActions);
        invoiceApis = new InvoiceApis(restActions);
        createOperationData = new JSONFileManager("src/test/resources/testDataFiles/patients/operation/createOperation.json");
        createInvoiceData = new JSONFileManager("src/test/resources/testDataFiles/patients/invoice/createInvoice.json");
        updateInvoiceData = new JSONFileManager("src/test/resources/testDataFiles/patients/invoice/updateInvoice.json");

    }

    private static class InvoiceSummary {
        String id;
        int subtotal;
        int discount;
        int tax;
        int total;
        int insurance;
        int insuranceAfterTax;
        int discountPercent;
        int insurancePercent;
        int taxPercent;
        boolean taxApplied;
        boolean insured;
    }

    private List<InvoiceSummary> invoiceSummaries = new ArrayList<>();

    private void getDataFromOperationResponse() {
        Response getAllOperations = operationApis.readAllOperationsForPatient(COOKIE, "Betsey Kautzer", "dental");
        List<Object> responseMap = RestActions.getResponseJSONValueAsList(getAllOperations, "data.getPatientOperations");
        //CustomReporter.getInstance().logInfoStep(Objects.requireNonNull(responseMap).toString());
        operationIds = new ArrayList<>();
        itemsList = new ArrayList<>();
        for (int i = 0; i < responseMap.size(); i++) {
            String id = RestActions.getResponseJSONValue(getAllOperations, "data.getPatientOperations[" + i + "].id");
            String name = RestActions.getResponseJSONValue(getAllOperations, "data.getPatientOperations[" + i + "].name");
            String price = RestActions.getResponseJSONValue(getAllOperations, "data.getPatientOperations[" + i + "].price");
            String status = RestActions.getResponseJSONValue(getAllOperations, "data.getPatientOperations[" + i + "].status");
            CustomReporter.getInstance().logInfoStep("Operation ID: " + id + ", Name: " + name + ", Status: " + status);
            operationIds.add(id);
            itemsList.add(Map.of(
                    "id", id,
                    "name", name,
                    "price", price,
                    "status", status
            ));

        }
        CustomReporter.getInstance().logInfoStep("Items List: " + itemsList.toString());
        CustomReporter.getInstance().logInfoStep("Operation IDs List: " + operationIds.toString());

//        InvoiceSummary summary = null;
//        for (Object operationObj : responseMap) {
//            JSONObject operation = (JSONObject) operationObj;
//             summary = new InvoiceSummary();
//            summary.id = operation.getAsString("id");
//            summary.subtotal = ((Number) operation.get("subtotal")).intValue();
//            summary.discount = ((Number) operation.get("discount")).intValue();
//            summary.tax = ((Number) operation.get("tax")).intValue();
//            summary.total = ((Number) operation.get("total")).intValue();
//            summary.insurance = ((Number) operation.get("insurance")).intValue();
//            summary.insuranceAfterTax = ((Number) operation.get("insuranceAfterTax")).intValue();
//            summary.discountPercent = ((Number) operation.get("discountPercent")).intValue();
//            summary.insurancePercent = ((Number) operation.get("insurancePercent")).intValue();
//            summary.taxPercent = ((Number) operation.get("taxPercent")).intValue();
//            // summary.taxApplied = (Boolean) operation.get("taxApplied");
//            // summary.insured = (Boolean) operation.get("insured");
//            invoiceSummaries.add(summary);
//        }


    }

}



