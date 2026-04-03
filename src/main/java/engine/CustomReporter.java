package engine;

import com.shaft.tools.io.ReportManager;
import com.shaft.tools.io.internal.ReportManagerHelper;
import engine.dataDriven.PropertiesReader;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.testng.Reporter;

import java.util.Arrays;


public class CustomReporter {
    private Logger logger;
    private static CustomReporter customReporterInstance;

    private CustomReporter() {
    }

    public static CustomReporter getInstance() {
        if (customReporterInstance == null) {
            customReporterInstance = new CustomReporter();
        }
        return customReporterInstance;
    }


    public void print(String data) {
        System.out.println(data);
    }

//    public void testCaseInfo(LinkedHashMap<String, String> data) {
//        String testCaseID = getData(data, TestCase.TC_ID);
//        String epicName = getData(data, TestCase.EPIC_NAME);
//        String testCaseNameALM = getData(data, TestCase.TC_TITLE_ALM);
//        String testDescription = "Tc ID: " + testCaseID + " : [ " + testCaseNameALM + " ]";
//        ExtentReport.getInstance().createTest(getData(data, TestCase.RUN_ID) + " " + testCaseID + " - " + testCaseNameALM + ", using email [" + getData(data, TestCase.CURRENT_LOGIN_EMAIL) + "]", getData(data, TestCase.EPICS_OWNER), epicName, getData(data, TestCase.FLOW_TYPE));
//        ExtentReport.getInstance().info("Login via email: [ " + getData(data, TestCase.CURRENT_LOGIN_EMAIL) + " ] On [ " + FrameworkConstants.ENVIRONMENT + " ]");
//        Allure.epic(epicName);
//        if (epicName.equalsIgnoreCase(FrameworkConstants.FSD_SHEET_NAME)) {
//            Allure.story(getData(data, AmeliaConfig.SERVICE_CI) + " - FSD");
//        }
//        Allure.description(testDescription);
//        Allure.parameter("Description", testDescription);
//        Allure.parameter("Priority", "P " + getData(data, TestCase.PRIORITY));
//        Allure.parameter("Market", getData(data, TestCase.MARKET));
//        Allure.parameter("Integration", getData(data, TestCase.INTEGRATION));
//        Allure.parameter("Last status run", getData(data, TestCase.STATUS));
//        Allure.parameter("Qualifications", "Key Phrase: [ " + getData(data, AmeliaConfig.KEY_PHRASE) + " ], " +
//                "Action Type: [ " + getData(data, AmeliaConfig.ACTION_TYPE) + " ]," +
//                " Application Name: [ " + getData(data, AmeliaConfig.SERVICE_CI) + " ]");
//        logInfoStep(" Run Epic: [ " + epicName + " ], Domain: [ " + getData(data, TestCase.DOMAIN) + " ]");
//    }


    public void logImportantMessageAndStep(String text) {
        logImportantMessage(text, "32");
        Allure.step(text);
    }

    public CustomReporter logInfoStep(String text) {
        ReportManager.log(text);
        return this;
    }


    public CustomReporter logInfo(String text) {
        ReportManagerHelper.createLogEntry(text, Level.INFO);
        return this;
    }

    public void logPassed(String text) {
        ReportManager.log(text);
    }

    public void logError(String text) {
        logConsole("Kindly check the error message below: ", Level.ERROR, "31");
        try {
            ReportManager.log(text, Level.ERROR);
        } catch (Exception e) {
            logConsole("Error occurred while logging the error message: ");
        }
    }

    public void logErrorFailed(String exceptionMessage) {
        ReportManager.log(exceptionMessage, Level.ERROR);
    }


    public void logWarning(String text) {
        logConsole("Kindly check the warning message below: ", Level.WARN, "33");
        ReportManager.log(text, Level.WARN);
    }

    public CustomReporter logConsole(String text) {
        String log = "\033[37m" + text.trim();
        createLogger(log, Level.INFO);
        return this;
    }

    public CustomReporter logConsole(String text, Level level) {
        String log = "\033[37m" + text.trim() + "\033[0m";
        createLogger(log, level);
        return this;
    }

    /**
     * This method is used to log in console with custom level and color
     *
     * @param text  to be logged in console
     * @param level of the log
     * @param color Red: 31, Green: 32, Yellow: 33, Blue: 34, Magenta: 35, Cyan: 36, White: 37.
     */
    public void logConsole(String text, Level level, String color) {
        String log = "\033[" + color + "m" + text.trim();
        createLogger(log, level);
    }

    public void logImportantMessage(String text) {
        String log = System.lineSeparator() +
                "\033[0;7m" +
                createSeparator('-') +
                addSpacing(text.trim()) +
                createSeparator('-') +
                System.lineSeparator() +
                "\033[0m";
        createLogger(log, Level.INFO);
    }

    /**
     * This method is used to log important message  in console with custom color
     *
     * @param text  to be logged in console
     * @param color Red: 31, Green: 32, Yellow: 33, Blue: 34, Magenta: 35, Cyan: 36, White: 37.
     */
    public void logImportantMessage(String text, String color) {
        String log = System.lineSeparator() +
                "\033[" + color + "m" +
                createSeparator('-') +
                addSpacing(text.trim()) +
                createSeparator('-') +
                System.lineSeparator() +
                "\033[0m";
        createLogger(log, Level.INFO);
    }


    private String createSeparator(@SuppressWarnings("SameParameterValue") char ch) {
        return String.valueOf(ch).repeat(144);
    }

    private String addSpacing(String log) {
        StringBuilder augmentedText = new StringBuilder();
        StringBuilder lineByLine = new StringBuilder();

        augmentedText.append(System.lineSeparator());
        Arrays.stream(log.split("\n")).toList().forEach(line -> {
            var trailingSpacing = "";
            var spaces = Math.round((float) (144 - line.trim().length()) / 2);
            if (spaces > 0) {
                lineByLine.append(" ".repeat(spaces));
                trailingSpacing = lineByLine.toString();
            }
            lineByLine.append(line.trim());
            lineByLine.append(trailingSpacing);
            augmentedText.append(lineByLine);
            augmentedText.append(System.lineSeparator());
            lineByLine.delete(0, lineByLine.length());
        });
        return augmentedText.toString();
    }

    private void createLogger(String log, Level level) {
        Reporter.log(log, false);
        if (logger == null) {
            initializeLogger();
        }
        logger.log(level, log);
    }

    private void initializeLogger() {
        Configurator.initialize(null, PropertiesReader.getProperty("src/main/resources/properties", "log4j2.properties"));
        logger = LogManager.getLogger(CustomReporter.class.getName());
    }

}


