package com.dentolize.settings.monthlyExpenses.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MonthlyExpensesForm {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public MonthlyExpensesForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    final By name_textField = By.id("PatientReminderForm_name");
    final By amount_textField = By.id("PatientReminderForm_amount");
    final By type_textField = By.id("PatientReminderForm_type");
    final By details_textArea = By.id("PatientReminderForm_details");
    final By create_btn = commonLocators.dynamicSubmitButtons("Create");
    final By update_btn = commonLocators.dynamicSubmitButtons("Update");
    final By delete_btn = commonLocators.dynamicButtons("Delete");
    final By yesConfirmationMessage_btn = commonLocators.dynamicButtons("Yes");
    final By noConfirmationMessage_btn = commonLocators.dynamicButtons("No");

    @Step("Enter Monthly Expenses required Data")
    public MonthlyExpensesForm enterMonthlyExpensesName(String name, String amount, String type) {
        driver.element().type(name_textField, name).type(amount_textField, amount).type(type_textField, type).click(commonLocators.listOfOptionByName(type));
        return this;
    }

    @Step("Enter Monthly Expenses details")
    public MonthlyExpensesForm enterMonthlyExpensesDetails(String details) {
        driver.element().type(details_textArea, details);
        return this;
    }

    @Step("Click On [ Create ] button")
    public MonthlyExpensesForm clickOnCreateForm_btn() {
        driver.element().click(create_btn);
        return this;
    }

    @Step("Click On [ Update ] button")
    public MonthlyExpensesForm clickOnUpdateForm_btn() {
        driver.element().click(update_btn);
        return this;
    }

    @Step("Click On [ Delete ] button")
    public MonthlyExpensesForm clickOnDeleteForm_btn() {
        driver.element().click(delete_btn).click(yesConfirmationMessage_btn);
        return this;
    }
}
