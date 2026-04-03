package tests.authentication;

import com.dentolize.authentication.api.AuthenticationApi;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic( "Login Module" )
@Feature( "API" )
@Test( groups = {"apis"} )
public class Api_Authentication_Tests {
    private SHAFT.API restActions;
    private AuthenticationApi authenticationApi;


    @Story( "As a User, I want to \"Login\" by Email" )
    @Test( groups = "apis", description = "Verify the User can Login via email" )
    @Severity( SeverityLevel.CRITICAL )
    @TmsLink( "Test Cases" )
    public void testLogin() {
        authenticationApi.signInViaEmail(loginEmail, loginPassword);
    }

    //*****************************************************//
    //********************// Set Up //*********************//
    //*****************************************************//
    String loginEmail, loginPassword;

    @BeforeClass
    public void loadTestData() {
        authenticationApi = new AuthenticationApi(restActions);
        JSONFileManager users_TD = new JSONFileManager(System.getProperty("usersApisJson"));
        loginEmail = users_TD.getTestData("owner.email");
        loginPassword = users_TD.getTestData("owner.password");
    }

}
