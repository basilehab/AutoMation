package com.dentolize.settings.freeForms.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FreeFormsTable {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public FreeFormsTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By newFreeForm_btn = this.commonLocators.dynamicButtons("New Item");

    @Step("Click on [ Create new Free Form ] button")
    public FreeFormsForm clickOnCreateNewFreeForm_btn() {
        driver.element().click(newFreeForm_btn);
        return new FreeFormsForm(driver);
    }

    @Step("Click on [ Update Free Form ] button")
    public FreeFormsForm clickOnUpdateFreeForm_btn(int index) {
        driver.element().click(this.commonLocators.dynamicUpdateIcon(index));
        return new FreeFormsForm(driver);
    }
}
