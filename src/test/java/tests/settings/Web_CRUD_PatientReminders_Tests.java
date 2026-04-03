package tests.settings;

import com.dentolize.dashboard.gui.pages.HomePage;
import engine.dataDriven.FakerData;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;


@Epic("Prescription Templates Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_PatientReminders_Tests extends WebBaseTests {
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;

    @BeforeClass(description = "Before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("patientReminders.create");
        updateSuccessMessage = successMessages.getTestData("patientReminders.update");
        deleteSuccessMessage = successMessages.getTestData("patientReminders.delete");
    }

    @Test(description = "Verify that the owner can \"Create new Patient Reminder\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_PatientReminder_UserStory)
    @TmsLink(CRUD_PatientReminder_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_PatientReminder_requiredData() {
        new HomePage(driver).navigateToPatientRemindersPage()
                .clickOnCreateNewPatientReminder_btn()
                .enterPatientReminderRequiredData(FakerData.getInstance().getFirstName(), 1, "Days")
                .clickOnCreateForm_btn();
        //  Verifications.verifyTextForElement(driver, PatientRemindersForm.successMessageText(), createSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Update Patient Reminder\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_PatientReminder_UserStory)
    @TmsLink(CRUD_PatientReminder_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_PatientReminder_requiredData() {
        new HomePage(driver).navigateToPatientRemindersPage()
                .clickOnUpdatePatientReminder_btn(1)
                .enterPatientReminderDetails(FakerData.getInstance().getTextLimit(200))
                .clickOnUpdateForm_btn();
        //   Verifications.verifyTextForElement(driver, PatientRemindersForm.successMessageText(), updateSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Delete Patient Reminder\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_PatientReminder_UserStory)
    @TmsLink(CRUD_PatientReminder_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_PatientReminder() {
        new HomePage(driver).navigateToPatientRemindersPage()
                .clickOnUpdatePatientReminder_btn(1)
                .clickOnDeleteForm_btn();
        // Verifications.verifyTextForElement(driver, PatientRemindersForm.successMessageText(), deleteSuccessMessage);
    }
}