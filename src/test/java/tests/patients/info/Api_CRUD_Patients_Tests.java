package tests.patients.info;

import com.dentolize.patients.info.api.PatientApis;
import com.shaft.api.RestActions;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.ApiBaseTests;

@Epic("Patients Module")
@Feature("API")
@Test(groups = {"apis"})
public class Api_CRUD_Patients_Tests extends ApiBaseTests {

    private PatientApis patientApis;
    String patient_id;
    JSONFileManager createPatientData, updatePatientData;
    @Story("As a User, I want to \"Create New Patient\"")
    @Test(description = "Verify the User can Add New Patient details")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test Cases")
    public void createNewPatient() {
        Response addNewPatientResponse = patientApis.createPatient(COOKIE, createPatientData, "addPatient");
        patient_id = RestActions.getResponseJSONValue(addNewPatientResponse, "data.addNewPatient.id");
        patientApis.validatePatientDetailsData(COOKIE, patient_id, createPatientData, "addPatient");
    }

    @Story("As a User, I want to \"Update Patients\"")
    @Test(alwaysRun = true, dependsOnMethods = "createNewPatient", description = "Verify the User can Edit patient")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test Cases")
    public void updatePatient() {
        patientApis.updatePatient(COOKIE, patient_id, updatePatientData, "updatePatient");
        patientApis.validatePatientDetailsData(COOKIE, patient_id, updatePatientData, "updatePatient");
    }

    @Story("As a User, I want to \"Disable Patient\"")
    @Test(dependsOnMethods = "updatePatient", description = "Verify the User can disable patients details")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test Cases")
    public void disableDetails() {
        patientApis.disablePatient(COOKIE, patient_id, true);
    }



    @BeforeClass
    public void loadTestData() {
        patientApis = new PatientApis(restActions);
        createPatientData = new JSONFileManager("src/test/resources/testDataFiles/patients/info/createPatient.json");
        updatePatientData = new JSONFileManager("src/test/resources/testDataFiles/patients/info/updatePatient.json");
    }

}



