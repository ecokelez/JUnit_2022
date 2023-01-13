package automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeAfter;

public class C05_RegisterUserExistingEmail extends TestBase_BeforeAfter {
        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'New User Signup!' is visible
        6. Enter name and already registered email address
        7. Click 'Signup' button
        8. Verify error 'Email Address already exist!' is visible
        */


    @Test
    public void test01() {
        Actions actions = new Actions(driver);
        //        1. Launch browser
        //        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //        3. Verify that home page is visible successfully
        String homeUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("home page is visible successfully",homeUrl,actualUrl);
        //        4. Click on 'Signup / Login' button
        driver.findElement(By.linkText("Signup / Login")).click();
        //        5. Verify 'New User Signup!' is visible
        WebElement newUserSign = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue("'New User Signup!' is visible", newUserSign.isDisplayed());
        //        6. Enter name and already registered email address
        //        7. Click 'Signup' button
        WebElement nameWE = driver.findElement(By.xpath("//*[@name='name']"));
        nameWE.sendKeys("Ali Can");
        actions.sendKeys(Keys.TAB).sendKeys("e067@gmail.com").perform();
        //        7. Click 'Signup' button
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //        8. Verify error 'Email Address already exist!' is visible
        WebElement emailAddress = driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
        Assert.assertTrue("Email Address already exist!",emailAddress.isDisplayed());
    }
}
