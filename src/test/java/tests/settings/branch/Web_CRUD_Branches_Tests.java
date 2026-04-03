package tests.settings.branch;

import com.dentolize.dashboard.gui.pages.HomePage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;


@Epic("User Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_Branches_Tests extends WebBaseTests {
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;

    @BeforeClass(description = "Before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("branch.create");
        updateSuccessMessage = successMessages.getTestData("branch.update");
        deleteSuccessMessage = successMessages.getTestData("branch.delete");
    }

    @Test(description = "Verify that the owner can \"Create new Branch\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Branch_UserStory)
    @TmsLink(CRUD_Branch_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_newBranch_requiredData() {
        new HomePage(driver).navigateToBranchesPage()
                .clickOnCreateNewBranch_btn()
                .clickOnCreateForm_btn();
        //    Verifications.verifyTextForElement(driver, BranchForm.successMessageText(createSuccessMessage), createSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Update Branch\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Branch_UserStory)
    @TmsLink(CRUD_Branch_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_Branch_requiredData() {
        new HomePage(driver).navigateToBranchesPage()
                .clickOnUpdateBranch_btn(1)
                .clickOnUpdateForm_btn();
        //  Verifications.verifyTextForElement(driver, BranchForm.successMessageText(updateSuccessMessage), updateSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Disable Branch\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Branch_UserStory)
    @TmsLink(CRUD_Branch_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_Branch_requiredData() {
        new HomePage(driver).navigateToBranchesPage()
                .clickOnUpdateBranch_btn(1)
                .clickOnDisableForm_btn();
        //   Verifications.verifyTextForElement(driver, BranchForm.successMessageText(deleteSuccessMessage), deleteSuccessMessage);
    }
}