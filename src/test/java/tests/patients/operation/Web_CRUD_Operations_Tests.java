package tests.patients.operation;

import com.dentolize.dashboard.gui.pages.HomePage;
import engine.dataDriven.FakerData;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;

@Epic("Operations Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_Operations_Tests extends WebBaseTests {
    //TODO: 30/08/2021 Add `Create Operations` Test Case
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;

    @BeforeClass(description = "Before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("operations.create");
        updateSuccessMessage = successMessages.getTestData("operations.update");
        deleteSuccessMessage = successMessages.getTestData("operations.delete");
    }

    @Test(description = "Verify the User can \"Add New Operation\" and fill all required data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Operations_UserStory)
    @TmsLink(CRUD_Operations_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Add_newOperation_requiredData() {
        new HomePage(driver)
                .addOperationFromShortCut()
                .selectPatient()
                .selectDentist(settings_TD.getCellData("Users", "User1", "Name"));
        //   .selectProcedure()
        //  .selectTooth()
        //.enterOperationDetails(FakerData.getTextLimit(500))
        //.clickOnCreateOperationButton()
        //.confirmSendSms("Yes")
        //.confirmInvalidNumber("Yes");
        // Verifications.verifyTextForElement(driver, OperationForm.successMessageText(createSuccessMessage), createSuccessMessage);
    }

    @Test(description = "Verify the User can \"Update Operation\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Operations_UserStory)
    @TmsLink(CRUD_Operations_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_operations_requiredData() {
        new HomePage(driver).navigateToOperationsPage()
                .clickOnEditOperation_btn(1)
                .enterOperationDetails(FakerData.getInstance().getTextLimit(2000))
                .clickOnUpdateOperation_btn();
        //  Verifications.verifyTextForElement(driver, OperationForm.successMessageText(updateSuccessMessage), updateSuccessMessage);
    }

    @Test(description = "Verify the User can \"Delete Operation\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Operations_UserStory)
    @TmsLink(CRUD_Operations_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_Operation() {
        new HomePage(driver).navigateToOperationsPage()
                .clickOnEditOperation_btn(1
                )
                .clickOnDeleteOperation_btn();
        //  Verifications.verifyTextForElement(driver, OperationForm.successMessageText(deleteSuccessMessage), deleteSuccessMessage);
    }
}
