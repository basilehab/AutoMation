package tests.authentication;

import com.dentolize.dashboard.gui.pages.HomePage;
import com.dentolize.authentication.gui.pages.LoginPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.tools.io.ReportManager;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import tests.bases.GlobalBases;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Epic("Login Module")
@Feature("Web")
@Test(groups = {"web"})
public class Web_Authentication_Tests extends GlobalBases {
	public SHAFT.GUI.WebDriver driver;
	JSONFileManager jsonFileManager;
	@Test(groups = "smokeTest", description = "Verify the User can Login via email")
    @Issues({@Issue(""), @Issue("")})
    @Story("As a User, I want to \"Login\" by Email")
	@TmsLink("Test Cases")
	@Link("https://my.dentope.com/auth/login")
    @Severity(SeverityLevel.CRITICAL)
	public void userLogin_viaValidEmail () throws IOException {
        String email = settings_TD.getCellData(usersSheet, "User1", "Email");
        String password = settings_TD.getCellData(usersSheet, "User1", "Password");
		driver = new SHAFT.GUI.WebDriver();
		new LoginPage(driver)
				.navigateTo_loginPage()
				.loginViaEmail(email, password);
		new HomePage(driver).switchToBranch(settings_TD.getCellData(branchesSheet, "Branch1", "Name"));
		driver.verifyThat()
				.element(HomePage.dashboard_menuTitle_txt()).text()
                .contains("Dashboard")
				.withCustomReportMessage("Verify that the \" user\" logged in By Get  text")
				.perform();

		Set<Cookie> cookies = driver.browser().getAllCookies();
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		// Convert cookies to Map format
		Map<String, Object> cookiesMap = new HashMap<>();
		for (Cookie cookie : cookies) {
			Map<String, Object> cookieData = new HashMap<>();
			cookieData.put("name", cookie.getName());
			cookieData.put("value", cookie.getValue());
			cookieData.put("domain", cookie.getDomain());
			cookieData.put("path", cookie.getPath());
			cookieData.put("expiry", cookie.getExpiry());
			cookieData.put("isSecure", cookie.isSecure());
			cookiesMap.put(cookie.getName(), cookieData);
		}
		ReportManager.log(cookiesMap.toString());
		mapper.writeValue(new File("src/test/resources/testDataFiles/login/cookies.json"), cookiesMap);
	}
}
