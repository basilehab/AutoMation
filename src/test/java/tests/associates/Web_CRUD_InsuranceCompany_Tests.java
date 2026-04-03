package tests.associates;

import com.dentolize.dashboard.gui.pages.HomePage;
import engine.Helper;
import engine.dataDriven.FakerData;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;


@Epic("Insurance Company Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_InsuranceCompany_Tests extends WebBaseTests {
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;

    @BeforeClass(description = "before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("insuranceCompany.create");
        updateSuccessMessage = successMessages.getTestData("insuranceCompany.update");
        deleteSuccessMessage = successMessages.getTestData("insuranceCompany.delete");
    }

    @Test(description = "Verify that the owner can \"Create new Insurance Company\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_InsuranceCompany_UserStory)
    @TmsLink(CRUD_InsuranceCompany_Functions)
    @Link(associates_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_InsuranceCompany_requiredData() {
        new HomePage(driver).navigateToInsuranceCompanyPage()
                .clickOnCreateInsuranceCompany_btn()
                .enterInsuranceCompanyRequiredData(FakerData.getInstance().getFirstName() + Helper.getTimestamp(), "1000", "10")
                .enterInsuranceCompanyDetails(FakerData.getInstance().getTextLimit(200))
                .clickOnCreateForm_btn();
      //  Verifications.verifyTextForElement(driver, InsuranceCompanyForm.successMessageText(), createSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Update Insurance Company\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_InsuranceCompany_UserStory)
    @TmsLink(CRUD_InsuranceCompany_Functions)
    @Link(associates_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_InsuranceCompany_requiredData() {
        new HomePage(driver).navigateToInsuranceCompanyPage()
                .clickOnUpdateInsuranceCompany_btn(1)
                .enterInsuranceCompanyDetails(FakerData.getInstance().getTextLimit(200))
                .clickOnUpdateForm_btn();
       // Verifications.verifyTextForElement(driver, InsuranceCompanyForm.successMessageText(), updateSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Delete Insurance Company\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_InsuranceCompany_UserStory)
    @TmsLink(CRUD_InsuranceCompany_Functions)
    @Link(associates_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_InsuranceCompany() {
        new HomePage(driver).navigateToInsuranceCompanyPage()
                .clickOnUpdateInsuranceCompany_btn(1)
                .clickOnDeleteForm_btn();
        //Verifications.verifyTextForElement(driver, InsuranceCompanyForm.successMessageText(), deleteSuccessMessage);
    }
}