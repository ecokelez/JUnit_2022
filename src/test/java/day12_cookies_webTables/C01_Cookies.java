package day12_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase_BeforeAfter;

import java.util.Set;

public class C01_Cookies extends TestBase_BeforeAfter {

        /*
        1-Amazon anasayfayagidin
        2-tumcookie’lerilisteleyin
        3-Sayfadakicookiessayisinin5’denbuyukoldugunutestedin
        4-ismii18n-prefsolancookiedegerininUSDoldugunutestedin
        5-ismi“ensevdigimcookie”vedegeri“cikolatali”olan bir cookieolusturun ve sayfayaekleyin
        6-eklediginizcookie’ninsayfayaeklendiginitestedin
        7-ismiskinolancookie’yisilinvesilindiginitestedin
        8-tumcookie’lerisilinvesilindiginitestedin
         */

    @Test
    public void cookiesAutomation(){
        //        1-Amazon anasayfayagidin
        driver.get("https://amazon.com");
        //        2-tumcookie’lerilisteleyin
        Set<Cookie> tumCookie = driver.manage().getCookies();
        System.out.println(tumCookie);

        int count = 1;
        for (Cookie w:tumCookie) {
            System.out.println(count + ".ci cookie : " + w);
            System.out.println(count + ". name " + w.getName() );
            System.out.println(count + " . value " + w.getValue());
            count++;
        }

        //        3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu testedin
        int cookieSayisi = tumCookie.size();
        Assert.assertTrue(cookieSayisi>5);
        //        4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w: tumCookie) {

            if (w.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",w.getValue());
            }
        }

        //        5-ismi“ensevdigim cookie”ve degeri“cikolatali”olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        tumCookie = driver.manage().getCookies();

         count = 1;
        for (Cookie w:tumCookie) {
                System.out.println(count + ".ci cookie : " + w);
                System.out.println(count + ". name " + w.getName() );
                System.out.println(count + " . value " + w.getValue());
                count++;
        }

        //        6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(tumCookie.contains(cookie));
        //        7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        tumCookie = driver.manage().getCookies();

        count = 1;
        for (Cookie w:tumCookie) {
            System.out.println(count + ".ci cookie : " + w);
            System.out.println(count + ". name " + w.getName() );
            System.out.println(count + " . value " + w.getValue());
            count++;
        }
        Cookie isim = driver.manage().getCookieNamed("skin");
        Assert.assertFalse(tumCookie.contains(isim));

        //        8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookie = driver.manage().getCookies();

        Assert.assertTrue(tumCookie.isEmpty());
    }
}
