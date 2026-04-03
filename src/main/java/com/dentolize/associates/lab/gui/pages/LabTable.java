package com.dentolize.associates.lab.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LabTable {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public LabTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By newLab_btn = this.commonLocators.dynamicButtons("New Lab");

    @Step("Click on [ Create new Lab ] button")
    public LabForm clickOnCreateNewLab_btn() {
        driver.element().click(newLab_btn);
        return new LabForm(driver);
    }

    @Step("Click on [ Update Lab ] button")
    public LabForm clickOnUpdateLab_btn(int index) {
        driver.element().click(this.commonLocators.dynamicUpdateIcon(index));
        return new LabForm(driver);
    }
}
