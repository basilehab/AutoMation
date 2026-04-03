package com.dentolize.settings.patientReminders.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PatientRemindersTable {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public PatientRemindersTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By newPatientReminder_btn = commonLocators.dynamicButtons("New Patient Reminder");

    @Step("Click on [ Create new Patient Reminder] button")
    public PatientRemindersForm clickOnCreateNewPatientReminder_btn() {
        driver.element().click(newPatientReminder_btn);
        return new PatientRemindersForm(driver);
    }

    @Step("Click on [ Update Prescription Templates ] button")
    public PatientRemindersForm clickOnUpdatePatientReminder_btn(int index) {
        driver.element().click(commonLocators.dynamicUpdateIcon(index));
        return new PatientRemindersForm(driver);
    }
}
