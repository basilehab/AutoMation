package com.dentolize.settings.monthlyExpenses.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;

public class MonthlyExpensesProfile {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public MonthlyExpensesProfile(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }
}
