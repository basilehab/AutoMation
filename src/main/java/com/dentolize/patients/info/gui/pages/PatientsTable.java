package com.dentolize.patients.info.gui.pages;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class PatientsTable {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public PatientsTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By search_input = By.xpath("(//span[@class='ant-input-affix-wrapper']//input[@type='search'])[1]");
    private final By rowOfPatient_table = By.xpath("//div[@class='ant-table-body']");

    @Step("Click on [ New Patient ] button")
    public PatientForm clickOnNewPatient_btn() {
        By newPatient_btn = this.commonLocators.dynamicButtons("New Patient");
        driver.element().click(newPatient_btn);
        return new PatientForm(driver);
    }

    @Step("Click on [ Edit Patient ] button")
    public PatientForm clickOnEditPatient_btn(int patientIndex) {
        driver.element().click(this.commonLocators.dynamicUpdateIcon(patientIndex));
        return new PatientForm(driver);
    }

    @Step("Search for Patient by name, Id , Phone number and Open Patient Profile")
    public PatientProfile searchForPatient(String searchQuery) {
        (new ElementActions()).type(search_input, searchQuery).type(search_input, Keys.ENTER);
        return new PatientProfile(driver);
    }

    @Step("Search for Patient by name, Id , Phone number and Open Patient Profile ")
    public PatientForm searchForPatientAndOpenProfile(String searchQuery) {
        driver.element().type(search_input, searchQuery).click(rowOfPatient_table);
        return new PatientForm(driver);
    }


}
