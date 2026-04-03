package com.dentolize.settings.branch.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class BranchTable {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public BranchTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By newBranch_btn = this.commonLocators.dynamicButtons("New Branch");

    @Step("Click on [ Create new Branch ] button")
    public BranchForm clickOnCreateNewBranch_btn() {
        driver.element().click(newBranch_btn);
        return new BranchForm(driver);
    }

    @Step("Click on [ Edit Branch ] button")
    public BranchForm clickOnUpdateBranch_btn(int branchIndex) {
        driver.element().click(this.commonLocators.dynamicUpdateIcon(branchIndex));
        return new BranchForm(driver);
    }
}
