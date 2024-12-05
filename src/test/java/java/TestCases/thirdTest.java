package java.TestCases;

import Base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class thirdTest extends TestBase {
    @BeforeMethod
    public void beforeMethod(){
        openBrowser("https://www.google.com");
    }

    @Test
    public void TestOne(){
        System.out.println("Test method One");
    }

    @Test
    public void TestTwo(){
    }
}
