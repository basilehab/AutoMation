package tests.settings;

import com.dentolize.dashboard.gui.pages.HomePage;
import engine.Helper;
import engine.dataDriven.FakerData;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;


@Epic("Free Form Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_FreeForms_Tests extends WebBaseTests {
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;

    @BeforeClass(description = "Before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("freeForm.create");
        updateSuccessMessage = successMessages.getTestData("freeForm.update");
        deleteSuccessMessage = successMessages.getTestData("freeForm.delete");
    }

    @Test(description = "Verify that the owner can \"Create new Free Form\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_FreeForm_UserStory)
    @TmsLink(CRUD_FreeForm_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_FreeForm_requiredData() {
        new HomePage(driver).navigateToFreeFormsPage()
                .clickOnCreateNewFreeForm_btn()
                .enterFreeFormName(FakerData.getInstance().getFirstName() + Helper.getTimestamp())
                .enterFreeFormDetails(FakerData.getInstance().getTextLimit(200))
                .clickOnCreateForm_btn();
        //  Verifications.verifyTextForElement(driver, PatientRemindersForm.successMessageText(), createSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Update Free Form\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_FreeForm_UserStory)
    @TmsLink(CRUD_FreeForm_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_FreeForm_requiredData() {
        new HomePage(driver).navigateToFreeFormsPage()
                .clickOnUpdateFreeForm_btn(1)
                .enterFreeFormDetails(FakerData.getInstance().getTextLimit(200))
                .clickOnUpdateForm_btn();
        //  Verifications.verifyTextForElement(driver, PatientRemindersForm.successMessageText(), updateSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Delete Free Form\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_FreeForm_UserStory)
    @TmsLink(CRUD_FreeForm_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_FreeForm() {
        new HomePage(driver).navigateToFreeFormsPage()
                .clickOnUpdateFreeForm_btn(1)
                .clickOnDeleteForm_btn();
        //  Verifications.verifyTextForElement(driver, PatientRemindersForm.successMessageText(), deleteSuccessMessage);
    }
}