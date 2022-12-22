package day12_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C03_WebTables extends TestBase_BeforeAfter {
         /*
        1-Bir onceki class'taki adrese gidelim ,
        2-login() methodunu kullanarak sayfaya giris yapalim
        3-input olarak verilen satir ve sutun sayisina sahip cell'deki texti yazdiralim.
        4-PriceNo baslıgındaki tum numaraları yazdırın
        int satir = 3;
        int sutun = 4;
        */
    /********************************************************************************
     //thead(Baslik)         //tr(Satir)     //th(Sutun)                   Baslik icin
     //tbody(Vucut- Ana)     //tr(Satir)      //td (Vucut - Ana Sutunu)     Body icin
     Thead de satır için tr, sutun için th
     Tbady de satır için tr, sütun için td
     ********************************************************************************/


    @Test
    public void test01(){
        //        2-login() methodunu kullanarak sayfaya giris yapalim
        login();
               int satir = 3;
               int sutun = 4;
        //        3-input olarak verilen satir ve sutun sayisina sahip cell'deki texti yazdiralim.
        WebElement cell = driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("Satir ve sutun tetx : " + cell.getText());
        //        4-PriceNo baslıgındaki tum numaraları yazdırın
       List<WebElement> priceBaslik = driver.findElements(By.xpath("//tbody//tr//td[6]"));

       for (WebElement w:priceBaslik) {
            System.out.println(w.getText());
        }

        //Lamnda ile :
        System.out.println("Lamda ile PriceNo :");
       priceBaslik.forEach(t-> System.out.println(t.getText()));

    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        // driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);

        WebElement userName=driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).
                sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

    }
}
