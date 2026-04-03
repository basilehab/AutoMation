package com.dentolize.settings.automaticTasks.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AutomaticTasksForm {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public AutomaticTasksForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By name_textField = By.id("TaskForm_name");
    private final By interval_dropDownList = By.id("PatientReminderForm_interval");
    private final By dueAfter_numeric = By.id("TaskForm_due");
    private final By details_textArea = By.id("TaskForm_details");
    private final By create_btn = this.commonLocators.dynamicSubmitButtons("Create");
    private final By update_btn = this.commonLocators.dynamicSubmitButtons("Update");
    private final By delete_btn = this.commonLocators.dynamicButtons("Delete");
    private final By yesConfirmationMessage_btn = this.commonLocators.dynamicButtons("Yes");
    private final By noConfirmationMessage_btn = this.commonLocators.dynamicButtons("No");

    @Step("Enter Patient Reminder Required data [ {name} , {intervalOption} ]")
    public AutomaticTasksForm enterAutomaticTaskRequiredData(String name, String intervalOption) {
        enterAutomaticTaskName(name);
        selectInterval(intervalOption);
        return this;
    }

    @Step("Enter Free Form name [ {name} ]")
    public AutomaticTasksForm enterAutomaticTaskName(String name) {
        driver.element().type(name_textField, name);
        return this;
    }

    @Step("Select Due After [ {days} ]")
    public AutomaticTasksForm selectDueAfter(int days) {
        driver.element().type(dueAfter_numeric, String.valueOf(days));
        return this;
    }

    @Step("Select interval option: [ {intervalOption} ]")
    public AutomaticTasksForm selectInterval(String intervalOption) {
        driver.element().click(this.commonLocators.listOfOptionByName(intervalOption));
        return this;
    }

    @Step("Enter Automatic Tasks Details ")
    public AutomaticTasksForm enterAutomaticTaskDetails(String details) {
        driver.element().type(details_textArea, details);
        return this;
    }

    @Step("Click On [ Create ] button")
    public AutomaticTasksForm clickOnCreateForm_btn() {
        driver.element().click(create_btn);
        return this;
    }

    @Step("Click On [ Update ] button")
    public AutomaticTasksForm clickOnUpdateForm_btn() {
        driver.element().click(update_btn);
        return this;
    }

    @Step("Click On [ Delete ] button")
    public AutomaticTasksForm clickOnDeleteForm_btn() {
        driver.element().click(delete_btn).click(yesConfirmationMessage_btn);
        return this;
    }
}
