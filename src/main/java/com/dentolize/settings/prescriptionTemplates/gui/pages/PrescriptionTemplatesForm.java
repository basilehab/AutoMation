package com.dentolize.settings.prescriptionTemplates.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PrescriptionTemplatesForm {

    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public PrescriptionTemplatesForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By name_textField = By.id("MedicationsForm_templateName");
    private final By medicationMame_textField = By.id("MedicationsForm_name");
    private final By addMedication_btn = commonLocators.dynamicSubmitButtons("Add Medication");
    private final By amount_textField = By.id("PatientReminderForm_amount");
    private final By type_textField = By.id("PatientReminderForm_type");
    private final By create_btn = commonLocators.dynamicButtons("Create");
    private final By update_btn = commonLocators.dynamicButtons("Update");
    private final By delete_btn = commonLocators.dynamicButtons("Delete");
    private final By yesConfirmationMessage_btn = commonLocators.dynamicButtons("Yes");
    private final By noConfirmationMessage_btn = commonLocators.dynamicButtons("No");

    @Step("Enter Monthly Expenses name [{name}]")
    public PrescriptionTemplatesForm enterPrescriptionTemplateName(String name) {
        driver.element().type(name_textField, name);
        return this;
    }

    @Step("Select Medication name [{name}]")
    public PrescriptionTemplatesForm selectMedicationName(String medicationName) {
        driver.element()
                .type(medicationMame_textField, medicationName)
                .click(commonLocators.listOfOptionByName(medicationName))
                .click(addMedication_btn);
        return this;
    }


    @Step("Click On [ Create ] button")
    public PrescriptionTemplatesForm clickOnCreateForm_btn() {
        driver.element().click(create_btn);
        return this;
    }

    @Step("Click On [ Update ] button")
    public PrescriptionTemplatesForm clickOnUpdateForm_btn() {
        driver.element().click(update_btn);
        return this;
    }

    @Step("Click On [ Delete ] button")
    public PrescriptionTemplatesForm clickOnDeleteForm_btn() {
        driver.element().click(delete_btn)
                .click(yesConfirmationMessage_btn);
        return this;
    }
}
