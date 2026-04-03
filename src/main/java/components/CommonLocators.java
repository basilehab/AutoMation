package components;

import org.openqa.selenium.By;

public class CommonLocators {

    public static By getByTestId(String dataTestId) {
        return By.xpath(String.format("(//*[@data-testid='%s'])[1]", dataTestId));
    }

    public static By getInputByTestId(String dataTestId) {
        return By.xpath(String.format("(//*[@data-testid='%s']//input)[1]", dataTestId));
    }


    public By dynamicButtons(String buttonName) {
        return By.xpath("//button[@type='button' and contains(.,'" + buttonName + "')]");
    }

    public By dynamicSubmitButtons(String buttonName) {
        return By.xpath("//button[@type='submit' and contains(.,'" + buttonName + "')]");
    }

    public By listOfOptionByName(String optionName) {
        return By.xpath("//div[@class='ant-select-item-option-content' and contains(.,'" + optionName + "')]");
    }

    protected By listOfOptionByIndex(int index) {
        return By.xpath("(//div[@class='ant-select-item-option-content'])[" + index + "]");
    }

    public By datePickerToday_btn = By.xpath("//div//a[@class='ant-picker-today-btn' and contains(.,'Today')]");
    public By details_textArea = By.xpath("//div[@class='ql-editor ql-blank' or @class='ql-editor']");
    public By uploadFile_input = By.xpath("//div[@class='ant-upload ant-upload-select']//input[@type='file']");

    // ***************** table Locators  ***************** //
    public By dynamicUpdateIcon(int index) {
        return By.xpath("(//td//button[@type='button' and @class='ant-btn css-kko202 ant-btn-link'])[" + index + "]");
    }

    protected By dynamicHyperLinkPatient(int index) {
        return By.xpath("(//td//div[@class='ant-space-item']//a[@href])[" + index + "]");
    }

    public By dynamicDeleteIcon(int index) {
        return By.xpath("(//td//button[@type='button' and @class='ant-btn css-kko202 ant-btn-primary ant-btn-icon-only ant-btn-dangerous'])[" + index + "]");
    }

    // ************** success message Locators   ************* //
    public static By successMessageText(String messageName) {
        return org.openqa.selenium.By.xpath("//div[@class='ant-message-custom-content ant-message-success' and contains(.,'" + messageName + "')]");
    }

    public static By successMessageText() {
        return By.xpath("//div[@class='ant-message-custom-content ant-message-success']");
    }
}
