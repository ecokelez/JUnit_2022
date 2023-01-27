package automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C13_VerifyProductQuantity extends TestBase_BeforeAfter {
         /*
            Test Case 13: Verify Product quantity in Cart
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click 'View Product' for any product on home page
        5. Verify product detail is opened
        6. Increase quantity to 4
        7. Click 'Add to cart' button
        8. Click 'View Cart' button
        9. Verify that product is displayed in cart page with exact quantity
        */

    @Test
    public void test01() {
        //        1. Launch browser
        //        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //        3. Verify that home page is visible successfully
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com"));
        //        4. Click 'View Product' for any product on home page
        WebElement firstProduct = driver.findElement(By.xpath("//*[@style='color: brown;'][1]"));
        firstProduct.click();
        //        5. Verify product detail is opened
       WebElement productInfo = driver.findElement(By.xpath("//*[@class='product-information']"));
       Assert.assertTrue(productInfo.isDisplayed());
        //        6. Increase quantity to 4
       WebElement quantitySize = driver.findElement(By.xpath("//*[@value='1']"));
        //        7. Click 'Add to cart' button
        //        8. Click 'View Cart' button
        //        9. Verify that product is displayed in cart page with exact quantity
    }
}
