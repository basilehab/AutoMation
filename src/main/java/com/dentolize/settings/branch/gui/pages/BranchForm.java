package com.dentolize.settings.branch.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class BranchForm {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public BranchForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By createBranch_btn = this.commonLocators.dynamicSubmitButtons("Create");
    private final By updateBranch_btn = this.commonLocators.dynamicSubmitButtons("Update");
    private final By disableBranch_btn = this.commonLocators.dynamicButtons("Disable");
    private final By enableBranch_btn = this.commonLocators.dynamicButtons("Enable");
    private final By yesConfirmationMessage_btn = this.commonLocators.dynamicButtons("Yes");
    private final By noConfirmationMessage_btn = this.commonLocators.dynamicButtons("No");

    @Step("Click On [ Create ] button")
    public BranchForm clickOnCreateForm_btn() {
        driver.element().click(createBranch_btn);
        return this;
    }

    @Step("Click On [ Update ] button")
    public BranchForm clickOnUpdateForm_btn() {
        driver.element().click(updateBranch_btn);
        return this;
    }

    @Step("Click On [ Delete ] button")
    public BranchForm clickOnDisableForm_btn() {
        driver.element().click(disableBranch_btn)
                .click(yesConfirmationMessage_btn);
        return this;
    }

    @Step("Click On [ Delete ] button")
    public BranchForm clickOnEnableForm_btn() {
        driver.element().click(enableBranch_btn)
                .click(yesConfirmationMessage_btn);
        return this;
    }
}
