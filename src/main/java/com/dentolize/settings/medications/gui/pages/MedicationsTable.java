package com.dentolize.settings.medications.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MedicationsTable {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public MedicationsTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By newMonthlyExpenses_btn = this.commonLocators.dynamicButtons("New Medication");

    @Step("Click on [ Create new Medications ] button")
    public MedicationsForm clickOnCreateNewMedications_btn() {
        driver.element().click(newMonthlyExpenses_btn);
        return new MedicationsForm(driver);
    }

    @Step("Click on [ Update Medications ] button")
    public MedicationsForm clickOnUpdateMedications_btn(int branchIndex) {
        driver.element().click(this.commonLocators.dynamicUpdateIcon(branchIndex));
        return new MedicationsForm(driver);
    }
}
