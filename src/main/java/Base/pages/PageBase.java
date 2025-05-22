package Base.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;

//Driver
public class PageBase {
    public WebDriver driver;

    public void openBrowser(String URL) {
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.setAcceptInsecureCerts(true);

            this.driver = new ChromeDriver(options);
            this.driver.manage().window().maximize();
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            this.driver.get(URL);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize WebDriver", e);
        }
    }

    public void closeBrowser() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    //Locators Heroku app
    public final By abTestLink = By.cssSelector("a[href='/abtest']");
    public final By basicAuthLink = By.cssSelector("a[href='/basic_auth']");
    public final By brokenImagesLink = By.cssSelector("a[href='/broken_images']");
    public final By challengingDomLink = By.cssSelector("a[href='/challenging_dom']");
    public final By checkboxesLink = By.cssSelector("a[href='/checkboxes']");
    public final By contextMenuLink = By.cssSelector("a[href='/context_menu']");
    public final By digestAuthLink = By.cssSelector("a[href='/digest_auth']");
    public final By disappearingElementsLink = By.cssSelector("a[href='/disappearing_elements']");
    public final By dragAndDropLink = By.cssSelector("a[href='/drag_and_drop']");
    public final By dropdownLink = By.cssSelector("a[href='/dropdown']");
    public final By dynamicContentLink = By.cssSelector("a[href='/dynamic_content']");
    public final By dynamicControlsLink = By.cssSelector("a[href='/dynamic_controls']");
    public final By dynamicLoadingLink = By.cssSelector("a[href='/dynamic_loading']");
    public final By entryAdLink = By.cssSelector("a[href='/entry_ad']");
    public final By exitIntentLink = By.cssSelector("a[href='/exit_intent']");
    public final By fileUploadLink = By.cssSelector("a[href='/upload']");
    public final By floatingMenuLink = By.cssSelector("a[href='/floating_menu']");
    public final By forgotPasswordLink = By.cssSelector("a[href='/forgot_password']");
    public final By formAuthenticationLink = By.cssSelector("a[href='/login']");
    public final By framesLink = By.cssSelector("a[href='/frames']");
    public final By geolocationLink = By.cssSelector("a[href='/geolocation']");
    public final By horizontalSliderLink = By.cssSelector("a[href='/horizontal_slider']");
    public final By hoversLink = By.cssSelector("a[href='/hovers']");
    public final By infiniteScrollLink = By.cssSelector("a[href='/infinite_scroll']");
    public final By inputsLink = By.cssSelector("a[href='/inputs']");
    public final By jqueryUIMenusLink = By.cssSelector("a[href='/jqueryui/menu']");
    public final By javascriptAlertsLink = By.cssSelector("a[href='/javascript_alerts']");
    public final By javascriptErrorLink = By.cssSelector("a[href='/javascript_error']");
    public final By keyPressesLink = By.cssSelector("a[href='/key_presses']");
    public final By largeAndDeepDomLink = By.cssSelector("a[href='/large']");
    public final By multipleWindowsLink = By.cssSelector("a[href='/windows']");
    public final By nestedFramesLink = By.cssSelector("a[href='/nested_frames']");
    public final By notificationMessagesLink = By.cssSelector("a[href='/notification_message']");
    public final By addRemoveLink = By.cssSelector("a[href='/add_remove_elements/']");
    public final By addElementButton = By.cssSelector(".example > button");
    public final By deleteButton = By.cssSelector("button[onclick='deleteElement()']");
    public final By contentMessage = By.cssSelector("div#content p");
    public final By checkbox1 = By.xpath("//*[@id='checkboxes']/input[1]");
    public final By checkbox2 = By.xpath("//*[@id='checkboxes']/input[2]");
    public final By contextBox = By.id("hot-spot");

    //Locators AutomationExercise
    public final By login = By.cssSelector("a[href='/login']");
    public final By name = By.name("email");
    public final By password = By.name("password");
    public final By loginButton =  By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");


}



