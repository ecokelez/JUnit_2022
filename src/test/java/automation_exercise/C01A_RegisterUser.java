package automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_BeforeAfter;

public class C01A_RegisterUser extends TestBase_BeforeAfter {
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
    public void registerUserTest01() {
        //    1. Launch browser
        //    2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //    3. Verify that home page is visible successfully
        Assert.assertTrue
                ("home page is visible successfully",driver.getCurrentUrl().contains("automationexercise.com"));
        //    4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //    5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());
        WebElement newUserSignup = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        //    6. Enter name and email address
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Ali Can");
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("e067@gmail.com");
        //    7. Click 'Signup' button
        WebElement signUpButton = driver.findElement(By.xpath("//*[@data-qa='signup-button']"));
        signUpButton.click();
        //    8. Verify that 'ENTER ACCOUNT INFORMATI"ON' is visible
        WebElement enterAI = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue( enterAI.isDisplayed());
        //    9. Fill details: Title, Name, Email, Password, Date of birth
         driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
         driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Ali Can");
         driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("wx@gmail.com");
         driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
         WebElement dayButton = driver.findElement(By.xpath("//*[@id='days']"));
         Select select = new Select(dayButton);
         select.selectByVisibleText("5");
         WebElement monthsButton = driver.findElement(By.xpath("//*[@id='months']"));
         select = new Select(monthsButton);
         select.selectByIndex(8);
         WebElement yearsButton = driver.findElement(By.xpath("//*[@id='years']"));
         select = new Select(yearsButton);
         select.selectByVisibleText("1994");

        //    10. Select checkbox 'Sign up for our newsletter!'
        WebElement checkBox01 = driver.findElement(By.xpath("//*[@id='newsletter']"));
        checkBox01.click();
        //    11. Select checkbox 'Receive special offers from our partners!'
        WebElement checkBox02 = driver.findElement(By.xpath("//*[@id='optin']"));
        checkBox02.click();
        //    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

       WebElement firstNameWE = driver.findElement(By.xpath("//*[@id='first_name']"));

        Actions actions = new Actions(driver);

        //WebElement country = driver.findElement(By.xpath("//*[@id='country']"));
        //select = new Select(country);
        firstNameWE.sendKeys("Ali");
        actions.sendKeys(Keys.TAB).sendKeys("CAN")
                .sendKeys(Keys.TAB).sendKeys("COKELEZLER A.S.")
                .sendKeys(Keys.TAB).sendKeys("Ankara")
                .sendKeys(Keys.TAB).sendKeys("Mahmutoglu Koyu-Devrek")
                .sendKeys(Keys.TAB).sendKeys("Canada")
                .sendKeys(Keys.TAB).sendKeys("TURKEY")
                .sendKeys(Keys.TAB).sendKeys("Zonguldak")
                .sendKeys(Keys.TAB).sendKeys("67000")
                .sendKeys(Keys.TAB).sendKeys("12345")
                .sendKeys(Keys.ENTER).perform();
        //    13. Click 'Create Account button'
        //    14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreated = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());
        //    15. Click 'Continue' button
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        //    16. Verify that 'Logged in as username' is visible
        WebElement loggedUsName = driver.findElement(By.xpath("//*[text()='Ali Can']"));
        Assert.assertTrue(loggedUsName.isDisplayed());
        //    17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        //    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        driver.findElement(By.xpath("//*[text()='Delete']")).click();

    }
}
