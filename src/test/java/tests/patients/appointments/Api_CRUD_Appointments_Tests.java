package tests.patients.appointments;

import com.dentolize.patients.appointments.api.AppointmentApis;
import com.dentolize.search.SearchApis;
import com.shaft.api.RestActions;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.ApiBaseTests;

@Epic("Appointments Module")
@Feature("API")
@Test(groups = {"apis"})
public class Api_CRUD_Appointments_Tests extends ApiBaseTests {
    private String appointment_id;
    private JSONFileManager createAppointmentData, updateAppointmentData;
    private AppointmentApis appointmentApis;

    @Story("As a User, I want to \"Create New Appointment\"")
    @Test(description = "Verify the User can Add New Appointment details")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test Cases")
    public void createNewAppointment() {
        Response addNewPatientResponse = appointmentApis.createAppointment(COOKIE, createAppointmentData, "add_1");
        appointment_id = RestActions.getResponseJSONValue(addNewPatientResponse, "data.addNewAppointment.id");
        appointmentApis.readAppointmentDetails(COOKIE, appointment_id);
    }

    @Story("As a User, I want to \"Update Appointment\"")
    @Test(dependsOnMethods = "createNewAppointment", description = "Verify the User can Edit Appointment")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test Cases")
    public void updateAppointment() {
        appointmentApis.updateAppointment(COOKIE, appointment_id, updateAppointmentData, "update_1");
        appointmentApis.collectDiagnosticFee(COOKIE, appointment_id, updateAppointmentData, "update_1");
    }

    @Story("As a User, I want to \"Delete Appointment \"")
    @Test(dependsOnMethods = "updateAppointment", description = "Verify the User can Delete Appointment")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test Cases")
    public void deleteAppointment() {
        searchApis = new SearchApis(restActions);
        String branchId = searchApis.getBranchId(COOKIE, updateAppointmentData.getTestData("update_1.branch"));
        appointmentApis.deleteAppointment(COOKIE, appointment_id, branchId);
    }


    @BeforeClass
    public void loadTestData() {
        appointmentApis = new AppointmentApis(restActions);
        createAppointmentData = new JSONFileManager("src/test/resources/testDataFiles/patients/appointment/createAppointment.json");
        updateAppointmentData = new JSONFileManager("src/test/resources/testDataFiles/patients/appointment/updateAppointment.json");
    }

}
