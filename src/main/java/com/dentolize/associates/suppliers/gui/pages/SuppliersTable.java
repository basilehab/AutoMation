package com.dentolize.associates.suppliers.gui.pages;

import components.CommonLocators;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SuppliersTable {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public SuppliersTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By newSupplier_btn = this.commonLocators.dynamicButtons("New Supplier");

    //*****************************************************//
    //***************// Business Actions //***************//
    //*****************************************************//
    @Step("Click on [ Create new Supplier ] button")
    public SuppliersForm clickOnCreateNewSupplier_btn() {
        driver.element().click(newSupplier_btn);
        return new SuppliersForm(driver);
    }

    @Step("Click on [ Update Sms ] button")
    public SuppliersForm clickOnUpdateSupplier_btn(int index) {
        driver.element().click(this.commonLocators.dynamicUpdateIcon(index));
        return new SuppliersForm(driver);
    }
}
