package com.dentolize.settings.prescriptionTemplates.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PrescriptionTemplatesTable {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public PrescriptionTemplatesTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By newPrescriptionTemplate_btn = commonLocators.dynamicButtons("New Prescription Template");

    @Step("Click on [ Create new Prescription Templates ] button")
    public PrescriptionTemplatesForm clickOnCreateNewPrescriptionTemplate_btn() {
        driver.element().click(newPrescriptionTemplate_btn);
        return new PrescriptionTemplatesForm(driver);
    }

    @Step("Click on [ Update Prescription Templates ] button")
    public PrescriptionTemplatesForm clickOnUpdatePrescriptionTemplate_btn(int index) {
        driver.element().click(commonLocators.dynamicUpdateIcon(index));
        return new PrescriptionTemplatesForm(driver);
    }
}
