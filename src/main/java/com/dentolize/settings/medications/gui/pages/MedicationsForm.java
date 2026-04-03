package com.dentolize.settings.medications.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MedicationsForm {

    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public MedicationsForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By name_textField = By.id("MedicationForm_name");
    private final By amount_textField = By.id("PatientReminderForm_amount");
    private final By type_textField = By.id("PatientReminderForm_type");
    private final By create_btn = this.commonLocators.dynamicSubmitButtons("Create");
    private final By update_btn = this.commonLocators.dynamicSubmitButtons("Update");
    private final By delete_btn = this.commonLocators.dynamicButtons("Delete");

    private final By yesConfirmationMessage_btn = this.commonLocators.dynamicButtons("Yes");
    private final By noConfirmationMessage_btn = commonLocators.dynamicButtons("No");

    @Step("Enter Monthly Expenses name [{name}]")
    public MedicationsForm enterMedicationsName(String name) {
        driver.element().type(name_textField, name);
        return this;
    }


    @Step("Click On [ Create ] button")
    public MedicationsForm clickOnCreateForm_btn() {
        driver.element().click(create_btn);
        return this;
    }

    @Step("Click On [ Update ] button")
    public MedicationsForm clickOnUpdateForm_btn() {
        driver.element().click(update_btn);
        return this;
    }

    @Step("Click On [ Delete ] button")
    public MedicationsForm clickOnDeleteForm_btn() {
        driver.element().click(delete_btn)
                .click(yesConfirmationMessage_btn);
        return this;
    }
}
