package components;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.ReportManager;
import engine.Waits;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationMessage {
    private final SHAFT.GUI.WebDriver driver;

    public ConfirmationMessage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By timeAndDrConfirmationMsg_title = By.xpath("//span[@class='ant-modal-confirm-title'][contains(.,'Doctor or Room have another appointment at the same time')]");

    private By timeAndDrConfirmationMsg_btn(String action) {
        return By.xpath("//div[@class='ant-modal-confirm-btns']//button[@type='button'][contains(.,'" + action + "')]");
    }

    private final By smsConfirmationMsg_title = By.xpath("//span[@class='ant-modal-confirm-title'][contains(.,'SMS Will be sent')]");

    private By smsConfirmationMsg_btn(String action) {
        return By.xpath("//div[@class='ant-modal-confirm-btns']//button[@type='button'][contains(.,'" + action + "')]");
    }

    private By duplicatePhoneNumberConfirmationMsg_title = By.xpath("//span[@class='ant-modal-confirm-title'][contains(.,'Duplicate Patients')]");

    private By duplicatePhoneNumberConfirmationMsg_btn(String action) {
        return By.xpath("//div[@class='ant-modal-confirm-btns']//button[@type='button'][contains(.,'" + action + "')]");
    }

    private final By phoneNumberIsInvalidConfirmationMsg_title = By.xpath("//span[@class='ant-modal-confirm-title'][contains(.,'Phone number is invalid and wont receive SMS or whatsapp messages')]");

    private By phoneNumberIsInvalidConfirmationMsg_btn(String action) {
        return By.xpath("//div[@class='ant-modal-confirm-btns']//button[@type='button'][contains(.,'" + action + "')]");
    }

    @Step(" [{YesOrNo}] Accept the Time and Doctor Confirmation Message")
    public ConfirmationMessage confirmAppointmentSameTime(String YesOrNo) {
        checkAppointmentSameTimeConfirmationMsg(YesOrNo);
        return this;
    }

    @Step("[{YesOrNo}] Accept the SMS Confirmation Message")
    public ConfirmationMessage confirmSendSms(String YesOrNo) {
        checkSmsConfirmationMsg(YesOrNo);
        return this;
    }

    @Step("[{YesOrNo}] Accept the Phone Number is Invalid Confirmation Message")
    public ConfirmationMessage confirmInvalidNumber(String YesOrNo) {
        checkInvalidNumberConfirmationMsg(YesOrNo);
        return this;
    }

    @Step("[{YesOrNo}] Accept the Duplicate Phone Number Confirmation Message")
    public ConfirmationMessage confirmDuplicateNumber(String YesOrNo) {
        checkDuplicatePhoneNumber(YesOrNo);
        return this;
    }

    private void checkAppointmentSameTimeConfirmationMsg(String YesOrNo) {
        try {
            boolean isDisplayed = driver.getDriver().findElement(timeAndDrConfirmationMsg_title).isDisplayed();
            switch (YesOrNo.toLowerCase()) {
                case "yes" -> {
                    if (isDisplayed) {
                        driver.element().doubleClick(timeAndDrConfirmationMsg_btn("Confirm"));
                    }
                }
                case "no" -> {
                    if (isDisplayed) {
                        driver.element().doubleClick(timeAndDrConfirmationMsg_btn("Cancel"));
                    }
                }
                case "" -> ReportManager.log("The value of YesOrNo is blank");
                default -> ReportManager.log("There is no popup message appeared");
            }
        } catch (Exception e) {
            ReportManager.log("There is no Confirmation message was displayed ");
        }
    }

    private void checkSmsConfirmationMsg(String YesOrNo) {
        try {
            if (driver.getDriver().findElement(smsConfirmationMsg_title).isDisplayed()) {
                String confTitle = driver.element().getText(smsConfirmationMsg_title);
                if (confTitle.contains("SMS Will be sent")) {
                    if (YesOrNo.equalsIgnoreCase("Yes")) {
                        driver.element().doubleClick(smsConfirmationMsg_btn("Yes"));
                    } else if (YesOrNo.equalsIgnoreCase("No")) {
                        driver.element().doubleClick(smsConfirmationMsg_btn("No"));
                    } else {
                        ReportManager.log("The value of YesOrNo is not correct");
                    }
                } else {
                    ReportManager.log("The confirmation message title is not correct");
                }
            }
        } catch (NoSuchElementException e) {
            ReportManager.log("There is no Confirmation message was displayed " + e.getMessage());
        }
    }

    private void checkInvalidNumberConfirmationMsg(String YesOrNo) {
        try {
            boolean isDisplayed = driver.getDriver().findElement(phoneNumberIsInvalidConfirmationMsg_title).isDisplayed();
            switch (YesOrNo.toLowerCase()) {
                case "yes" -> {
                    if (isDisplayed) {
                        driver.element().doubleClick(phoneNumberIsInvalidConfirmationMsg_btn("Confirm"));
                    }
                }
                case "no" -> {
                    if (isDisplayed) {
                        driver.element().doubleClick(phoneNumberIsInvalidConfirmationMsg_btn("Cancel"));
                    }
                }
                case "" -> ReportManager.log("The value of YesOrNo is blank");
                default -> ReportManager.log("There is no popup message appeared");
            }
        } catch (Exception e) {
            ReportManager.log("There is no Confirmation message was displayed ");
        }
    }

    private void checkDuplicatePhoneNumber(String YesOrNo) {
        try {
            boolean isDisplayed = driver.getDriver().findElement(duplicatePhoneNumberConfirmationMsg_title).isDisplayed();
            switch (YesOrNo.toLowerCase()) {
                case "yes" -> {
                    if (isDisplayed) {
                        driver.element().doubleClick(duplicatePhoneNumberConfirmationMsg_btn("OK"));
                    }
                }
                case "no" -> {
                    if (isDisplayed) {
                        driver.element().doubleClick(duplicatePhoneNumberConfirmationMsg_btn("Cancel"));
                    }
                }
                case "" -> ReportManager.log("The value of YesOrNo is blank");
                default -> ReportManager.log("There is no popup message appeared");
            }
        } catch (Exception e) {
            ReportManager.log("There is no Confirmation message appeared ");
        }
    }

    private void checkIsPresent(String YesOrNo) {
        try {
            if (Waits.getExplicitWait(driver.getDriver(), 30).until(ExpectedConditions.visibilityOfElementLocated(duplicatePhoneNumberConfirmationMsg_title)).isDisplayed()) {
                String confTitle = driver.element().getText(duplicatePhoneNumberConfirmationMsg_title);
                if (confTitle.contains("Duplicate Patients")) {
                    if (YesOrNo.equalsIgnoreCase("Yes")) {
                        driver.element().doubleClick(duplicatePhoneNumberConfirmationMsg_btn("OK"));
                    } else if (YesOrNo.equalsIgnoreCase("No")) {
                        driver.element().doubleClick(duplicatePhoneNumberConfirmationMsg_btn("Cancel"));
                        ReportManager.log("There is no duplicate phone number");
                    } else {
                        ReportManager.log("The value of YesOrNo is not correct");
                    }
                } else {
                    ReportManager.log("The confirmation message title is not correct");
                }
            }
        } catch (NoSuchElementException e) {
            ReportManager.log("There is no Confirmation message appeared ");
        }
    }
}
