package tests.patients.info;

import com.dentolize.dashboard.gui.pages.HomePage;
import components.ConfirmationMessage;
import engine.Helper;
import engine.dataDriven.FakerData;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;


@Epic("Patients Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_Patients_Tests extends WebBaseTests {
    String patientCreated;
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;

    @BeforeClass(description = "Before class - Read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("patients.create");
        updateSuccessMessage = successMessages.getTestData("patients.update");
        deleteSuccessMessage = successMessages.getTestData("patients.delete");
    }

    @Test(description = "Verify that the owner can \"Create New Patient\" with required and valid Data")
    @Issues({@Issue("Dz9Qp3iT"), @Issue("Dz9Qp3iq")})
    @Story(CRUD_Patient_UserStory)
    @TmsLink(CRUD_Patient_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_newPatient_requiredData() {
        String patientRow = "Patient1";
        String firstName = patients_TD.getCellData(patientsSheet, patientRow, "First Name");
        String lastName = FakerData.getInstance().getLastName() + Helper.getTimestamp();
        this.patientCreated = firstName + " " + lastName;
        new HomePage(driver)
                .addNewPatientFromShortCut()
                .enterPatient_requiredData(firstName, lastName, "01" + FakerData.getInstance().getNumberLimit(9))
                .enterPatientDetails(FakerData.getInstance().getTextLimit(1000))
                .createPatientForm_btn();
        new ConfirmationMessage(driver)
                .confirmDuplicateNumber(patients_TD.getCellData(patientsSheet, patientRow, "Confirm Duplicate Number"))
                .confirmInvalidNumber(patients_TD.getCellData(patientsSheet, patientRow, "Confirm Invalid Number"))
                .confirmSendSms(patients_TD.getCellData(patientsSheet, patientRow, "Confirm Send SMS"));
        // Verifications.verifyTextForElement(driver, PatientForm.successMessageText(createSuccessMessage), createSuccessMessage);
    }


    @Test(description = "Verify that the owner can \"Update Patient\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Patient_UserStory)
    @TmsLink(CRUD_Patient_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_Patient_requiredData() {
        String patientRow = "Patient1";
        new HomePage(driver)
                .navigateToPatientsPage()
                .clickOnEditPatient_btn(1)
                .enterPatient_requiredData(FakerData.getInstance().getFirstName(), FakerData.getInstance().getLastName() + Helper.getTimestamp(), "01" + FakerData.getInstance().getNumberLimit(9))
                .enterPatientDetails(FakerData.getInstance().getTextLimit(200))
                .updatePatientForm_btn();
        new ConfirmationMessage(driver)
                .confirmDuplicateNumber(patients_TD.getCellData(patientsSheet, patientRow, "Confirm Duplicate Number"))
                .confirmInvalidNumber(patients_TD.getCellData(patientsSheet, patientRow, "Confirm Invalid Number"))
                .confirmSendSms(patients_TD.getCellData(patientsSheet, patientRow, "Confirm Send SMS"));
        //   Verifications.verifyTextForElement(driver, PatientForm.successMessageText(updateSuccessMessage), updateSuccessMessage);
    }


    @Test(description = "Verify that the owner can \"Delete New Patient\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Patient_UserStory)
    @TmsLink(CRUD_Patient_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_newPatient() {
        new HomePage(driver)
                .navigateToPatientsPage()
                .clickOnEditPatient_btn(1)
                .deletePatientForm_btn();
        // Verifications.verifyTextForElement(driver, PatientForm.successMessageText(deleteSuccessMessage), deleteSuccessMessage);
    }


    @Test(description = "Verify that the owner can \"Create New Patient\" with All valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Patient_UserStory)
    @TmsLink(CRUD_Patient_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_newPatient_AllData() {
        String patientRow = "Patient2";
        new HomePage(driver).navigateToPatientsPage()
                .clickOnNewPatient_btn()
                .enterPatientCustomId(FakerData.getInstance().getTextLimit(5) + FakerData.getInstance().getNumberLimit(3))
                .enterPatient_requiredData(
                        patients_TD.getCellData(patientsSheet, patientRow, "First Name"),
                        FakerData.getInstance().getLastName() + Helper.getTimestamp(),
                        "01" + FakerData.getInstance().getNumberLimit(9))
                .enterPatientPhoneNumber2("01" + FakerData.getInstance().getNumberLimit(9))
                .selectPatientCountry(patients_TD.getCellData(patientsSheet, patientRow, "Country"))
                //       .selectPatientBirthDate()
                .selectPatientTitle(patients_TD.getCellData(patientsSheet, patientRow, "Title"))
                .selectPatientGender(patients_TD.getCellData(patientsSheet, patientRow, "Gendar"))
                .enterPatientEmail(FakerData.getInstance().getEmail())
                //.selectPatientAddress("Egypt")
                .selectAssignedPractitioner(settings_TD.getCellData(usersSheet, "User1", "Name"))
                .selectPatientPriceList(settings_TD.getCellData(priceListSheet, "PriceList1", "Name"))
                .selectPatientTag(patients_TD.getCellData(patientsSheet, patientRow, "Tag"))
                .selectPatientMaterial(patients_TD.getCellData(patientsSheet, patientRow, "Material Status"))
                .selectPatientJob(patients_TD.getCellData(patientsSheet, patientRow, "Job"))
                .enterPatientTax(patients_TD.getCellData(patientsSheet, patientRow, "Tax"))
                .selectPatientCreatedAt()
                .enterPatientDetails(FakerData.getInstance().getTextLimit(1000))
                .uploadPatientProfilePicture(patients_TD.getCellData(patientsSheet, patientRow, "upload file"))
                //             .enterInsurance_requiredData(
//                        associates_TD.getCellData(insuranceCompanySheet, "Insurance1", "Name"),
//                        associates_TD.getCellData(insuranceCompanySheet, "Insurance1", "Limit"),
//                        associates_TD.getCellData(insuranceCompanySheet, "Insurance1", "Insurance Percentage"))
//                .enterInsuranceCompanyPhoneNumber("01" + FakerData.getNumberLimit(9))
//                .enterInsuranceMember("Member "+ FakerData.getFirstName() + Helper.getCurrentTime())
//                .enterInsuranceGroup("Group "+ FakerData.getFirstName() + Helper.getCurrentTime())
//                .enterInsuranceCRT("CRT "+ FakerData.getFirstName() + Helper.getCurrentTime())
//                .selectInsuranceStartMonth(associates_TD.getCellData(insuranceCompanySheet, "Insurance1", "January"))
//                .selectPatientReferral(patients_TD.getCellData(patientsSheet, patientRow, "referral"))
                .enterReferralDetails(FakerData.getInstance().getTextLimit(100))
                .enterEmergencyName(
                        FakerData.getInstance().getFirstName() + Helper.getTimestamp()
                        , FakerData.getInstance().getLastName() + Helper.getTimestamp()
                        , "01" + FakerData.getInstance().getNumberLimit(9)
                        , "01" + FakerData.getInstance().getNumberLimit(9))
                .enterEmergencyAddress(FakerData.getInstance().getStreetAddress())
                .selectEmergencyRelationship(patients_TD.getCellData(patientsSheet, patientRow, "relationship"))
                .createPatientForm_btn();
        new ConfirmationMessage(driver)
                .confirmDuplicateNumber(patients_TD.getCellData(patientsSheet, patientRow, "Confirm Duplicate Number"))
                .confirmInvalidNumber(patients_TD.getCellData(patientsSheet, patientRow, "Confirm Invalid Number"))
                .confirmSendSms(patients_TD.getCellData(patientsSheet, patientRow, "Confirm Send SMS"));
        //   Verifications.verifyTextForElement(driver, PatientForm.successMessageText(createSuccessMessage), createSuccessMessage);
    }
}
