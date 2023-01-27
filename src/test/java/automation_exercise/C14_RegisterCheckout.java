package automation_exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeAfter;

public class C14_RegisterCheckout extends TestBase_BeforeAfter {
            /*
         Test Case 14: Place Order: Register while Checkout
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Add products to cart
        5. Click 'Cart' button
        6. Verify that cart page is displayed
        7. Click Proceed To Checkout
        8. Click 'Register / Login' button
        9. Fill all details in Signup and create account
        10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        11. Verify ' Logged in as username' at top
        12.Click 'Cart' button
        13. Click 'Proceed To Checkout' button
        14. Verify Address Details and Review Your Order
        15. Enter description in comment text area and click 'Place Order'
        16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        17. Click 'Pay and Confirm Order' button
        18. Verify success message 'Your order has been placed successfully!'
        19. Click 'Delete Account' button
        20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        */

    @Test
    public void test01() {
        Faker faker = new Faker();
        //        1. Launch browser
        //        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //        3. Verify that home page is visible successfully
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com"));
        //        4. Add products to cart
        driver.findElement(By.xpath("//*[@class='btn btn-default add-to-cart'][1]")).click();
        //        5. Click 'Cart' button
        WebElement cartButton = driver.findElement(By.xpath("//*[@class='text-center'][2]"));
        cartButton.click();
        //        6. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Shopping Cart']")).isDisplayed());
        //        7. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();
        //        8. Click 'Register / Login' button
        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();
        //        9. Fill all details in Signup and create account
        WebElement nameBox = driver.findElement(By.xpath("//*[@name='name']"));
        actions.click(nameBox).sendKeys("Sütlaç").sendKeys(Keys.TAB).
                sendKeys("sutlac2023@gmail.com").sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
        WebElement titleButton = driver.findElement(By.xpath("//*[@id='id_gender1']"));
        actions.click(titleButton).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("2023").sendKeys(Keys.TAB).
                sendKeys("25").sendKeys(Keys.TAB).sendKeys("January").sendKeys(Keys.TAB).sendKeys("2021").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("Sütlaç").sendKeys(Keys.TAB).
                sendKeys("TATLI").sendKeys(Keys.TAB).
                sendKeys("Sütaç").sendKeys(Keys.TAB).
                sendKeys("Sütyolu Caddesi").sendKeys(Keys.TAB).
                sendKeys("Devrek").sendKeys(Keys.TAB).
                sendKeys("Canada").sendKeys(Keys.TAB).
                sendKeys("Canada").sendKeys(Keys.TAB).
                sendKeys("Toronto").sendKeys(Keys.TAB).
                sendKeys("2023").sendKeys(Keys.TAB).
                sendKeys("+1-2023-67").sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
        //        10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountButton = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountButton.isDisplayed());
        WebElement continueButton = driver.findElement(By.xpath("//*[text()='Continue']"));
        continueButton.click();
        //        11. Verify ' Logged in as username' at top
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());
        //        12.Click 'Cart' button
        driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart'][1]")).click();
        //        13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();
        //        14. Verify Address Details and Review Your Order
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Address Details']")).isDisplayed());
        //        15. Enter description in comment text area and click 'Place Order'
        WebElement textBox = driver.findElement(By.xpath("//*[@class='form-control']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",textBox);
        actions.click(textBox).sendKeys("I like it").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //        16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement cardButton = driver.findElement(By.xpath("//*[@class='form-control']"));
        actions.click(cardButton).sendKeys(faker.name().nameWithMiddle()).sendKeys(Keys.TAB).
                sendKeys(faker.business().creditCardNumber()).sendKeys(Keys.TAB).
                sendKeys("111").sendKeys(Keys.TAB).
                sendKeys(faker.business().creditCardExpiry()).sendKeys(Keys.TAB).
                sendKeys(faker.business().creditCardExpiry()).perform();
        //        17. Click 'Pay and Confirm Order' button
        WebElement payButton = driver.findElement(By.xpath("//*[@id='submit']"));
        payButton.click();
        //        18. Verify success message 'Your order has been placed successfully!'
        WebElement textMessageWE = driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(textMessageWE.isDisplayed());
        //        19. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@class='fa fa-trash-o']")).click();
        //        20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='title text-center']")).isDisplayed());
        WebElement continueWE  = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
        continueWE.click();

    }
}
