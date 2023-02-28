package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class QA01_Assertion {
        /*
        Yeni bir Class Olusturun : D11_SoftAssert1
        1.“https:// hepsiburada .com/” Adresine gidin
        2.Basliginin “ Turkiye’nin En Buyuk Alisveris Sitesi " icerdigini dogrulayin
        3.search kutusuna araba yazip arattirin
        4.bulunan sonuc sayisini yazdirin
        5.sonuc yazisinin "araba" icerdigini dogrulayin
        6.Sonuc yazisinin oto ” kelimesi icermedigini dogrulayin
         */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01(){
       //1.“https://hepsiburada.com/” Adresine gidin
        driver.get("https://hepsiburada.com/");

        //2.Basliginin “ Turkiye’nin En Buyuk Alisveris Sitesi " icerdigini dogrulayin
        String expectedTitle="Turkiye’nin En Buyuk Alisveris Sitesi";
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Sayfa basligi " + expectedTitle + "  ifadesini iceriyor,test PASSED");
        }else System.out.println("Sayfa basligi " + expectedTitle + " ifadesini icermiyor,test FAILED");
        System.out.println("=======================");

        // 3.search kutusuna araba yazip arattirin
        driver.findElement
                (By.xpath("//*[@class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']")).
                sendKeys("araba", Keys.ENTER);

        // 4.bulunan sonuc sayisini yazdirin
        List<WebElement> aramaSonucu=driver.findElements
                (By.xpath("//*[@class='searchResultSummaryBar-CbyZhv5896ASVcYBLKmx']"));
        String sonucYazisi=aramaSonucu.get(0).getText();
        System.out.println("Arama sonucu : " + sonucYazisi);
        System.out.println("=============================");

        // Sadece sonuc sayisinı yazdırın
        String[]  sonucSayisi=sonucYazisi.split(" ");
        System.out.println("Sonuc sayisi : " + sonucSayisi[3]);
        System.out.println("==================================");

        //Sadece sonuc sayısını Lambda ile yazdıralım
        System.out.println("Lambda ile sonuc sayisi :");
        Arrays.stream(sonucYazisi.split(" ")).limit(4).skip(3).forEach(System.out::println);
        System.out.println("=====================================");

        // 5.sonuc yazisinin "araba" icerdigini dogrulayin
        String expectedKelime="araba";
        String actualResult=aramaSonucu.get(0).getText();
        Assert.assertTrue(actualResult.contains(expectedKelime));
        System.out.println("======================================");

        // 6.Sonuc yazisinin oto ” kelimesi icermedigini dogrulayin
        String expectedKelime02="oto";
        Assert.assertFalse(actualResult.contains(expectedKelime02));
    }
}
