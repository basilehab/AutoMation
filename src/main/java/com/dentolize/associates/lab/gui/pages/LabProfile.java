package com.dentolize.associates.lab.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;

public class LabProfile {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public LabProfile(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }
}
