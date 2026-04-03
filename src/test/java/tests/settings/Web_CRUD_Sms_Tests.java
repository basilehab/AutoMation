package tests.settings;

import com.dentolize.dashboard.gui.pages.HomePage;
import engine.Helper;
import engine.dataDriven.FakerData;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;


@Epic("SMS Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_Sms_Tests extends WebBaseTests {
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;

    @BeforeClass(description = "Before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("sms.create");
        updateSuccessMessage = successMessages.getTestData("sms.update");
        deleteSuccessMessage = successMessages.getTestData("sms.delete");
    }

    @Test(description = "Verify that the owner can \"Create new Sms\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Sms_UserStory)
    @TmsLink(CRUD_Sms_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_SMS_requiredData() {
        new HomePage(driver).navigateToSmsPage()
                .clickOnCreateSms_btn()
                .enterSmsName(FakerData.getInstance().getFirstName() + Helper.getTimestamp())
                .enterSmsDetails(FakerData.getInstance().getTextLimit(200))
                .clickOnCreateForm_btn();
        //   Verifications.verifyTextForElement(driver, AutomaticTasksForm.successMessageText(), createSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Update Sms\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Sms_UserStory)
    @TmsLink(CRUD_Sms_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_SMS_requiredData() {
        new HomePage(driver).navigateToSmsPage()
                .clickOnUpdateSms_btn(1)
                .enterSmsDetails(FakerData.getInstance().getTextLimit(200))
                .clickOnUpdateForm_btn();
        //    Verifications.verifyTextForElement(driver, AutomaticTasksForm.successMessageText(), updateSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Delete Sms\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Sms_UserStory)
    @TmsLink(CRUD_Sms_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_SMS() {
        new HomePage(driver).navigateToSmsPage()
                .clickOnUpdateSms_btn(1)
                .clickOnDeleteForm_btn();
        //   Verifications.verifyTextForElement(driver, AutomaticTasksForm.successMessageText(), deleteSuccessMessage);
    }
}