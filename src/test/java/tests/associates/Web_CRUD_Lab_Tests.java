package tests.associates;

import com.dentolize.dashboard.gui.pages.HomePage;
import engine.Helper;
import engine.dataDriven.FakerData;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;


@Epic("Lab Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_Lab_Tests extends WebBaseTests {
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;
    @BeforeClass(description = "before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("labs.create");
        updateSuccessMessage = successMessages.getTestData("labs.update");
        deleteSuccessMessage = successMessages.getTestData("labs.delete");
    }

    @Test(description = "Verify that the owner can \"Create new Lab\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Labs_UserStory)
    @TmsLink(CRUD_Labs_Functions)
    @Link(associates_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_Lab_requiredData() {
        new HomePage(driver).navigateToLabsPage()
                .clickOnCreateNewLab_btn()
                .enterLabName(FakerData.getInstance().getFirstName() + Helper.getTimestamp())
                .clickOnCreateForm_btn();
       // Verifications.verifyTextForElement(driver, LabForm.successMessageText(), createSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Update Lab\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Labs_UserStory)
    @TmsLink(CRUD_Labs_Functions)
    @Link(associates_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_Lab_requiredData() {
        new HomePage(driver).navigateToLabsPage()
                .clickOnUpdateLab_btn(1)
                .enterLabDetails(FakerData.getInstance().getTextLimit(100))
                .clickOnUpdateForm_btn();
      //  Verifications.verifyTextForElement(driver, LabForm.successMessageText(), updateSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Delete Lab\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Labs_UserStory)
    @TmsLink(CRUD_Labs_Functions)
    @Link(associates_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_Lab() {
        new HomePage(driver).navigateToLabsPage()
                .clickOnUpdateLab_btn(1)
                .clickOnDeleteForm_btn();
       // Verifications.verifyTextForElement(driver, LabForm.successMessageText(), deleteSuccessMessage);
    }
}