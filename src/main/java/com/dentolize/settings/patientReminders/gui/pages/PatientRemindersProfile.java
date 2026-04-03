package com.dentolize.settings.patientReminders.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;

public class PatientRemindersProfile {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public PatientRemindersProfile(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

}
