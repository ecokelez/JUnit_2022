package automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeAfter;

public class C04_LogoutUser extends TestBase_BeforeAfter {
         /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible
        6. Enter correct email address and password
        7. Click 'login' button
        8. Verify that 'Logged in as username' is visible
         */

    @Test
    public void test01() {
        Actions actions = new Actions(driver);
        //        1. Launch browser
        //        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //        3. Verify that home page is visible successfully
        WebElement autoLogoWE = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(autoLogoWE.isDisplayed());
        //        4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //        5. Verify 'Login to your account' is visible
        WebElement loginAccount = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(loginAccount.isDisplayed());
        //        6. Enter correct email address and password
        //        7. Click 'login' button
        WebElement emailButton = driver.findElement(By.xpath("//*[@type='email'][1]"));
        actions.click(emailButton).sendKeys("e067@gmail.com").
                sendKeys(Keys.TAB).sendKeys("1234").sendKeys(Keys.ENTER).perform();
        //        8. Verify that 'Logged in as username' is visible
    }
}
