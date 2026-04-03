package tests.settings;

import com.dentolize.dashboard.gui.pages.HomePage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;


@Epic("User Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_Users_Tests extends WebBaseTests {
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;

    @BeforeClass(description = "Before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("users.create");
        updateSuccessMessage = successMessages.getTestData("users.update");
        deleteSuccessMessage = successMessages.getTestData("users.delete");
    }

    @Test(description = "Verify that the owner can \"Create User\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_User_UserStory)
    @TmsLink(CRUD_User_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_newUser_requiredData() {
        new HomePage(driver)
                .navigateToUsersPage()
                .clickOnNewUser_btn()
                .clickOnCreateForm_btn();
        //     Verifications.verifyTextForElement(driver, UserForm.successMessageText(createSuccessMessage), createSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Update User\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_User_UserStory)
    @TmsLink(CRUD_User_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_User_requiredData() {
        new HomePage(driver)
                .navigateToUsersPage()
                .clickOnUpdateUser_btn(1)
                .clickOnUpdateForm_btn();
        //   Verifications.verifyTextForElement(driver, UserForm.successMessageText(updateSuccessMessage), updateSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Disable User\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_User_UserStory)
    @TmsLink(CRUD_User_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_User_requiredData() {
        new HomePage(driver)
                .navigateToUsersPage()
                .clickOnUpdateUser_btn(1)
                .clickOnDisableForm_btn();
        //   Verifications.verifyTextForElement(driver, UserForm.successMessageText(deleteSuccessMessage), deleteSuccessMessage);
    }
}