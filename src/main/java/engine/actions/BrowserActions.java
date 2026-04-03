package engine.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.ReportManager;
import org.openqa.selenium.Cookie;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BrowserActions {
    public static void getCookies(SHAFT.GUI.WebDriver driver) throws Exception {
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

    public static void loadCookies(SHAFT.GUI.WebDriver driver) throws IOException {
        // Load cookies from file
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Map<String, Object>> cookiesMap =
                mapper.readValue(new File("src/test/resources/testDataFiles/login/cookies.json"), Map.class);

        for (Map<String, Object> cookieData : cookiesMap.values()) {
            String name = (String) cookieData.get("name");
            String value = (String) cookieData.get("value");
            String domain = (String) cookieData.get("domain");
            String path = (String) cookieData.get("path");
            Boolean isSecure = (Boolean) cookieData.get("isSecure");

   driver.browser().addCookie("name", name)
           .addCookie("value", value)
              .addCookie("domain", domain)
                .addCookie("path", path)
                .addCookie("expiry", path)
                .addCookie("isSecure", String.valueOf(isSecure));
        }

    }
}
