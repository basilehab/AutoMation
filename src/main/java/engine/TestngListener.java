package engine;

import org.testng.*;


import java.util.Arrays;


public class TestngListener implements IAlterSuiteListener, IAnnotationTransformer, IExecutionListener, ISuiteListener, IInvokedMethodListener, ITestListener {

    private static final String RUN_BY = "Ismail ElShafeiy \uD83D\uDC4B😉";
    private long durationInSeconds;

    @Override
    public void onExecutionStart() {
        System.gc();
        CustomReporter.getInstance().logImportantMessage("Start Execution by " + RUN_BY, "34");
        CustomReporter.getInstance()
                .logConsole("Total memory is : [ " + Runtime.getRuntime().totalMemory() + " ]")
                .logConsole("Max memory is : [ " + Runtime.getRuntime().maxMemory() + " ]")
                .logConsole("Free memory is : [ " + Runtime.getRuntime().freeMemory() + " ]")
                .logConsole("Available Processors is : [ " + Runtime.getRuntime().availableProcessors() + " ]");
    }

    @Override
    public void onExecutionFinish() {
        CustomReporter.getInstance().logImportantMessage("Finished execution by " + RUN_BY, "34");
        CustomReporter.getInstance()
                .logConsole("Total memory is : [ " + Runtime.getRuntime().totalMemory() + " ] Before system.gc")
                .logConsole("Max memory is : [ " + Runtime.getRuntime().maxMemory() + " ] Before system.gc")
                .logConsole("Free memory is : [ " + Runtime.getRuntime().freeMemory() + " ] Before system.gc")
                .logConsole("Available Processors is : [ " + Runtime.getRuntime().availableProcessors() + " ] Before system.gc");
        CustomReporter.getInstance().logConsole("Starting garbage collection");
        System.gc();
        CustomReporter.getInstance()
                .logConsole("Current total memory is : [ " + Runtime.getRuntime().totalMemory() + " ]")
                .logConsole("Current max memory is : [ " + Runtime.getRuntime().maxMemory() + " ]")
                .logConsole("Current free memory is : [ " + Runtime.getRuntime().freeMemory() + " ]")
                .logConsole("Current available Processors is : [ " + Runtime.getRuntime().availableProcessors() + " ]");
    }

    @Override
    public void onStart(ISuite suite) {
    }

    @Override
    public void onFinish(ISuite suite) {
    }


    @Override
    public void onStart(ITestContext context) {
        CustomReporter.getInstance().logImportantMessage("Start test context: [ " + context.getName() + " ], Date : [ " + context.getStartDate() + " ]  ", "32");
    }


    @Override
    public void onFinish(ITestContext context) {
        CustomReporter.getInstance().logImportantMessage("Finish test context: [ " + context.getName() + " ], Date : [ " + context.getEndDate() + " ]", "32");
        long duration = context.getEndDate().getTime() - context.getStartDate().getTime();
        long durationInHours = duration / 1000 / 60 / 60;
        long durationInMinutes = duration / 1000 / 60;
        durationInSeconds = duration / 1000;
        System.out.println("duration =[ " + duration + " ], durationInHours = [ " + durationInHours + " ], durationInMinutes = [ " + durationInMinutes + " ], durationInSeconds = [ " + durationInSeconds + " ]");
        if (duration > 1000 * 60 * 60) {
            CustomReporter.getInstance().logImportantMessage("Execution Time: [ " + durationInHours + " ] hours", "32");
        } else if (duration > 1000 * 60) {
            CustomReporter.getInstance().logImportantMessage("Execution Time: [ " + durationInMinutes + " ] minutes", "32");
        } else {
            CustomReporter.getInstance().logImportantMessage("Execution Time: [ " + durationInSeconds + " ] seconds", "32");
        }
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (!method.isConfigurationMethod()) {
            CustomReporter.getInstance().logImportantMessage("Starting Execute Test Case :" + testResult.getName(), "34");
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (!method.isConfigurationMethod()) {
            CustomReporter.getInstance().logImportantMessage("Finished Execute Test Case :" + Arrays.toString(testResult.getParameters()), "34");
            CustomReporter.getInstance().logImportantMessage("Finished Execute Test Case :" + testResult.getName(), "34");
        }
    }
}
