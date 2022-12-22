package day08_handleWindows_TestBaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_Classwork_HandleWindows {
        /*
        ●Yeni bir class olusturun:WindowHandle
        ●Amazon anasayfa adresinegidin.
        ●Sayfa’nin window handle degerini String bir degiskeneatayin
        ●Sayfa title’nin “Amazon” icerdigini testedin
        ●Yeni bir tab olusturup, acilan tab’da techproeducation.com adresinegidin
        ●Sayfa title’nin “TECHPROEDUCATION” icerdigini testedin
        ●Yeni bir window olusturup, acilan sayfada walmart.com adresinegidin
        ●Sayfa title’nin “Walmart” icerdigini testedin
        ●Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu testedin
         */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
       driver.quit();
    }

    @Test
    public void test01(){
        //        ●Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        //        ●Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWinHandle = driver.getWindowHandle();
        //        ●Sayfa title’nin “Amazon” icerdigini test edin
        String arananKelime = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananKelime));
        //        ●Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com ");
        //        ●Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        arananKelime = "TECHPROEDUCATION";
        actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(arananKelime));
        //        ●Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        //        ●Sayfa title’nin “Walmart” icerdigini test edin
        arananKelime = "Walmart";
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananKelime));
        //        ●Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWinHandle);
        Assert.assertTrue(actualTitle.contains(arananKelime));

    }

}
