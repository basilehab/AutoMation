package tests.patients;

import com.dentolize.dashboard.gui.pages.HomePage;
import engine.dataDriven.FakerData;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;

@Epic("Notes Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_Notes_Tests extends WebBaseTests {
    //TODO: 30/08/2021 Add `Create Note` Test Case
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;

    @BeforeClass(description = "Before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("notes.create");
        updateSuccessMessage = successMessages.getTestData("notes.update");
        deleteSuccessMessage = successMessages.getTestData("notes.delete");
    }

    @Test(description = "Verify that the owner can \"Create New Note\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Notes_UserStory)
    @TmsLink(CRUD_Notes_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_newNote_requiredData() {
        new HomePage(driver).AddNewNoteFromShortCut();
        //  Verifications.verifyTextForElement(driver, NoteForm.successMessageText(createSuccessMessage), createSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Update Note\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Notes_UserStory)
    @TmsLink(CRUD_Notes_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_Note_requiredData() {
        new HomePage(driver).navigateToNotesPage()
                .clickOnEditNote_btn(1)
                .enterNoteDetails(FakerData.getInstance().getTextLimit(200))
                .clickOnSubmitNote_btn();
        // Verifications.verifyTextForElement(driver, NoteForm.successMessageText(updateSuccessMessage), updateSuccessMessage);
    }

    @Test(description = "Verify that the owner can \"Delete Note\" with required and valid Data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Notes_UserStory)
    @TmsLink(CRUD_Notes_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_Note_requiredData() {
        new HomePage(driver).navigateToNotesPage()
                .clickOnDeleteNote_btn(1);
        //   Verifications.verifyTextForElement(driver, NoteForm.successMessageText(deleteSuccessMessage), deleteSuccessMessage);
    }
}
