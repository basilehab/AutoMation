package tests.associates;

import com.dentolize.dashboard.gui.pages.HomePage;
import engine.Helper;
import engine.dataDriven.FakerData;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;


@Epic("Supplier Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_Suppliers_Tests extends WebBaseTests {
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;
    @BeforeClass(description = "before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("suppliers.create");
        updateSuccessMessage = successMessages.getTestData("suppliers.update");
        deleteSuccessMessage = successMessages.getTestData("suppliers.delete");
    }
    @Test(description = "Verify that the owner can \"Create new Supplier\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Suppliers_UserStory)
    @TmsLink(CRUD_Suppliers_Functions)
    @Link(associates_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_Supplier_requiredData() {
        new HomePage(driver).navigateToSuppliersPage()
                .clickOnCreateNewSupplier_btn()
                .enterSupplierName(FakerData.getInstance().getFirstName() + Helper.getTimestamp())
                .enterSupplierDetails(FakerData.getInstance().getTextLimit(200))
                .clickOnCreateForm_btn();
       // Verifications.verifyTextForElement(driver, SuppliersForm.successMessageText(), createSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Update Supplier\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Suppliers_UserStory)
    @TmsLink(CRUD_Suppliers_Functions)
    @Link(associates_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_Supplier_requiredData() {
        new HomePage(driver).navigateToSuppliersPage()
                .clickOnUpdateSupplier_btn(1)
                .enterSupplierDetails(FakerData.getInstance().getTextLimit(200))
                .clickOnUpdateForm_btn();
     //   Verifications.verifyTextForElement(driver, SuppliersForm.successMessageText(), updateSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Delete Supplier\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Suppliers_UserStory)
    @TmsLink(CRUD_Suppliers_Functions)
    @Link(associates_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Supplier_SMS() {
        new HomePage(driver).navigateToSuppliersPage()
                .clickOnUpdateSupplier_btn(1)
                .clickOnDeleteForm_btn();
     //   Verifications.verifyTextForElement(driver, SuppliersForm.successMessageText(), deleteSuccessMessage);
    }
}