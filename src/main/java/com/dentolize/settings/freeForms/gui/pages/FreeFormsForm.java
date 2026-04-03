package com.dentolize.settings.freeForms.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FreeFormsForm {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public FreeFormsForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By name_textField = By.id("FreeForm_name");
    private final By create_btn = this.commonLocators.dynamicSubmitButtons("Create");
    private final By update_btn = this.commonLocators.dynamicSubmitButtons("Update");
    private final By delete_btn = this.commonLocators.dynamicButtons("Delete");
    private final By yesConfirmationMessage_btn = this.commonLocators.dynamicButtons("Yes");
    private final By noConfirmationMessage_btn = this.commonLocators.dynamicButtons("No");

    @Step("Enter Free Form name [{name}]")
    public FreeFormsForm enterFreeFormName(String name) {
        driver.element().type(name_textField, name);
        return this;
    }


    @Step("Enter Patient Reminder Details ")
    public FreeFormsForm enterFreeFormDetails(String details) {
        driver.element().type(this.commonLocators.details_textArea, details);
        return this;
    }

    @Step("Click On [ Create ] button")
    public FreeFormsForm clickOnCreateForm_btn() {
        driver.element().click(create_btn);
        return this;
    }

    @Step("Click On [ Update ] button")
    public FreeFormsForm clickOnUpdateForm_btn() {
        driver.element().click(update_btn);
        return this;
    }

    @Step("Click On [ Delete ] button")
    public FreeFormsForm clickOnDeleteForm_btn() {
        driver.element().click(delete_btn).click(yesConfirmationMessage_btn);
        return this;
    }
}
