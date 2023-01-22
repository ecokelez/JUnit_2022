package automation_exercise;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase_BeforeAfter;

import java.io.File;
import java.io.IOException;

public class C10_VerifySubscription extends TestBase_BeforeAfter {
        /*
        Test Case 10: Verify Subscription in home page
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Scroll down to footer
        5. Verify text 'SUBSCRIPTION'
        6. Enter email address in input and click arrow button
        7. Verify success message 'You have been successfully subscribed!' is visible
        */

    @Test
    public void test01() throws IOException {
        //        1. Launch browser
        //        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //        3. Verify that home page is visible successfully
        WebElement autologoWE = driver.findElement(By.xpath("//*[@class='logo pull-left']"));
        Assert.assertTrue(autologoWE.isDisplayed());
        //        4. Scroll down to footer
        actions.sendKeys(Keys.PAGE_DOWN).scrollToElement(driver.findElement(By.xpath("//*[text()='Subscription']"))).perform();
        //        5. Verify text 'SUBSCRIPTION'
        WebElement subscriptionWE = driver.findElement(By.xpath("//*[text()='Subscription']"));
        Assert.assertTrue(subscriptionWE.isDisplayed());
        //        6. Enter email address in input and click arrow button
        WebElement emailBox = driver.findElement(By.xpath("//*[@id='susbscribe_email']"));
        emailBox.sendKeys("ec067@gmail.com");
        WebElement messageClickButton = driver.findElement(By.xpath("//*[@id='subscribe']"));
        messageClickButton.click();
        //        7. Verify success message 'You have been successfully subscribed!' is visible
        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSyfResim = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSyfResim,new File("target/ekranGoruntusuWE"+tarih+".jpeg"));
        Assert.assertTrue(messageClickButton.isDisplayed());



    }
}
