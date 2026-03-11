package AutomationExercise.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;
import java.util.Objects;


public class BrowserFactory {

        public static WebDriver getBrowser(String browserName) {
            switch (browserName.toLowerCase()){
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized");
                    options.addArguments("--disable-extensions");
                    options.addArguments("--disable-infobars");
                    options.addArguments("--disable-notifications");
                    options.addArguments("--remote-allow-origins=*");
                    Map<String, Object> prefs = Map.of("profile.default_content_setting_values.notifications", true,
                            "credentials_enable_service", false ,
                            "profile.password_manager_enabled", false,
                            "autofill.profile_enabled", false);
                    options.setExperimentalOption("prefs",prefs);
                    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    //options.addArguments("--headless");
                    return new ChromeDriver();

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    firefoxOptions.addArguments("--disable-extensions");
                    firefoxOptions.addArguments("--disable-infobars");
                    firefoxOptions.addArguments("--disable-notifications");
                    firefoxOptions.addArguments("--remote-allow-origins=*");
                    firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    firefoxOptions.setAcceptInsecureCerts(true);
                    return new FirefoxDriver();

                default:
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--disable-extensions");
                    edgeOptions.addArguments("--disable-infobars");
                    edgeOptions.addArguments("--disable-notifications");
                    edgeOptions.addArguments("--remote-allow-origins=*");
                    Map<String, Object> EdgePrefs = Map.of("profile.default_content_setting_values.notifications", true,
                            "credentials_enable_service", false ,
                            "profile.password_manager_enabled", false,
                            "autofill.profile_enabled", false);
                    edgeOptions.setExperimentalOption("prefs",EdgePrefs);
                    edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    //options.addArguments("--headless");
                    return new EdgeDriver(edgeOptions);
            }
        }

}
