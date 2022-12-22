package day09_testBaseClass_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeAfter;

public class C02_Actions extends TestBase_BeforeAfter {
    /*
    Yeni bir class olusturalim:MouseActions3
    1-https://www.amazon.com/adresine gidelim
    2-Sag ust bolumde bulunan “Account & Lists” menu. acilmasi icin  mouse’u bu menunun ustune getirelim
    3-“Create a list” butonunabasalim
    4-Acilan sayfada “Your Lists” yazisi oldugunu testedelim
     */

   @Test
   public void test01(){
       //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

       //Account menüsunden create a list linkine tıklayalım
       Actions actions = new Actions(driver);

       WebElement accountLink = driver.findElement(By.xpath("//*[@class='nav-line-2 '][1]"));
       actions.moveToElement(accountLink).perform();

      WebElement createListWE =  driver.findElement(By.xpath("//*[text()='Create a List'][1]"));
      createListWE.click();

   }
}
