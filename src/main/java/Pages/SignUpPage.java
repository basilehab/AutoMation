package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends PageBase {
    public WebDriver driver;

    public SignUpPage(WebDriver driver)
    {
        this.driver = driver;
    }
    //locators
    By loginAndSignUpBTN = By.xpath("//a[@href='/login']");
    By signUpNameField = By.xpath("//input[@data-qa='signup-name']");
    By signUpMailField = By.xpath("//input[@data-qa='signup-email']");
    By signUpBTN = By.xpath("//button[@data-qa='signup-button']");
    By signUpTitleCheckBox = By.xpath("//input[@id='id_gender1']");
    By signUpPasswordField = By.xpath("//input[@id='password']");
    By birthDayField = By.xpath("//select[@id='days']"); //click
    By selectedBirthDay= By.xpath("//select[@id='days']//option[@value='1']");
    By selectedBirthMonth= By.xpath("//select[@id='months']//option[@value='10']");
    By selectedBirthYears= By.xpath("//select[@id='years']//option[@value='2010']");
    By birthMonthField = By.xpath("//select[@id='months']"); //click
    By birthYearField = By.xpath("//select[@id='years']"); //click
    By firstNameField = By.xpath("//input[@id='first_name']");
    By lastNameField = By.xpath("//input[@id='last_name']");
    By Address = By.xpath("//input[@id='address1']");
    By countryField = By.xpath("//select[@id='country']");
    By SelectedCountryField = By.xpath("//select[@id='country']//option[@value='Canada']");//click
    By state = By.xpath("//input[@id='state']");
    By city = By.xpath("//input[@id='city']");
    By zipCode = By.xpath("//input[@id='zipcode']");
    By mobileNumber = By.xpath("//input[@id='mobile_number']");
    By createAccountBTN = By.xpath("//*[text()='Create Account']");
    By createdMSG = By.xpath("//h2[@data-qa='account-created']/b");
    By continueBTN = By.xpath("//a[@data-qa='continue-button']");
    By signOutBTN = By.xpath("//a[@href='/logout']");

    //data
    String  signUpName = "Mohamed";
    String Email = "newUser"+Math.random()+"@gmail.com";
    String password = "123321123321";
    String address = "Egypt,Cairo,Maadi";
    String stateName = "Cairo";
    String CityName = "Maadi";
    String zipCodeValue = "212231";
    String mobileNumberValue = "12223432";

    public void fillFirstData()
    {
        fluentWait(driver , 20, 5, loginAndSignUpBTN );
        driver.findElement(loginAndSignUpBTN).click();
        driver.findElement(signUpNameField).sendKeys(signUpName);
        driver.findElement(signUpMailField).sendKeys(Email);
        System.out.println("Newly Created E-Mail: " +Email);
        driver.findElement(signUpBTN).click();
    }

    public void fillSecondSignUpScreenData()
    {
        driver.findElement(signUpTitleCheckBox).click();
        driver.findElement(signUpPasswordField).sendKeys(password);
        driver.findElement(birthDayField).click();
        driver.findElement(selectedBirthDay).click();
        driver.findElement(birthMonthField).click();
        driver.findElement(selectedBirthMonth).click();
        driver.findElement(birthYearField).click();
        driver.findElement(selectedBirthYears).click();
        driver.findElement(firstNameField).sendKeys(signUpName);
        driver.findElement(lastNameField).sendKeys(signUpName);
        driver.findElement(Address).sendKeys(address);
        driver.findElement(countryField).click();
        driver.findElement(SelectedCountryField).click();
        driver.findElement(state).sendKeys(stateName);
        driver.findElement(city).sendKeys(CityName);
        driver.findElement(zipCode).sendKeys(zipCodeValue);
        driver.findElement(mobileNumber).sendKeys(mobileNumberValue);
        driver.findElement(createAccountBTN).click();
    }

    public String validateCreatedAccount()
    {
        String accountCreatedMSG = driver.findElement(createdMSG).getText();
        driver.findElement(continueBTN).click();
        driver.findElement(signOutBTN).click();
        return accountCreatedMSG;
    }
}
