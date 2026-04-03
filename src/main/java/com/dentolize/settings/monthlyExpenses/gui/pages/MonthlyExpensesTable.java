package com.dentolize.settings.monthlyExpenses.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MonthlyExpensesTable {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public MonthlyExpensesTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By newMonthlyExpenses_btn = commonLocators.dynamicButtons("New Monthly Expense");

    @Step("Click on [ Create new Monthly Expenses ] button")
    public MonthlyExpensesForm clickOnCreateNewMonthlyExpenses_btn() {
        driver.element().click(newMonthlyExpenses_btn);
        return new MonthlyExpensesForm(driver);
    }

    @Step("Click on [ Update Monthly Expenses ] button")
    public MonthlyExpensesForm clickOnUpdateMonthlyExpenses_btn(int index) {
        driver.element().click(commonLocators.dynamicUpdateIcon(index));
        return new MonthlyExpensesForm(driver);
    }
}
