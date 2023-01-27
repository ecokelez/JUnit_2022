package automation_exercise;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase_BeforeAfter;

import java.io.File;
import java.io.IOException;

public class C12_AddProductInCart extends TestBase_BeforeAfter {
        /*
         Test Case 12: Add Products in Cart
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click 'Products' button
        5. Hover over first product and click 'Add to cart'
        6. Click 'Continue Shopping' button
        7. Hover over second product and click 'Add to cart'
        8. Click 'View Cart' button
        9. Verify both products are added to Cart
        10. Verify their prices, quantity and total price
        */

    @Test
    public void test01() throws IOException {
        //        1. Launch browser
        //        2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");
        //        3. Verify that home page is visible successfully
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com"));
        //        4. Click 'Products' button
        driver.findElement(By.xpath(" //*[text()=' Products']")).click();
        //        5. Hover over first product and click 'Add to cart'
        WebElement firstProductWE =  driver.findElement(By.xpath("//*[@class='btn btn-default add-to-cart'][1]"));
        actions.moveToElement(firstProductWE).perform();
        //JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("argument[0].scrollIntoView(true)",firstProductWE);
        //        6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();
        //        7. Hover over second product and click 'Add to cart'
        WebElement secondProduct = driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart'][1]"));
        secondProduct.click();
        //actions.scrollToElement(secondProduct).click();
        //        8. Click 'View Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        //        9. Verify both products are added to Cart
        WebElement shoppingCartWE = driver.findElement(By.xpath("//*[text()='Shopping Cart']"));
        TakesScreenshot ts = (TakesScreenshot) driver;
        File allPagePhoto = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile((File) shoppingCartWE,new File("target/ekranGoruntusuWE"+tarih+" .jpeg"));
        //        10. Verify their prices, quantity and total price
        WebElement expectedFirstProPrice = driver.findElement(By.xpath("//*[text()='Rs. 500'][1]"));
        String actualFirstPrice = expectedFirstProPrice.getText();
        Assert.assertEquals(expectedFirstProPrice,actualFirstPrice);


    }
}
