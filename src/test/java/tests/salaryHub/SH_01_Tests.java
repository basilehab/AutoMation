package tests.salaryHub;

import com.dentolize.authentication.api.AuthenticationApi;
import com.dentolize.patients.appointments.api.AppointmentApis;
import com.dentolize.patients.info.api.PatientApis;
import com.dentolize.search.SearchApis;
import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



@Epic("Salary Hub Module")
@Test(groups = {"apis"})
public class SH_01_Tests  {
    private SHAFT.API restActions;
    private static String COOKIE;
    private String patient_id, appointment_id;
    private JSONFileManager SH_01_TD;
    private AuthenticationApi authenticationApi;
    private SearchApis searchApis;
    private PatientApis patientApis;
    private AppointmentApis appointmentApis;

    @Story("As a User, I want to \"Create New Patient\"")
    @Test(description = "Verify the User can Add New Patient details")
    public void createNewPatient() {
        Response addNewPatientResponse = patientApis.createPatient(COOKIE, createPatientData, "addPatient");
        patient_id = RestActions.getResponseJSONValue(addNewPatientResponse, "data.addNewPatient.id");
        patientApis.validatePatientDetailsData(COOKIE, patient_id, createPatientData, "addPatient");
    }


    @Story("As a User, I want to \"Create New Appointment\"")
    @Test(description = "Verify the User can Add New Appointment details")
    public void createNewAppointment() {
        Response addNewPatientResponse = appointmentApis.createAppointment(COOKIE, createAppointmentData, "add_1");
        appointment_id = RestActions.getResponseJSONValue(addNewPatientResponse, "data.addNewAppointment.id");
        appointmentApis.readAppointmentDetails(COOKIE, appointment_id);
    }

    @BeforeClass
    public void loadTestData() {
        authenticationApi = new AuthenticationApi(restActions);
        SHAFT.TestData.JSON users_TD = new SHAFT.TestData.JSON(System.getProperty("loginJsonData"));
        COOKIE = authenticationApi.signInViaEmail(users_TD.getTestData("owner.email"), users_TD.getTestData("owner.password"));
        patientApis = new PatientApis(restActions);
        appointmentApis = new AppointmentApis(restActions);
        SH_01_TD = new JSONFileManager("src/test/resources/testDataFiles/salaryHub/SH_01_TD.json");
    }
}
