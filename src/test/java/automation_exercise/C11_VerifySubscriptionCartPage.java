package automation_exercise;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase_BeforeAfter;

import java.io.File;
import java.io.IOException;

public class C11_VerifySubscriptionCartPage extends TestBase_BeforeAfter {
        /*
        Test Case 11: Verify Subscription in Cart page
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click 'Cart' button
        5. Scroll down to footer
        6. Verify text 'SUBSCRIPTION'
        7. Enter email address in input and click arrow button
        8. Verify success message 'You have been successfully subscribed!' is visible
         */

    @Test
    public void test01() throws IOException {
        //        1. Launch browser
        //        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //        3. Verify that home page is visible successfully
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com"));
        //        4. Click 'Cart' button
        WebElement cartButton = driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart'][1]"));
        cartButton.click();
        //        5. Scroll down to footer
        WebElement subscriptionWE = driver.findElement(By.xpath("//*[text()='Subscription']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",subscriptionWE);
        //        6. Verify text 'SUBSCRIPTION'
        TakesScreenshot ts = (TakesScreenshot) driver;
        File allPage = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(allPage,new File("target/ekranGoruntusuWE"+tarih+".jpeg"));
        Assert.assertTrue(subscriptionWE.isDisplayed());
        //        7. Enter email address in input and click arrow button
        WebElement emailBox = driver.findElement(By.xpath("//*[@id='susbscribe_email']"));
        emailBox.sendKeys("ec06@gmail.com");
        WebElement arrowMessageButton = driver.findElement(By.xpath("//*[@id='subscribe']"));
        arrowMessageButton.click();
        //        8. Verify success message 'You have been successfully subscribed!' is visible
        File allMessagePage = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(allMessagePage,new File("target/ekranGoruntusuWE"+tarih+".jpeg"));
        Assert.assertTrue(arrowMessageButton.isDisplayed());
    }
}
