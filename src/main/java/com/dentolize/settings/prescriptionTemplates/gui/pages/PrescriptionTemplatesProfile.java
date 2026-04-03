package com.dentolize.settings.prescriptionTemplates.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;

public class PrescriptionTemplatesProfile {

    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public PrescriptionTemplatesProfile(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }
}
