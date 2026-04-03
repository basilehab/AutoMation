package tests.settings;

import com.dentolize.dashboard.gui.pages.HomePage;
import engine.Helper;
import engine.dataDriven.FakerData;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;


@Epic("Automatic Tasks Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_AutomaticTask_Tests extends WebBaseTests {
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;

    @BeforeClass(description = "Before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("automaticTasks.create");
        updateSuccessMessage = successMessages.getTestData("automaticTasks.update");
        deleteSuccessMessage = successMessages.getTestData("automaticTasks.delete");
    }

    @Test(description = "Verify that the owner can \"Create new Automatic Task\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_AutomaticTask_UserStory)
    @TmsLink(CRUD_AutomaticTask_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_AutomaticTask_requiredData() {
        new HomePage(driver).navigateToAutomaticTasksPage()
                .clickOnCreateNewAutomaticTask_btn()
                .enterAutomaticTaskName(FakerData.getInstance().getFirstName() + Helper.getTimestamp())
                .enterAutomaticTaskDetails(FakerData.getInstance().getTextLimit(200))
                .clickOnCreateForm_btn();
        //  Verifications.verifyTextForElement(driver, AutomaticTasksForm.successMessageText(), createSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Update Automatic Task\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_AutomaticTask_UserStory)
    @TmsLink(CRUD_AutomaticTask_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_AutomaticTask_requiredData() {
        new HomePage(driver).navigateToAutomaticTasksPage()
                .clickOnUpdateAutomaticTask_btn(1)
                .enterAutomaticTaskDetails(FakerData.getInstance().getTextLimit(200))
                .clickOnUpdateForm_btn();
        //  Verifications.verifyTextForElement(driver, AutomaticTasksForm.successMessageText(), updateSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Delete Automatic Task\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_AutomaticTask_UserStory)
    @TmsLink(CRUD_AutomaticTask_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_AutomaticTask() {
        new HomePage(driver).navigateToAutomaticTasksPage()
                .clickOnUpdateAutomaticTask_btn(1)
                .clickOnDeleteForm_btn();
        //    Verifications.verifyTextForElement(driver, AutomaticTasksForm.successMessageText(), deleteSuccessMessage);
    }
}