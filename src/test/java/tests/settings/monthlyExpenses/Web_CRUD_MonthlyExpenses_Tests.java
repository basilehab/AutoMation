package tests.settings.monthlyExpenses;

import com.dentolize.dashboard.gui.pages.HomePage;
import engine.dataDriven.FakerData;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;


@Epic("Monthly Expenses Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_MonthlyExpenses_Tests extends WebBaseTests {
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;

    @BeforeClass(description = "Before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("monthlyExpenses.create");
        updateSuccessMessage = successMessages.getTestData("monthlyExpenses.update");
        deleteSuccessMessage = successMessages.getTestData("monthlyExpenses.delete");
    }

    @Test(description = "Verify that the owner can \"Create new Monthly Expenses\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_MonthlyExpenses_UserStory)
    @TmsLink(CRUD_MonthlyExpenses_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_MonthlyExpenses_requiredData() {
        new HomePage(driver).navigateToMonthlyExpensesPage()
                .clickOnCreateNewMonthlyExpenses_btn()
                .enterMonthlyExpensesName(FakerData.getInstance().getFirstName(), FakerData.getInstance().getNumberLimit(4), "Salary")
                .clickOnCreateForm_btn();
        //    Verifications.verifyTextForElement(driver, MonthlyExpensesForm.successMessageText(createSuccessMessage), createSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Update Monthly Expenses\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_MonthlyExpenses_UserStory)
    @TmsLink(CRUD_MonthlyExpenses_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_MonthlyExpenses_requiredData() {
        new HomePage(driver).navigateToMonthlyExpensesPage()
                .clickOnUpdateMonthlyExpenses_btn(1)
                .enterMonthlyExpensesDetails(FakerData.getInstance().getTextLimit(300))
                .clickOnUpdateForm_btn();
        //  Verifications.verifyTextForElement(driver, MonthlyExpensesForm.successMessageText(updateSuccessMessage), updateSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Delete Monthly Expenses\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_MonthlyExpenses_UserStory)
    @TmsLink(CRUD_MonthlyExpenses_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_MonthlyExpenses() {
        new HomePage(driver).navigateToMonthlyExpensesPage()
                .clickOnUpdateMonthlyExpenses_btn(1)
                .clickOnDeleteForm_btn();
        //   Verifications.verifyTextForElement(driver, MonthlyExpensesForm.successMessageText(deleteSuccessMessage), deleteSuccessMessage);
    }
}