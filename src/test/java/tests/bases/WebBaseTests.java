package tests.bases;

import com.dentolize.authentication.api.AuthenticationApi;
import com.dentolize.authentication.gui.pages.LoginPage;
import com.dentolize.dashboard.gui.pages.HomePage;
import com.dentolize.search.SearchApis;
import com.shaft.driver.SHAFT;
import engine.Helper;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.*;

public class WebBaseTests extends GlobalBases {
    public SHAFT.GUI.WebDriver driver;
    public SHAFT.API restActions;
    protected SearchApis searchApis;
    private AuthenticationApi authenticationApi;
    protected String randomNumber = Helper.getRandomNumberBetweenTwoValuesAsString(1, 100);

    protected static String COOKIE;

    @Story("As a User, I want to \"Login\" by Email")
    @Severity(SeverityLevel.BLOCKER)
    @BeforeClass
    public void LoginViaEmailApi() {
        authenticationApi = new AuthenticationApi(restActions);
        SHAFT.TestData.JSON users_TD = new SHAFT.TestData.JSON(System.getProperty("loginJsonData"));
        COOKIE = authenticationApi.signInViaEmail(users_TD.getTestData("owner.email"), users_TD.getTestData("owner.password"));
    }

    @BeforeMethod(description = "Before Method initialize driver and login via email")
    public void loginViaEmail() {
        String email = settings_TD.getCellData(usersSheet, "User1", "Email");
        String password = settings_TD.getCellData(usersSheet, "User1", "Password");
      //  SHAFT.Properties.web.set().headlessExecution(true);
        driver = new SHAFT.GUI.WebDriver();
        new LoginPage(driver).navigateTo_loginPage().loginViaEmail(email, password);
        new HomePage(driver).switchToBranch(settings_TD.getCellData(branchesSheet, "Branch1", "Name"));
    }

    @AfterMethod(description = "After Method - Close browser")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
