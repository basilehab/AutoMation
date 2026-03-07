package TestCases;

import Base.driver.DriverManager;
import Base.pages.HeroKuPage;
import Base.pages.Nfc;
import Base.utils.AllureUtils;
import Base.utils.ElementAction;
import Base.utils.Screenshots;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class NfcTest { public WebDriver driver;

        @BeforeMethod(alwaysRun = true)
        public void setup() {
        driver = DriverManager.openBrowser("chrome");
            new Nfc(driver)
                    .navigateToPage()
                    .login("admin@smartqr.com", "basil2025");    }

@Test
    public void successfulLogin() {
}


    @AfterMethod (alwaysRun = true)
    public void afterMethod() {
        DriverManager.closeBrowser();
    }
}
