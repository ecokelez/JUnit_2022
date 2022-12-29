package automation_exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_BeforeAfter;

import static junit.framework.TestCase.assertTrue;

public class Register_User extends TestBase_BeforeAfter {

        /*
       Test Case 1: Register User
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and email address
    7. Click 'Signup' button
    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    9. Fill details: Title, Name, Email, Password, Date of birth
    10. Select checkbox 'Sign up for our newsletter!'
    11. Select checkbox 'Receive special offers from our partners!'
    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    13. Click 'Create Account button'
    14. Verify that 'ACCOUNT CREATED!' is visible
    15. Click 'Continue' button
    16. Verify that 'Logged in as username' is visible
    17. Click 'Delete Account' button
    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
           */


    @Test
    public void registerUser() {
        Faker faker = new Faker();
        Actions actions = new Actions(driver);

        //  1. Launch browser
        //    2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //    3. Verify that home page is visible successfully
        Assert.assertTrue( driver.getCurrentUrl().contains("automationexercise.com"));

        //    4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //    5. Verify 'New User Signup!' is visible
        //1. yol
        WebElement newUserWE = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newUserWE.isDisplayed());
        //2. yol
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());

        //    6. Enter name and email address
        //    7. Click 'Signup' button
        WebElement nameWE = driver.findElement(By.xpath("//*[@type='text']"));

        //WebElement emailWE =  driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
       actions.click(nameWE).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
               sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed());

        //    9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement radioButton = driver.findElement(By.xpath("//*[@class='radio-inline'][1]"));
        actions.click(radioButton).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).sendKeys(Keys.TAB).
                sendKeys("17").sendKeys(Keys.TAB).
                sendKeys("December").sendKeys(Keys.TAB).
                sendKeys("2013").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //    10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@id='newsletter']")).click();

        //    11. Select checkbox 'Receive special offers from our partners!.'
        //    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //    13. Click 'Create Account button'
       WebElement checkboxWE=  driver.findElement(By.xpath("//*[@id='optin']"));
        actions.click(checkboxWE).sendKeys(Keys.TAB).
                sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
               sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
               sendKeys(faker.company().name()).sendKeys(Keys.TAB).
               sendKeys(faker.address().streetName()).sendKeys(Keys.TAB).
               sendKeys(faker.address().secondaryAddress()).sendKeys(Keys.TAB).
               sendKeys("Canada").sendKeys(Keys.TAB).
               sendKeys(faker.nation().nationality()).sendKeys(Keys.TAB).
               sendKeys(faker.address().cityName()).sendKeys(Keys.TAB).
               sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB).
               sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //    14. Verify that 'ACCOUNT CREATED!' is visible
       Assert.assertTrue( driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed());

        //    15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        //    16. Verify that 'Logged in as username' is visible
        assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());

        //    17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

        //    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        assertTrue(driver.findElement(By.xpath("//*[@class='title text-center']")).isDisplayed());
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

    }
}
