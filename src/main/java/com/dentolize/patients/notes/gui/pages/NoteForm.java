package com.dentolize.patients.notes.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NoteForm {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public NoteForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By createNote_btn = this.commonLocators.dynamicSubmitButtons("Create");
    private final By updateNote_btn = this.commonLocators.dynamicSubmitButtons("Submit");
    private final By deleteNote_btn = this.commonLocators.dynamicButtons("Delete");
    private final By yesConfirmationMessage_btn = this.commonLocators.dynamicButtons("Yes");
    private final By noConfirmationMessage_btn = this.commonLocators.dynamicButtons("No");

    @Step("Click On [ Update ] button")
    public NoteForm clickOnSubmitNote_btn() {
        driver.element().click(updateNote_btn);
        return this;
    }

    @Step("Enter Note details")
    public NoteForm enterNoteDetails(String textLimit) {
        driver.element().type(this.commonLocators.details_textArea, textLimit);
        return this;
    }
}
