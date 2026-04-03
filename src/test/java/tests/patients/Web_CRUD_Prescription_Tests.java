package tests.patients;

import com.dentolize.dashboard.gui.pages.HomePage;
import components.ConfirmationMessage;
import engine.dataDriven.FakerData;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;

@Epic("Prescription Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_Prescription_Tests extends WebBaseTests {
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;

    @BeforeClass(description = "Before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("prescriptions.create");
        updateSuccessMessage = successMessages.getTestData("prescriptions.update");
        deleteSuccessMessage = successMessages.getTestData("prescriptions.delete");
    }

    @Test(description = "Verify that the owner can \"Create New Prescription \" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Prescription_UserStory)
    @TmsLink(CRUD_Prescription_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_newPrescription_requiredData() {
        new HomePage(driver)
                .addPrescriptionFromShortCut()
                .enterPrescriptionDetails(FakerData.getInstance().getTextLimit(500))
                .clickOnCreatePrescription_btn();
        new ConfirmationMessage(driver)
                .confirmSendSms("Yes");
        // Verifications.verifyTextForElement(driver, PrescriptionForm.successMessageText(createSuccessMessage), createSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Update Prescription\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Prescription_UserStory)
    @TmsLink(CRUD_Prescription_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_Prescription_requiredData() {
        new HomePage(driver).navigateToPrescriptionsPage()
                .clickOnEditPrescription_btn(1)
                .enterPrescriptionDetails(FakerData.getInstance().getTextLimit(200))
                .clickOnUpdatePrescription_btn();
        // Verifications.verifyTextForElement(driver, PrescriptionForm.successMessageText(updateSuccessMessage), updateSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Delete Prescription\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Prescription_UserStory)
    @TmsLink(CRUD_Prescription_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_Prescription_requiredData() {
        new HomePage(driver).navigateToPrescriptionsPage()
                .clickOnEditPrescription_btn(1)
                .clickOnDeletePrescription_btn();
        // Verifications.verifyTextForElement(driver, PrescriptionForm.successMessageText(deleteSuccessMessage), deleteSuccessMessage);
    }
}
