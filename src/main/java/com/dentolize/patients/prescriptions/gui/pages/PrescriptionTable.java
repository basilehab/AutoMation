package com.dentolize.patients.prescriptions.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;

public class PrescriptionTable {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public PrescriptionTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    @Step("Click on [ Edit Prescription ] button")
    public PrescriptionForm clickOnEditPrescription_btn(int PrescriptionIndex) {
        driver.element().click(this.commonLocators.dynamicUpdateIcon(PrescriptionIndex));
        return new PrescriptionForm(driver);
    }

}
