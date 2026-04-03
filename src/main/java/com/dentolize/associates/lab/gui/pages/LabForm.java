package com.dentolize.associates.lab.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LabForm {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public LabForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By name_textField = By.id("LabForm_name");
    private final By details_textArea = By.id("LabForm_details");
    private final By create_btn = this.commonLocators.dynamicSubmitButtons("Create");
    private final By update_btn = this.commonLocators.dynamicSubmitButtons("Update");
    private final By delete_btn = this.commonLocators.dynamicButtons("Delete");
    private final By yesConfirmationMessage_btn = this.commonLocators.dynamicButtons("Yes");
    private final By noConfirmationMessage_btn = this.commonLocators.dynamicButtons("No");

    @Step("Enter Lab name [ {name} ]")
    public LabForm enterLabName(String name) {
        driver.element().type(name_textField, name);
        return this;
    }

    @Step("Enter Lab Details ")
    public LabForm enterLabDetails(String details) {
        driver.element().type(details_textArea, details);
        return this;
    }

    @Step("Click On [ Create ] button")
    public LabForm clickOnCreateForm_btn() {
        driver.element().click(create_btn);
        return this;
    }

    @Step("Click On [ Update ] button")
    public LabForm clickOnUpdateForm_btn() {
        driver.element().click(update_btn);
        return this;
    }

    @Step("Click On [ Delete ] button")
    public LabForm clickOnDeleteForm_btn() {
        driver.element().click(delete_btn).click(yesConfirmationMessage_btn);
        return this;
    }
}
