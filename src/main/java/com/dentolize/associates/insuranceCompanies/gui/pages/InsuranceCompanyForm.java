package com.dentolize.associates.insuranceCompanies.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class InsuranceCompanyForm {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public InsuranceCompanyForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By name_textField = By.id("InsuranceCompanyForm_name");
    private final By limit_numeric = By.id("InsuranceCompanyForm_insuranceLimit");
    private final By discount_numeric = By.id("InsuranceCompanyForm_insurancePercentage");
    private final By details_textArea = By.id("InsuranceCompanyForm_details");
    private final By create_btn = this.commonLocators.dynamicSubmitButtons("Create");
    private final By update_btn = this.commonLocators.dynamicSubmitButtons("Update");
    private final By delete_btn = this.commonLocators.dynamicButtons("Delete");
    private final By yesConfirmationMessage_btn = this.commonLocators.dynamicSubmitButtons("Yes");
    private final By noConfirmationMessage_btn = this.commonLocators.dynamicButtons("No");

    @Step("Enter insurance company required data [ {name} , {limit} , {discount} ]")
    public InsuranceCompanyForm enterInsuranceCompanyRequiredData(String name, String limit, String discount) {
        enterInsuranceCompanyName(name);
        enterInsuranceCompanyLimit(limit);
        enterInsuranceCompanyDiscount(discount);
        return this;
    }

    @Step("Enter Insurance Company name [ {name} ]")
    public InsuranceCompanyForm enterInsuranceCompanyName(String name) {
        driver.element().type(name_textField, name);
        return this;
    }

    @Step("Enter Insurance Company Limit [ {limit} ]")
    public InsuranceCompanyForm enterInsuranceCompanyLimit(String limit) {
        driver.element().type(limit_numeric, limit);
        return this;
    }

    @Step("Enter Insurance Company Discount [ {discount} ]")
    public InsuranceCompanyForm enterInsuranceCompanyDiscount(String discount) {
        driver.element().type(discount_numeric, discount);
        return this;
    }


    @Step("Enter Insurance Company Details ")
    public InsuranceCompanyForm enterInsuranceCompanyDetails(String details) {
        driver.element().type(details_textArea, details);
        return this;
    }

    @Step("Click On [ Create ] button")
    public InsuranceCompanyForm clickOnCreateForm_btn() {
        driver.element().click(create_btn);
        return this;
    }

    @Step("Click On [ Update ] button")
    public InsuranceCompanyForm clickOnUpdateForm_btn() {
        driver.element().click(update_btn);
        return this;
    }

    @Step("Click On [ Delete ] button")
    public InsuranceCompanyForm clickOnDeleteForm_btn() {
        driver.element().click(delete_btn)
                .click(yesConfirmationMessage_btn);
        return this;
    }
}
