package tests.settings;

import com.dentolize.dashboard.gui.pages.HomePage;
import engine.Helper;
import engine.dataDriven.FakerData;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;


@Epic("Prescription Templates Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_PrescriptionTemplates_Tests extends WebBaseTests {
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;

    @BeforeClass(description = "Before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("prescriptionTemplates.create");
        updateSuccessMessage = successMessages.getTestData("prescriptionTemplates.update");
        deleteSuccessMessage = successMessages.getTestData("prescriptionTemplates.delete");
    }

    @Test(description = "Verify that the owner can \"Create new Prescription Template\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_PrescriptionTemplates_UserStory)
    @TmsLink(CRUD_PrescriptionTemplates_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_PrescriptionTemplate_requiredData() {
        new HomePage(driver).navigateToPrescriptionTemplatesPage()
                .clickOnCreateNewPrescriptionTemplate_btn()
                .enterPrescriptionTemplateName(FakerData.getInstance().getFirstName())
                .selectMedicationName("Alphintern")
                .clickOnCreateForm_btn();
        //   Verifications.verifyTextForElement(driver, PrescriptionTemplatesForm.successMessageText(createSuccessMessage), createSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Update Prescription Template\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_PrescriptionTemplates_UserStory)
    @TmsLink(CRUD_PrescriptionTemplates_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_PrescriptionTemplate_requiredData() {
        new HomePage(driver).navigateToPrescriptionTemplatesPage()
                .clickOnUpdatePrescriptionTemplate_btn(1)
                .enterPrescriptionTemplateName(FakerData.getInstance().getFirstName() + Helper.getTimestamp())
                .clickOnUpdateForm_btn();
        // Verifications.verifyTextForElement(driver, PrescriptionTemplatesForm.successMessageText(updateSuccessMessage), updateSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Delete Prescription Template\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_PrescriptionTemplates_UserStory)
    @TmsLink(CRUD_PrescriptionTemplates_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_PrescriptionTemplate() {
        new HomePage(driver).navigateToPrescriptionTemplatesPage()
                .clickOnUpdatePrescriptionTemplate_btn(1)
                .clickOnDeleteForm_btn();
        // Verifications.verifyTextForElement(driver, PrescriptionTemplatesForm.successMessageText(deleteSuccessMessage), deleteSuccessMessage);
    }
}