package tests.settings;

import com.dentolize.dashboard.gui.pages.HomePage;
import engine.dataDriven.FakerData;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;


@Epic("Medication Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_Medications_Tests extends WebBaseTests {
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;

    @BeforeClass(description = "Before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("medications.create");
        updateSuccessMessage = successMessages.getTestData("medications.update");
        deleteSuccessMessage = successMessages.getTestData("medications.delete");
    }

    @Test(description = "Verify that the owner can \"Create new Medication\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Medications_UserStory)
    @TmsLink(CRUD_Medications_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_MonthlyExpenses_requiredData() {
        new HomePage(driver).navigateToMedicationsPage()
                .clickOnCreateNewMedications_btn()
                .enterMedicationsName(FakerData.getInstance().getFirstName())
                .clickOnCreateForm_btn();
        //    Verifications.verifyTextForElement(driver, MedicationsForm.successMessageText(createSuccessMessage), createSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Update Medication\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Medications_UserStory)
    @TmsLink(CRUD_Medications_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_MonthlyExpenses_requiredData() {
        new HomePage(driver).navigateToMedicationsPage()
                .clickOnUpdateMedications_btn(1)
                .clickOnUpdateForm_btn();
        // Verifications.verifyTextForElement(driver, MedicationsForm.successMessageText(updateSuccessMessage), updateSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Delete Medication\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Medications_UserStory)
    @TmsLink(CRUD_Medications_Functions)
    @Link(settings_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_MonthlyExpenses() {
        new HomePage(driver).navigateToMedicationsPage()
                .clickOnUpdateMedications_btn(1)
                .clickOnDeleteForm_btn();
        // Verifications.verifyTextForElement(driver, MedicationsForm.successMessageText(deleteSuccessMessage), deleteSuccessMessage);
    }
}