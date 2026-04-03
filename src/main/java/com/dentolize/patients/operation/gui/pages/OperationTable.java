package com.dentolize.patients.operation.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;

public class OperationTable {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public OperationTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    @Step("Click on [ Edit Operation ] button")
    public OperationForm clickOnEditOperation_btn(int OperationIndex) {
        driver.element().click(this.commonLocators.dynamicUpdateIcon(OperationIndex));
        return new OperationForm(driver);
    }
}
