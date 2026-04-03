package com.dentolize.authentication.api;

public class AuthenticationSchema {
    private static AuthenticationSchema authInstance;

    private AuthenticationSchema() {
        // Private constructor to prevent instantiation
    }

    public static synchronized AuthenticationSchema getInstance() {
        if (authInstance == null) {
            authInstance = new AuthenticationSchema();
        }
        return authInstance;
    }

    public final String createUser_operationName = "CREATE_USER";

    public final String MUTATION_CREATE_USER = """
            mutation CREATE_USER($name: String!, $email: String!, $password: String!, $companyName: String!, $clinicPhones: [String!]!, $clinicAddress: String!, $country: String!, $currency: String!, $code: String!, $timeZone: String, $language: String!, $referralCode: String!, $pushNotification: String) {
              register(
                name: $name
                email: $email
                password: $password
                companyName: $companyName
                clinicPhones: $clinicPhones
                clinicAddress: $clinicAddress
                country: $country
                currency: $currency
                code: $code
                timeZone: $timeZone
                language: $language
                referralCode: $referralCode
                pushNotification: $pushNotification
              )
            }""";

    public final String signIn_operationName = "SIGN_IN";

    public final String MUTATION_SIGN_IN = """
             mutation SIGN_IN($email: String!, $password: String!, $code: String, $backup: Boolean, $pushNotification: String) {
              login(
                email: $email
                password: $password
                code: $code
                backup: $backup
                pushNotification: $pushNotification
              )
            }""";

    public final String loginWithCompany_operationName = "LOGIN_WITH_COMPANY";

    public final String MUTATION_LOGIN_WITH_COMPANY = """
            mutation LOGIN_WITH_COMPANY($username: String!, $password: String!, $companyLoginName: String!, $code: String, $pushNotification: String, $backup: Boolean) {
              loginWithCompany(
                username: $username
                password: $password
                companyLoginName: $companyLoginName
                code: $code
                backup: $backup
                pushNotification: $pushNotification
              )
            }""";

    public final String forgotPassword_operationName = "FORGOT_PASSWORD";

    public final String MUTATION_FORGOT_PASSWORD = """
            mutation FORGOT_PASSWORD($email: String!) {
              forgotPassword(email: $email)
            }""";
}