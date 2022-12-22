package day09_testBaseClass_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeAfter;

public class C04_KeyboardActions extends TestBase_BeforeAfter {
    /*
    1-Bir Class olusturalim KeyboardActions1
    2-https://www.amazon.com sayfasinagidelim
    3-Arama kutusuna  click yapıp actions method’larine kullanarak Nuetalla yazdirin
    ve Enter’a basarak arama yaptirin
    4-aramanin gerceklestigini testedin
     */

    @Test
    public void test01(){
        //    2-https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        //    3-Arama kutusuna  click yapıp actions method’larine kullanarak harf harf Nutella yazdirin
        //    ve Enter’a basarak arama yaptirin
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(searchBox).
                    keyDown(Keys.SHIFT).
                    sendKeys("n").
                keyUp(Keys.SHIFT).
                sendKeys("u").
                sendKeys("t").
                sendKeys("e").
                sendKeys("l").
                sendKeys("l").
                sendKeys("a").
                sendKeys(Keys.ENTER).perform();

        //    4-aramanin gerceklestigini testedin
        WebElement aramaSonucWE =
                driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        Assert.assertTrue(aramaSonucWE.isDisplayed());
    }
}
