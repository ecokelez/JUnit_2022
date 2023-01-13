package automation_exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeAfter;

public class C03_LoginUser_IncorrectEmailPass  extends TestBase_BeforeAfter {
        /*
        Test Case 3: Login User with incorrect email and password
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible
        6. Enter incorrect email address and password
        7. Click 'login' button
        8. Verify error 'Your email or password is incorrect!' is visible
      */

    @Test
    public void test01() {
        Faker faker = new Faker();
        Actions actions = new Actions(driver);

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        Assert.assertTrue( driver.getCurrentUrl().contains("automationexercise.com"));
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        // 5. Verify 'Login to your account' is visible
       Assert.assertTrue(driver.findElement(By.xpath("//h2")).isDisplayed());
        // 6. Enter incorrect email address and password
        // 7. Click 'login' button
        WebElement emailBox = driver.findElement(By.xpath(" //*[@type='email']"));
        actions.click(emailBox).sendKeys(faker.internet().emailAddress()).
                                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
                                sendKeys(Keys.ENTER).perform();
        // 8. Verify error 'Your email or password is incorrect!' is visible .
        Assert.assertTrue(driver.findElement(By.xpath("//*[@style='color: red;']")).isDisplayed());


    }
}
