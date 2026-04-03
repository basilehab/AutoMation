package com.dentolize.associates.insuranceCompanies.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class InsuranceCompanyTable {
    private final SHAFT.GUI.WebDriver driver;
    private CommonLocators commonLocators;

    public InsuranceCompanyTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By newInsuranceCompany_btn = this.commonLocators.dynamicButtons("New Insurance Company");

    @Step("Click on [ Create new Insurance Company ] button")
    public InsuranceCompanyForm clickOnCreateInsuranceCompany_btn() {
        driver.element().click(newInsuranceCompany_btn);
        return new InsuranceCompanyForm(driver);
    }

    @Step("Click on [ Update Insurance Company ] button")
    public InsuranceCompanyForm clickOnUpdateInsuranceCompany_btn(int index) {
        driver.element().click(this.commonLocators.dynamicUpdateIcon(index));
        return new InsuranceCompanyForm(driver);
    }
}
