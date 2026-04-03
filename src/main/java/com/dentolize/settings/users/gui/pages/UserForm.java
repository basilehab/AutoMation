package com.dentolize.settings.users.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class UserForm {

    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public UserForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By createUser_btn = this.commonLocators.dynamicSubmitButtons("Create");
    private final By updateUser_btn = this.commonLocators.dynamicSubmitButtons("Update");
    private final By disableUser_btn = this.commonLocators.dynamicButtons("Disable");
    private final By mergeUser_btn = this.commonLocators.dynamicButtons("Merge User");
    final By yesConfirmationMessage_btn = this.commonLocators.dynamicButtons("Yes");
    final By noConfirmationMessage_btn = this.commonLocators.dynamicButtons("No");

    @Step("Click On [ Create ] button")
    public UserForm clickOnCreateForm_btn() {
        driver.element().click(createUser_btn);
        return this;
    }

    @Step("Click On [ Update ] button")
    public UserForm clickOnUpdateForm_btn() {
        driver.element().click(updateUser_btn);
        return this;
    }

    @Step("Click On [ Disable ] button")
    public UserForm clickOnDisableForm_btn() {
        driver.element().click(disableUser_btn)
                .click(yesConfirmationMessage_btn);
        return this;
    }

    @Step("Click On [ Merge ] button")
    public UserForm clickOnMergeUserForm_btn() {
        driver.element().click(mergeUser_btn)
                .click(yesConfirmationMessage_btn);
        return this;
    }
}
