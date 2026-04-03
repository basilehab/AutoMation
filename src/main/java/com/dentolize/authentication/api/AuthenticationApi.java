package com.dentolize.authentication.api;

import com.shaft.driver.SHAFT;
import engine.ApiBase;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;

import static com.shaft.api.RestActions.sendGraphQlRequest;

public class AuthenticationApi {

    public AuthenticationApi(SHAFT.API restActions) {
    }

    @Step("SignIn with Email: {email} and Password: {password}")
    public String signInViaEmail(String email, String password) {
        JSONObject loginEmailVariables = new JSONObject();
        loginEmailVariables.put("email", email);
        loginEmailVariables.put("password", password);
        String response = sendGraphQlRequest(ApiBase.BASE_URL, AuthenticationSchema.getInstance().MUTATION_SIGN_IN, loginEmailVariables.toString())
                .getCookie("connect.sid");
        return "connect.sid=" + response;
    }

    @Step("SignIn with Username: {companyName}, {username} and Password: {password}")
    public String signInViaUserName(String companyName, String username, String password) {
        JSONObject variables = new JSONObject();
        variables.put("companyLoginName", companyName);
        variables.put("username", username);
        variables.put("password", password);
        String response = sendGraphQlRequest(ApiBase.BASE_URL, AuthenticationSchema.getInstance().MUTATION_LOGIN_WITH_COMPANY, variables.toString())
                .getCookie("connect.sid");
        return "connect.sid=" + response;
    }
}