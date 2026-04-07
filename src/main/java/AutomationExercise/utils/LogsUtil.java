package AutomationExercise.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsUtil {

    public static final String Logs_Path = "test-outputs/Logs";

    private LogsUtil(){
        super();
    }

    //public static Logger logger = LogManager.getLogger(LogsUtil.class);
    public static Logger logger (){
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName()); //to get the class name for each log
    }

    //LogUtils.info("this is a test log message", "This is another test log message"); el 3 dots beside String means eny 2a2dr ab3at more
    //than one message-- another exp: LogUtils.info("username is: ", data.username); it is like array of string
    public static void trace(String... message){
        logger().trace(String.join(" ", message));
    }
    public static void debug(String... message){
        logger().debug(String.join(" ", message));
    }
    public static void info(String... message){
        logger().info(String.join(" ", message));
    }
    public static void warn(String... message){
        logger().warn(String.join(" ", message));
    }
    public static void error(String... message){
        logger().error(String.join(" ", message));
    }
    public static void fatal(String... message){
        logger().fatal(String.join(" ", message));
    }

}
