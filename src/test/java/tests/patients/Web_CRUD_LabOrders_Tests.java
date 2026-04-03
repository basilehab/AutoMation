package tests.patients;

import com.dentolize.dashboard.gui.pages.HomePage;
import components.ConfirmationMessage;
import engine.dataDriven.FakerData;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;

@Epic("Labs Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_LabOrders_Tests extends WebBaseTests {
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;

    @BeforeClass(description = "before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("labOrders.create");
        updateSuccessMessage = successMessages.getTestData("labOrders.update");
        deleteSuccessMessage = successMessages.getTestData("labOrders.delete");
    }

    @Test(description = "Verify that the owner can \"Create New Lab Order\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_LabOrder_UserStory)
    @TmsLink(CRUD_LabOrder_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_newLabOrder_requiredData() {
        new HomePage(driver)
                .addLabOrderFromShortCut()
                .enterLabOrderName(FakerData.getInstance().getFirstName())
                .enterLabOrderPrice(FakerData.getInstance().getNumberLimit(4))
                .enterLabOrderDetails(FakerData.getInstance().getTextLimit(500))
                .clickOnCreateLabOrder_btn();
        new ConfirmationMessage(driver)
                .confirmSendSms("Yes");
        //     Verifications.verifyTextForElement(driver, LabOrderForm.successMessageText(), createSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Update Lab Order\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_LabOrder_UserStory)
    @TmsLink(CRUD_LabOrder_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_LabOrder_requiredData() {
        new HomePage(driver).navigateToLabOrderPage()
                .clickOnEditLabOrder_btn(1)
                .enterLabOrderName(FakerData.getInstance().getFirstName())
                .enterLabOrderDetails(FakerData.getInstance().getTextLimit(200))
                .clickOnUpdateLabOrder_btn();
        //  Verifications.verifyTextForElement(driver, LabOrderForm.successMessageText(updateSuccessMessage), updateSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Delete Lab Order\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_LabOrder_UserStory)
    @TmsLink(CRUD_LabOrder_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_LabOrder_requiredData() {
        new HomePage(driver).navigateToLabOrderPage()
                .clickOnEditLabOrder_btn(1)
                .clickOnDeleteLabOrder_btn();
        // Verifications.verifyTextForElement(driver, LabOrderForm.successMessageText(deleteSuccessMessage), deleteSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Create New Lab Order\" with All Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_LabOrder_UserStory)
    @TmsLink(CRUD_LabOrder_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_newLabOrder_AllData() {
        new HomePage(driver)
                .addLabOrderFromShortCut()
                .selectPatient("Test sss")
                // .selectLabOrderBranch("Branch_1")
                .selectLab("Lab 1 + Phone Number")
                .selectLabItem("Lab Order - Operations")
                .enterLabOrderName(FakerData.getInstance().getFirstName())
                .selectLabOrderDueDate("4 Sep 2023")
                .enterLabOrderPrice(FakerData.getInstance().getNumberLimit(4))
                .enterLabOrderQuantity(FakerData.getInstance().getNumberLimit(1))
                .selectShade("A1")
                .selectDoctor(settings_TD.getCellData(usersSheet, "User2", "Name"))
                .selectTooth("#6")
                //.selectAssignedTo("User_1")
                .uploadFile("patientPic.jpg")
                .enterLabOrderDetails(FakerData.getInstance().getTextLimit(1000))
                .checkPaid()
                .checkReceived()
                .checkDelivered()
                .checkAddToExpenses()
                .clickOnCreateLabOrder_btn();
        new ConfirmationMessage(driver)
                .confirmSendSms("Yes");
        //  Verifications.verifyTextForElement(driver, LabOrderForm.successMessageText(createSuccessMessage), createSuccessMessage);
    }
}
