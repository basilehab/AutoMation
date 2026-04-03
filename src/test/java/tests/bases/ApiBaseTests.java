package tests.bases;

import com.dentolize.authentication.api.AuthenticationApi;
import com.dentolize.search.SearchApis;
import com.shaft.driver.SHAFT;
import engine.Helper;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;

public class ApiBaseTests {
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
}
