package day09_testBaseClass_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C03_Actions extends TestBase_BeforeAfter {
    //1Yeni bir class olusturalim:MouseActions1
    //2https://the-internet.herokuapp.com/context_menu sitesine gidelim 3-Cizili alan uzerinde sag clickyapalim
    //4Alert’te cikan yazinin “You selected a context menu”oldugunu
    //testedelim.
    //5Tamam diyerek alert’ikapatalim
    //6Elemental Selenium linkinetiklayalim
    //7Acilan sayfada h1 taginda “Elemental Selenium” yazdigini testedelim

    @Test
    public void test01(){
        //2-https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3-Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement cizgiliAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlan).perform();
        //4-Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedYazi = "You selected a context menu";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        //5-Tamam diyerek alert’ikapatalim
        driver.switchTo().alert().accept();
        //6-Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium'][1]")).click();
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        //7-Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        WebElement  linkWE = driver.findElement(By.xpath("//*[text()='Elemental Selenium'][1]"));
        Assert.assertTrue(linkWE.isDisplayed());

        /*String istenenYazi = "Elemental Selenium";
         actualYazi = linkWE.getText();
         Assert.assertTrue(actualYazi.contains(istenenYazi));
         */



    }
}
