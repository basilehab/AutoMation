package com.dentolize.inventory.gui.pages;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MasterInventoryPage {
    private final SHAFT.GUI.WebDriver driver;

    public MasterInventoryPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By newInventoryItem_Btn = By.xpath("//button[@type='button']//span[contains(text(),'New Inventory Item')]");
    private final By itemName_input = By.id("InventoryForm_name");
    private final By storage_field = By.id("InventoryForm_storage");
    private final By storage_list = By.xpath("(//div[@class='ant-select-item ant-select-item-option'])[3]");
    private final By type_field = By.id("InventoryForm_type");
    private final By type_list = By.xpath("//div[@class='ant-select-item ant-select-item-option ant-select-item-option-active']");
    private final By endo_select = By.xpath("//div[@title='Endo']");

    public static By getSuccessMessage() {
        return By.xpath("//span[contains(text(),'Item created successfully')]");
    }

    private final By create_btn = By.xpath("(//div/button[@class='ant-btn ant-btn-primary'])[2]");

    @Step("Click on [New Inventory Item] button")
    public MasterInventoryPage clickOnNewInventoryItem() {
        driver.element().click(newInventoryItem_Btn);
        return this;
    }

    @Step("Click on [New Inventory Item] button")
    public MasterInventoryPage enterItemName(String itemName) {
        driver.element().type(itemName_input, itemName);
        return this;
    }

    @Step("Click on [New Inventory Item] button")
    public MasterInventoryPage selectStorage() {
        (new ElementActions())
                .click(storage_field)
                .click(storage_list);
        return this;
    }

    @Step("Click on [New Inventory Item] button")
    public MasterInventoryPage selectType() {
        (new ElementActions())
                .click(type_field)
                .click(endo_select);
        return this;
    }

    @Step("Click on [New Inventory Item] button")
    public MasterInventoryPage clickOnCreate() {
        driver.element().click(create_btn);
        return this;
    }
}
