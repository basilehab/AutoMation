package com.dentolize.settings.sms.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;

public class SmsProfile {

    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public SmsProfile(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }
}
