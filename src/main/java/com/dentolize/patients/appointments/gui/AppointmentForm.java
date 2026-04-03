package com.dentolize.patients.appointments.gui;

import com.dentolize.patients.info.gui.pages.PatientForm;
import com.shaft.driver.SHAFT;
import components.CommonLocators;
import components.ConfirmationMessage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AppointmentForm {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public AppointmentForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By appointmentForm = By.id("AppointmentForm");
    private final By appointmentTitleForm = By.xpath("//div[@class='ant-drawer-title'][contains(.,'Create New Appointment')]");
    private final By urgent_switchBtn = By.id("AppointmentForm_urgent");
    //TODO: Add Locator for alert_switchBtn
    private final By alert_switchBtn = By.id("");
    private final By alert_details = By.id("AppointmentForm_alert");
    private final By note_switchBtn = By.id("AppointmentForm_note");
    private final By noteTitle_txtField = By.id("AppointmentForm_title");
    private final By notifyUser_txtField = By.id("AppointmentForm_doctor");
    private final By noteDetails_txtArea = By.id("AppointmentForm_details");
    private final By searchPatient_input = By.xpath("//input[@placeholder='Please choose a patient or add new']");
    private final By addPatientAppointmentForm_btn = By.xpath("//form[@id='AppointmentForm']//button[@type='button' and @class='ant-btn css-kko202 ant-btn-primary ant-btn-icon-only']");
    private final By addAppointmentByQRCode_btn = By.xpath("//button[@class='ant-btn css-1whf4lq ant-btn-primary ant-btn-icon-only']");
    private final By dentist_list = By.id("AppointmentForm_doctor");
    private final By room_list = By.id("AppointmentForm_room");
    private final By appointmentType_list = By.id("AppointmentForm_type");
    private final By appointmentDay_input = By.id("AppointmentForm_day");
    private final By startTime_input = By.id("AppointmentForm_start");

    private By startTime_list(String startTime) {
        return By.xpath("//input[@id='AppointmentForm_start' and @title='" + startTime + "']");
    }

    private final By endTime_input = By.id("AppointmentForm_end");

    private By startEnd_list(String endTime) {
        return By.xpath("//input[@id='AppointmentForm_end' and @title='" + endTime + "']");
    }

    private final By createdAt_input = By.id("AppointmentForm_createdAt");
    private final By submitAppointment_btn = this.commonLocators.dynamicButtons("Submit");
    private final By updateAppointment_btn = this.commonLocators.dynamicButtons("Update");
    private final By deleteAppointment_btn = this.commonLocators.dynamicButtons("Delete");
    private By appointmentDetails_txtArea = By.id("AppointmentForm_details");

    private By appointmentDay_list(String day) {
        return By.xpath("//div[@class='ant-picker-body']//tr//td[@title='" + day + "']");
    }

    private By startAppointmentTimeByHours_list(String hours) {
        return By.xpath("(//ul[@class='ant-picker-time-panel-column'])[1]//li//div[@class='ant-picker-time-panel-cell-inner'][contains(.,'" + hours + "')]");
    }

    private By startAppointmentTimeByMin_list(String minutes) {
        return By.xpath("(//ul[@class='ant-picker-time-panel-column'])[2]//li//div[@class='ant-picker-time-panel-cell-inner'][contains(.,'" + minutes + "')]");
    }

    private By startAppointmentTimeByAMorPM_list(String AMorPM) {
        return By.xpath("(//ul[@class='ant-picker-time-panel-column'])[3]//li//div[@class='ant-picker-time-panel-cell-inner'][contains(.,'" + AMorPM + "')]");
    }

    private By okTime_btn = By.xpath("//li[@class='ant-picker-ok']//button[@type='button']");


    private By resultSearchPatient(int index) {
        return By.xpath("(//div[@class='ant-select-item-option-content']//span[@class='ant-typography css-kko202'])[" + index + "]");
    }

    @Step("Click on Urgent switch button")
    public AppointmentForm clickOnUrgentSwitchButton() {
        driver.element().click(urgent_switchBtn);
        return this;
    }

    @Step("Click on Alert switch button")
    public AppointmentForm clickOnAlertSwitchButton() {
        driver.element().click(alert_switchBtn);
        return this;
    }

    @Step("Enter alert details")
    public AppointmentForm enterAlertDetails(String alertDetails) {
        driver.element().type(alert_details, alertDetails);
        return this;
    }

    @Step("Add note for user")
    public AppointmentForm addNoteForUser(String noteTitle, String notifyUser, String noteDetails) {
        driver.element().click(note_switchBtn).type(noteTitle_txtField, noteTitle).type(notifyUser_txtField, notifyUser);
        return this;
    }

    @Step("Enter note details")
    public AppointmentForm enterNoteDetails(String noteDetails) {
        driver.element().type(noteDetails_txtArea, noteDetails);
        return this;
    }

    @Step("Search for patient [ {patientName} ]")
    public AppointmentForm searchForPatient(String patientName, int index) {
        driver.element().click(searchPatient_input).type(searchPatient_input, patientName).click(resultSearchPatient(index));
        return this;
    }

    @Step("Click on Add Patient button")
    public PatientForm clickOnAddPatientWithAddAppointment() {
        driver.element().click(addPatientAppointmentForm_btn);
        return new PatientForm(driver);
    }


    @Step("Select dentist [ {dentistName} ]")
    public AppointmentForm selectDentist(String dentistName) {
        driver.element().click(dentist_list).click(this.commonLocators.listOfOptionByName(dentistName));
        return this;
    }

    @Step("Select room [ {roomName} ]")
    public AppointmentForm selectRoom(String roomName) {
        driver.element().click(room_list).click(this.commonLocators.listOfOptionByName(roomName));
        return this;
    }

    @Step("Select appointment status [ {appointmentStatus} ]")
    public AppointmentForm selectAppointmentStatus(String appointmentStatus) {
        driver.element().click(appointmentType_list).click(this.commonLocators.listOfOptionByName(appointmentStatus));
        return this;
    }


    @Step("Select Appointment Day [ {day} ]")
    public AppointmentForm selectAppointmentDay(String day) {
        driver.element().click(appointmentDay_input).click(appointmentDay_list(day));
        return this;
    }

    @Step("Select start appointment time [ {startTimeHours} : {startTimeMin} {startTimeAMorPM} ]")
    public AppointmentForm selectAppointmentStartTime(String startTime) {
        driver.element().click(startTime_input).click(startTime_list(startTime));
        return this;
    }

    @Step("Select end appointment time [{day} and time {endTimeHours} : {endTimeMin} {endTimeAMorPM} ]")
    public AppointmentForm selectAppointmentEndTime(String endTime) {
        driver.element().click(endTime_input).click(startEnd_list(endTime));
        return this;
    }

    @Step("Select appointment day {day} and time {startTime} to {endTime}")
    public AppointmentForm selectAppointmentDayAndTime(String day, String startTime, String endTime) {
        driver.element().click(appointmentDay_input).click(appointmentDay_list(day)).click(startTime_input).type(startTime_input, startTime).click(endTime_input).type(endTime_input, endTime);
        return this;
    }

    @Step("Select created at date [ {createdAt} ]")
    public AppointmentForm selectCreatedAtDate() {
        driver.element().click(createdAt_input).click(this.commonLocators.datePickerToday_btn);
        return this;
    }

    @Step("Enter appointment details [ {details} ]")
    public AppointmentForm enterAppointmentDetails(String details) {
        driver.element().click(appointmentDetails_txtArea).type(appointmentDetails_txtArea, details);
        return this;
    }


    @Step("Click on Submit Appointment button")
    public ConfirmationMessage clickOnSubmitAppointmentButton() {
        driver.element().click(submitAppointment_btn);
        return new ConfirmationMessage(driver);
    }

    @Step("Click on [ Update Appointment ] button")
    public ConfirmationMessage clickOnUpdateAppointmentButton() {
        driver.element().click(updateAppointment_btn);
        return new ConfirmationMessage(driver);
    }

    @Step("Click on [ Delete Appointment ] button")
    public AppointmentForm clickOnDeleteAppointmentButton() {
        driver.element().click(deleteAppointment_btn).click(this.commonLocators.dynamicButtons("Yes"));
        return this;
    }

}
