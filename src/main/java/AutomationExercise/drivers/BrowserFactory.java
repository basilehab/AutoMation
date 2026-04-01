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
                    ChromeOptions options = getChromeOptions();
                    return new ChromeDriver(options);

                case "firefox":
                    FirefoxOptions firefoxOptions = getFirefoxOptions();
                    return new FirefoxDriver(firefoxOptions);

                default:
                    EdgeOptions edgeOptions = new EdgeOptions();
                    return new EdgeDriver(edgeOptions);
            }
        }

        private static ChromeOptions getChromeOptions(){
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
            return options;
        }

        private static EdgeOptions getEdgeOptions(){
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");
            Map<String, Object> EdgePrefs = Map.of("profile.default_content_setting_values.notifications", true,
                    "credentials_enable_service", false ,
                    "profile.password_manager_enabled", false,
                    "autofill.profile_enabled", false);
            options.setExperimentalOption("prefs",EdgePrefs);
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            //options.addArguments("--headless");
            return options;
        }

        private static FirefoxOptions getFirefoxOptions(){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--start-maximized");
            firefoxOptions.addArguments("--disable-extensions");
            firefoxOptions.addArguments("--disable-infobars");
            firefoxOptions.addArguments("--disable-notifications");
            firefoxOptions.addArguments("--remote-allow-origins=*");
            //firefoxOptions.addArguments("--headless");
            firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            firefoxOptions.setAcceptInsecureCerts(true);
            return firefoxOptions;
        }

}
