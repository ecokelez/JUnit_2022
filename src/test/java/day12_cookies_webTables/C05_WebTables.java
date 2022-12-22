package day12_cookies_webTables;

import org.junit.Test;
import utilities.TestBase_BeforeAfter;

public class C05_WebTables extends TestBase_BeforeAfter {
     /*
    ●login( ) metodun oluşturun ve oturumaçın.
    ●https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresinegidin
        ○Username:manager○Password :Manager2!
    ●table( ) metoduoluşturun
        ○Tüm table body’sinin boyutunu(sutun sayisi) bulun./tbody
        ○Table’daki tum body’i ve başlıkları(headers) konsoldayazdırın.
    ●printRows( ) metodu oluşturun//tr
      ○table body’sinde bulunan toplam satir(row) sayısınıbulun.
      ○Table body’sinde bulunan satirlari(rows) konsoldayazdırın.
      ○4.satirdaki(row) elementleri konsoldayazdırın.
    ●printCells( ) metodu oluşturun//td
        ○table body’sinde bulunan toplam hücre(cell) sayısınıbulun.
        ○Table body’sinde bulunan hücreleri(cells) konsoldayazdırın.
    ●printColumns( ) metoduoluşturun
        ○table body’sinde bulunan toplam sutun(column) sayısınıbulun.
        ○Table body’sinde bulunan sutunlari(column) konsoldayazdırın.
        ○5.column daki elementleri konsoldayazdırın.
      */

    @Test
    public void test01(){
        //    ●login( ) metodun oluşturun ve oturumaçın.
        login();
        //    ●https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresinegidin
        //        ○Username:manager○Password :Manager2!
        //    ●table( ) metoduoluşturun
        //        ○Tüm table body’sinin boyutunu(sutun sayisi) bulun./tbody
        //        ○Table’daki tum body’i ve başlıkları(headers) konsoldayazdırın.
        //    ●printRows( ) metodu oluşturun//tr
        //      ○table body’sinde bulunan toplam satir(row) sayısınıbulun.
        //      ○Table body’sinde bulunan satirlari(rows) konsoldayazdırın.
        //      ○4.satirdaki(row) elementleri konsoldayazdırın.
        //    ●printCells( ) metodu oluşturun//td
        //        ○table body’sinde bulunan toplam hücre(cell) sayısınıbulun.
        //        ○Table body’sinde bulunan hücreleri(cells) konsoldayazdırın.
        //    ●printColumns( ) metoduoluşturun
        //        ○table body’sinde bulunan toplam sutun(column) sayısınıbulun.
        //        ○Table body’sinde bulunan sutunlari(column) konsoldayazdırın.
        //        ○5.column daki elementleri konsoldayazdırın.
    }

    private void login() {
        //    ●login( ) metodun oluşturun ve oturumaçın.
        //    ●https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresinegidin
        //        ○Username:manager○Password :Manager2!
        driver.get("https://qa-environment.concorthotel.com/admin/HotelRoomAdmin");
    }
}
