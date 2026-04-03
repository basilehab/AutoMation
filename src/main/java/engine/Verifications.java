package engine;

import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.openqa.selenium.By;

import java.util.List;

import static engine.ApiBase.StatusCode.SUCCESS;
import static engine.ApiBase.expectedResponseTime;

public class Verifications {
    @Step("Verify that the response time is less than 800 milliseconds and the status code is 200")
    public static void verifyResponseTimeAndStatusCode(Response response) {
        long actualResponseTime = RestActions.getResponseTime(response);
        CustomReporter.getInstance().logInfoStep("Response time: [ " + actualResponseTime + " ] milliseconds");
        Validations.verifyThat().number(actualResponseTime).isLessThan(expectedResponseTime).perform();
        int actualStatusCode = RestActions.getResponseStatusCode(response);
        CustomReporter.getInstance().logInfoStep("Status code: [ " + actualStatusCode + " ]");
        Validations.verifyThat().number(actualStatusCode).isEqualTo(SUCCESS.getCode()).perform();
        Validations.verifyThat().response(response).body().isNotNull();
        Validations.verifyThat().response(response).body().doesNotContain("error");
    }

    public static void verifyResponseIsEqual(Response response, String jsonPath, String expectedValue) {
        if (expectedValue != null && !expectedValue.isEmpty() && !expectedValue.equalsIgnoreCase("null")) {
            Validations.verifyThat().response(response).extractedJsonValue(jsonPath).isEqualTo(expectedValue).perform();
        }
    }

    public static void validateResponseContains(Response response, String jsonPath, String expectedValue) {
        if (expectedValue != null && !expectedValue.isEmpty() && !expectedValue.equalsIgnoreCase("null")) {
            Validations.verifyThat().response(response).extractedJsonValue(jsonPath).contains(expectedValue).perform();
        }
    }

    public static void validateResponseListIsEqual(Response response, String jsonPath, List<?> expectedValue) {
        List<?> list = RestActions.getResponseJSONValueAsList(response, jsonPath);
        Validations.verifyThat().object(list).isEqualTo(expectedValue).perform();
    }


    @Step("Verify that the element [ {elementLocator} ] is equal to [ {expectedText} ]")
    public static void verifyTextForElement(SHAFT.GUI.WebDriver driver, By elementLocator, String expectedText) {
        driver.verifyThat().element(elementLocator).text().equalsIgnoringCaseSensitivity(expectedText).perform();
    }

    public static void verifyTextForElement(SHAFT.GUI.WebDriver driver, By elementLocator, String expectedText, String customMessage) {
        driver.verifyThat().element(elementLocator).text().isEqualTo(expectedText).withCustomReportMessage(customMessage).perform();
    }


    private Verifications() {
        throw new IllegalStateException("Utility class");
    }
}
