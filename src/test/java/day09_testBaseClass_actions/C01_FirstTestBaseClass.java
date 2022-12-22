package day09_testBaseClass_actions;

import org.junit.Test;
import utilities.TestBase_BeforeAfter;

public class C01_FirstTestBaseClass extends TestBase_BeforeAfter {

    @Test
    public void test01(){
        driver.get("https://amazon.com");
    }
}
