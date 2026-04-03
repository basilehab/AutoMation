package com.dentolize.patients.notes.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NoteTable {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public NoteTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By yesConfirmationMessage_btn = this.commonLocators.dynamicButtons("Yes");

    @Step("Click on [ Edit Note ] button")
    public NoteForm clickOnEditNote_btn(int noteIndex) {
        driver.element().click(this.commonLocators.dynamicUpdateIcon(noteIndex));
        return new NoteForm(driver);
    }

    @Step("Click On [ Delete ] button")
    public NoteForm clickOnDeleteNote_btn(int noteIndex) {
        driver.element().click(this.commonLocators.dynamicDeleteIcon(noteIndex))
                .click(yesConfirmationMessage_btn);
        return new NoteForm(driver);
    }
}
