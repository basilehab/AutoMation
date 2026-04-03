package com.dentolize.patients.appointments.gui;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CalendarPage {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public CalendarPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private static By selectSlotFromCalendar(int roomNum, int slotNum) {
        return By.xpath("(//div[@class='rbc-time-content']//div[@class='rbc-day-slot rbc-time-column rbc-now rbc-today'])[" + roomNum + "]//div[@class='rbc-timeslot-group'][" + slotNum + "]");
    }

    private final By submit_btn = By.xpath("//button[@type='button']//span[contains(text(),'Submit')]");

    @Step("Select Slot From Calendar")
    public CalendarPage selectSlot(int room, int slot) {
        driver.element().click(selectSlotFromCalendar(room, slot));
        return this;
    }

    @Step("Click Submit Button")
    public CalendarPage clickOnSubmit_btn() {
        driver.element().click(submit_btn);
        return this;
    }
}
