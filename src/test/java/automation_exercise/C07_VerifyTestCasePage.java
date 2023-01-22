package automation_exercise;


import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeAfter;
import utilities.TestBase_BeforeClassAfterClass;

import static junit.framework.TestCase.assertTrue;

public class C07_VerifyTestCasePage extends TestBase_BeforeAfter {
        /*
         Test Case 7: Verify Test Cases Page
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Test Cases' button
        5. Verify user is navigated to test cases page successfully
         */

    @Test
    public void test01() {
        //        1. Launch browser
        //        2. Navigate to url 'http://automationexercise.com'
       driver.get("http://automationexercise.com");
        //        3. Verify that home page is visible successfully
WebElement logoWE = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(logoWE.isDisplayed());
        //        4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//*[text()=' Test Cases']")).click();
        //        5. Verify user is navigated to test cases page successfully
        Assert.assertTrue( driver.findElement(By.xpath("//*[@style='color: red;']")).isDisplayed());
    }
}
