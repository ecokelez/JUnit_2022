package day12_cookies_webTables;

import org.junit.Test;
import utilities.TestBase_BeforeAfter;

public class C04_WebTables extends TestBase_BeforeAfter {

          /*
     Bir Class olusturun D19_WebtablesHomework
    “https://demoqa.com/webtables” sayfasina gidin
    Headers da bulunan department isimlerini yazdirin
    sutunun basligini yazdirin
    Tablodaki tum datalari yazdirin
    Tabloda kac cell (data) oldugunu yazdirin
    Tablodaki satir sayisini yazdirin
    Tablodaki sutun sayisini yazdirin
    Tablodaki 3.kolonu yazdirin
    Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    Page sayfasinda bir method olusturun,
    Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin
         */
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

    @Test
    public void test01(){
        //   “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //    Headers da bulunan department isimlerini yazdirin
        //    sutunun basligini yazdirin
        //    Tablodaki tum datalari yazdirin
        //    Tabloda kac cell (data) oldugunu yazdirin
        //    Tablodaki satir sayisini yazdirin
        //    Tablodaki sutun sayisini yazdirin
        //    Tablodaki 3.kolonu yazdirin
        //    Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        //    Page sayfasinda bir method olusturun,
        //    Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin
    }
}
