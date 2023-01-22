package automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeAfter;

public class C09_SearchProduct extends TestBase_BeforeAfter {
      /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Products' button
        5. Verify user is navigated to ALL PRODUCTS page successfully
        6. Enter product name in search input and click search button
        7. Verify 'SEARCHED PRODUCTS' is visible
        8. Verify all the products related to search are visible
       */

    @Test
    public void test01() {

        //        1. Launch browser
        //        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //        3. Verify that home page is visible successfully
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com"));
        //        4. Click on 'Products' button
        driver.findElement(By.xpath(" //*[text()=' Products']")).click();
        //        5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductWE = driver.findElement(By.xpath(" //*[@class='title text-center']"));
        Assert.assertTrue(allProductWE.isDisplayed());
        //        6. Enter product name in search input and click search button
        WebElement seacrhBoxWE = driver.findElement(By.xpath("//*[@id='search_product']"));
        actions.click(seacrhBoxWE).sendKeys("JEANS").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //        7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='title text-center']")).isDisplayed());
        //        8. Verify all the products related to search are visible
       Assert.assertTrue(driver.findElement(By.xpath("//*[@class='col-sm-9 padding-right']")).isDisplayed());
    }
}
