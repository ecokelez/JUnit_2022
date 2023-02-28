package day12_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C02_WebTables extends TestBase_BeforeAfter {
    /*
        ●login( ) metodun oluşturun ve oturum açın.
        ●https://www.hotelmycamp.com admin/HotelRoomAdmin adresinegidin
    ○Username :manager
    ○Password :Manager1!
        ●table( ) metoduoluşturun
    ○Tüm table body’sinin boyutunu(sutun sayisi) bulun.
    ○Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        ●printRows( ) metodu oluşturun//tr
    ○table body’sinde bulunan toplam satir(row) sayısını bulun.
    ○Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    ○4.satirdaki(row) elementleri konsolda yazdırın
     */
    @Test
    public void test01(){
        //        ●login( ) metodun oluşturun ve oturum açın.
        login();
        //        ●https://www.hotelmycamp.com admin/HotelRoomAdmin adresinegidin
        //        ○Username :manager
        //        ○Password :Manager1!

        //        ●table( ) metoduoluşturun
          /*
        ==> Tabloda <table> tagı altında tablonun baslıgını gosteren <thead> tagı bulunur.
        ==> Eger baslikda satir(row) varsa <thead> tagı altinda <tr> (satır-row) tagı vardır.
        Ve baslıkdaki sutunlara yani hucrelere(cell) de <th> tagı ile ulasilir.
        ==> Baslıgın tablodaki verilere <tbody> tagı ile altındaki satırlara(row) <tr> tagı ile
        sutunlara yani hucrelere <td> tagı ile ulasilir.
           */

         /********************************************************************************
         //thead(Baslik)         //tr(Satir)     //th(Sutun)                   Baslik icin
         //tbody(Vucut- Ana)     //tr(Satir)      //td (Vucut - Ana Sutunu)     Body icin
         Thead de satır için tr, sutun için th
         Tbady de satır için tr, sütun için td
         ********************************************************************************/
        //        ○Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun sayisi :  = " + sutunSayisi.size());
        //        ○Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar : " + basliklar.getText());

        /*
        NOT :  ==> Tum body'i  bir String olarak yazdirmak isterseniz body WebElement' ini locate edip
        getText() method'u ile yazdirabilirsiniz
         */
        WebElement tumBody = driver.findElement(By.xpath("//body"));
        System.out.println("Tum Body : " + tumBody.getText());

        //        ●printRows( ) metodu oluşturun//tr
        //        ○table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi :  " + satirSayisi.size());
        //        ○Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement w: satirSayisi) {
            System.out.println(w.getText());
        }
        /// ==> Lambda ile :
        satirSayisi.forEach(t-> System.out.println(t.getText()));
        //        ○ 4.satirdaki(row) elementleri konsolda yazdırın
        List<WebElement> cellList = driver.findElements(By.xpath("//tbody//tr[4]"));
        for (WebElement w: cellList) {
            System.out.println(w.getText());
        }

        //==> 2.yol :  Satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("-----------------------------------------");
        WebElement rowWE=driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println("Satirdaki elementler : "+rowWE.getText());

         //         Email baslıgındaki tum elementleri(sutun) yazdirin
        ///==> once email baslgıını kacinci sutunda old. bulalim
        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo= 0;

        for (int i = 0; i < basliklarListesi.size(); i++) {
            if (basliklarListesi.get(i).getText().equals("Email")){
                emailSutunNo = i ;
            }
        }


        List<WebElement> emailSutunListesi = driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement w: emailSutunListesi) {
            System.out.println(w.getText());
        }

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
