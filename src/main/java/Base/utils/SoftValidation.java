package Base.utils;
import org.testng.asserts.SoftAssert;

public class SoftValidation extends SoftAssert{

    public static SoftValidation softAssertion = new SoftValidation();

    public static void customAssertAll(){
        try {
            softAssertion.assertAll("Sort Assertion");
        }
        catch (Exception e){
            System.out.println("Soft Assertion Failed");
        }
    }
}
