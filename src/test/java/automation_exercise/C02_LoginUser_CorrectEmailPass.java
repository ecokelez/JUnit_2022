package automation_exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeAfter;

public class C02_LoginUser_CorrectEmailPass extends TestBase_BeforeAfter {
    /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible
        6. Enter correct email address and password
        7. Click 'login' button
        8. Verify that 'Logged in as username' is visible
        9. Click 'Delete Account' button
        10. Verify that 'ACCOUNT DELETED!' is visible
     */

    @Test
    public void test01() {
        Faker faker = new Faker();
        Actions actions = new Actions(driver);

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
       WebElement logoWE = driver.findElement(By.xpath("//*[@class='logo pull-left']"));
        Assert.assertTrue("Automation Exercise logosu guruntulendi ve sayfa basarılı bir sekilde giris yapidi", logoWE.isDisplayed());
        // 4. Click on 'Signup / Login' button
        WebElement loginButton = driver.findElement(By.xpath("//*[@class='fa fa-lock']"));
        loginButton.click();
        // 5. Verify 'Login to your account' is visible
        WebElement loginAccountWE =  driver.findElement(By.xpath("//*[@class='login-form']"));
         Assert.assertTrue( loginAccountWE.isDisplayed());
         //==> 2. yol;
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='login-form']")).isDisplayed());
        // 6. Enter correct email address and password
        // 7. Click 'login' button
        WebElement emailBox = driver.findElement(By.xpath("//*[@type='email'][1]"));
        actions.click(emailBox).sendKeys("e067@gmail.com").
                sendKeys(Keys.TAB).sendKeys("1234").sendKeys(Keys.ENTER).perform();
        // 8. Verify that 'Logged in as username' is visible
        WebElement logUserName = driver.findElement(By.xpath("//*[text()=' Logged in as '] "));
        Assert.assertTrue(logUserName.isDisplayed());
        // 9. Click 'Delete Account' button
       Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Delete Account'] ")).isDisplayed());
        // 10. Verify that 'ACCOUNT DELETED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("Account Deleted!")).isDisplayed());

    }
}
