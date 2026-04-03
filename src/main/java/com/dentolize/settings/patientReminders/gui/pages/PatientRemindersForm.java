package com.dentolize.settings.patientReminders.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PatientRemindersForm {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public PatientRemindersForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By name_textField = By.id("PatientReminderForm_name");
    private final By remindAfterCompleted_numeric = By.id("PatientReminderForm_every");
    private final By interval_dropDownList = By.id("PatientReminderForm_interval");
    private final By details_textArea = By.id("PatientReminderForm_info");
    private final By create_btn = commonLocators.dynamicSubmitButtons("Create");
    private final By update_btn = commonLocators.dynamicSubmitButtons("Update");
    private final By delete_btn = commonLocators.dynamicButtons("Delete");
    private final By yesConfirmationMessage_btn = commonLocators.dynamicButtons("Yes");
    private final By noConfirmationMessage_btn = commonLocators.dynamicButtons("No");

    @Step("Enter Patient Reminder Required data [{name} , {remindAfterCompleted} , {intervalOption}]")
    public PatientRemindersForm enterPatientReminderRequiredData(String name, int remindAfterCompleted, String intervalOption) {
        driver.element().type(name_textField, name);
        selectReindAfterCompleted(remindAfterCompleted);
        selectInterval(intervalOption);
        return this;
    }

    @Step("Select remind after Completed  [{remindAfterCompleted}]")
    public PatientRemindersForm selectReindAfterCompleted(int remindAfterCompleted) {
        driver.element().type(remindAfterCompleted_numeric, String.valueOf(remindAfterCompleted));
        return this;
    }

    @Step("Select interval option: [{intervalOption}]")
    public PatientRemindersForm selectInterval(String intervalOption) {
        driver.element()
                .click(interval_dropDownList)
                .click(commonLocators.listOfOptionByName(intervalOption));
        return this;
    }

    @Step("Enter Patient Reminder Details ")
    public PatientRemindersForm enterPatientReminderDetails(String details) {
        driver.element().type(details_textArea, details);
        return this;
    }

    @Step("Click On [ Create ] button")
    public PatientRemindersForm clickOnCreateForm_btn() {
        driver.element().click(create_btn);
        return this;
    }

    @Step("Click On [ Update ] button")
    public PatientRemindersForm clickOnUpdateForm_btn() {
        driver.element().click(update_btn);
        return this;
    }

    @Step("Click On [ Delete ] button")
    public PatientRemindersForm clickOnDeleteForm_btn() {
        driver.element().click(delete_btn)
                .click(yesConfirmationMessage_btn);
        return this;
    }
}
