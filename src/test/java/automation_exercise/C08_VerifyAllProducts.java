package automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeAfter;
import utilities.TestBase_BeforeClassAfterClass;

public class C08_VerifyAllProducts extends TestBase_BeforeAfter {
       /*
             Test Case 8: Verify All Products and product detail page
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Products' button
        5. Verify user is navigated to ALL PRODUCTS page successfully
        6. The products list is visible
        7. Click on 'View Product' of first product
        8. User is landed to product detail page
        9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
       */

    @Test
    public void test01() {
        //        1. Launch browser
        //        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //        3. Verify that home page is visible successfully
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/"));
        //        4. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        //        5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Brands']")).isDisplayed());
        //        6. The products list is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='title text-center']")).isDisplayed());
        //        7. Click on 'View Product' of first product
        driver.findElement(By.xpath("//*[text()='View Product'][1]")).click();
        //        8. User is landed to product detail page
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/product_details/1"));
        //        9. Verify that detail is visible: product name, category, price, availability, condition, brand
        WebElement proInfoLogoWE = driver.findElement(By.xpath("//*[@class='product-information']"));
        Assert.assertTrue(proInfoLogoWE.isDisplayed());

    }
}
