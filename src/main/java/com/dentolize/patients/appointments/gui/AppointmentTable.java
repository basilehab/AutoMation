package com.dentolize.patients.appointments.gui;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;

public class AppointmentTable {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public AppointmentTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    @Step("Click on [ Edit Appointment ] button")
    public AppointmentForm clickOnEditAppointment_btn(int appointmentIndex) {
        driver.element().click(this.commonLocators.dynamicUpdateIcon(appointmentIndex));
        return new AppointmentForm(driver);
    }
}
