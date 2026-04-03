package engine.actions;

import com.shaft.api.RestActions;
import com.shaft.tools.io.ReportManager;
import engine.ApiBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static com.shaft.api.RestActions.buildNewRequest;

public class GraphQlActions {
    public static Response sendGraphQlRequest(String base_URI, String query, String variables, String header_key, String header_value, String header_key2) {
        org.json.simple.JSONObject requestBody = new org.json.simple.JSONObject();
        requestBody.put("query", query);
        requestBody.put("variables", variables);
        return graphQlRequestHelperWithHeader(base_URI, requestBody, header_key, header_value, header_key2);
    }

    public static Response sendGraphQlRequest(String base_URI, String query, Map<String, Object> variables, String header_key, String header_value, String header_key2) {
        org.json.simple.JSONObject requestBody = new org.json.simple.JSONObject();
        requestBody.put("query", query);
        requestBody.put("variables", variables);
        return graphQlRequestHelperWithHeader(base_URI, requestBody, header_key, header_value, header_key2);
    }

    public static Response sendGraphQlRequest(String query, Map<String, Object> variables, String cookie) {
        org.json.simple.JSONObject requestBody = new org.json.simple.JSONObject();
        requestBody.put("query", query);
        requestBody.put("variables", variables);
        return graphQlRequestHelperWithHeader(ApiBase.BASE_URL, requestBody, "cookie", cookie, "uncrunch");
    }

    private static Response graphQlRequestHelperWithHeader(String base_URI_forHelperMethod,
                                                           org.json.simple.JSONObject requestBody_forHelperMethod,
                                                           String headerKey_forHelperMethod,
                                                           String headerValue_forHelperMethod,
                                                           String headerKey2_forHelperMethod) {
        ReportManager.logDiscrete("GraphQl Request is being Performed with the Following Parameters [Service URL: " + base_URI_forHelperMethod + "graphql | Request Body: " + requestBody_forHelperMethod + " | Header: \"" + headerKey_forHelperMethod + "\":\"" + headerValue_forHelperMethod + "\"\"");
        return buildNewRequest(base_URI_forHelperMethod,
                "graphql",
                RestActions.RequestType.POST)
                .setRequestBody(requestBody_forHelperMethod)
                .setContentType(ContentType.JSON)
                .addHeader(headerKey_forHelperMethod, headerValue_forHelperMethod)
                .addHeader(headerKey2_forHelperMethod, null).performRequest();
    }

}
