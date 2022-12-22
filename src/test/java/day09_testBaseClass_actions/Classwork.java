package day09_testBaseClass_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeAfter;

public class Classwork extends TestBase_BeforeAfter {
    /*
    Yeni bir class olusturalim:MouseActions3
    1-  https://www.facebook.com adresine gidelim
    2-  Yeni hesap olustur butonuna basalim
    3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalimm

     */

    @Test
    public void test01() throws InterruptedException {
        //    1-  https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //    2-  Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy'][1]")).click();
        //    3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isimBox = driver.findElement(By.xpath("//*[@class='inputtext _58mg _5dba _2ph-'][1]"));
        isimBox.sendKeys("Yusuf Ali");
        actions.sendKeys(Keys.TAB).sendKeys("COKELEZ").sendKeys(Keys.TAB).
                sendKeys("yali@gmail.com").sendKeys(Keys.TAB).
                sendKeys("12345").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("15").sendKeys(Keys.TAB).sendKeys("Tem").sendKeys(Keys.TAB).
                sendKeys("2023").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        Thread.sleep(3000);


    }
}
