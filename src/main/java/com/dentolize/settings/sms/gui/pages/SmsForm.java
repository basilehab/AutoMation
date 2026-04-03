package com.dentolize.settings.sms.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SmsForm {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public SmsForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By name_textField = By.id("MessageForm_name");

    private final By interval_dropDownList = By.id("PatientReminderForm_interval");


    private final By details_textArea = By.id("MessageForm_details");
    private final By create_btn = commonLocators.dynamicSubmitButtons("Create");
    private final By update_btn = commonLocators.dynamicSubmitButtons("Update");
    private final By delete_btn = commonLocators.dynamicButtons("Delete");
    private final By yesConfirmationMessage_btn = commonLocators.dynamicButtons("Yes");
    private final By noConfirmationMessage_btn = commonLocators.dynamicButtons("No");


    @Step("Enter Sms name [ {name} ]")
    public SmsForm enterSmsName(String name) {
        driver.element().type(name_textField, name);
        return this;
    }


    @Step("Enter Sms Details ")
    public SmsForm enterSmsDetails(String details) {
        driver.element().type(details_textArea, details);
        return this;
    }

    @Step("Click On [ Create ] button")
    public SmsForm clickOnCreateForm_btn() {
        driver.element().click(create_btn);
        return this;
    }

    @Step("Click On [ Update ] button")
    public SmsForm clickOnUpdateForm_btn() {
        driver.element().click(update_btn);
        return this;
    }

    @Step("Click On [ Delete ] button")
    public SmsForm clickOnDeleteForm_btn() {
        driver.element().click(delete_btn).click(yesConfirmationMessage_btn);
        return this;
    }
}
