package com.dentolize.patients.prescriptions.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PrescriptionForm {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public PrescriptionForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By createPrescription_btn = this.commonLocators.dynamicButtons("Create");
    private final By updatePrescription_btn = this.commonLocators.dynamicButtons("Update");
    private final By deletePrescription_btn = this.commonLocators.dynamicButtons("Delete");
    private final By yesConfirmationMessage_btn = this.commonLocators.dynamicButtons("Yes");
    private final By noConfirmationMessage_btn = this.commonLocators.dynamicButtons("No");
    private final By details_txtField = By.xpath("//form[@id='PrescriptionForm']//textarea");

    @Step("Enter Prescription Details")
    public PrescriptionForm enterPrescriptionDetails(String details) {
        driver.element().type(details_txtField, details);
        return this;
    }

    @Step("Click On [ Update ] button")
    public PrescriptionForm clickOnCreatePrescription_btn() {
        driver.element().click(createPrescription_btn);
        return this;
    }

    @Step("Click On [ Update ] button")
    public PrescriptionForm clickOnUpdatePrescription_btn() {
        driver.element().click(updatePrescription_btn);
        return this;
    }

    @Step("Click On [ Delete ] button")
    public PrescriptionForm clickOnDeletePrescription_btn() {
        driver.element().click(deletePrescription_btn).click(yesConfirmationMessage_btn);
        return this;
    }
}
