package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {

    /******************************************************************************************
     ******* assertTrue *******
     //beklenen bir sonucun true olduğunun kabul edilmesi gerektiği zaman kullanılır.
     // Parametre olarak iki değer alır.
     // İlk parametre de bir mesaj gönderilir ikinci parametrede ise gönderilen mesajın doğruluğu için koşul belirlenir.
     ********  assertFalse********
     //beklenen bir sonucun false olması durumunda kullanılır.
     // İki parametre alır. Parametrelerden biri mesajdır diğeri ise koşuldur.
     // assertFalse ile koşul yerine getirilmez ise assertionError hatası fırlatır.
     ******************************************************************************************* */

    /********************************************************************************
     Not : BeforeAfter methodunda testleri farklı sayfalarda açıp kapatıyor,
     BeforeAfterCLass methodlarında aynı sayfada açıp sonra kapatıyor.
     BeforeAfter methodunda methodların static yapmaya gerek yok
     ****  ama BeforeAfterCLass'da static yapmak zorunlu.*********************************/
         /*
        Amazon sayfasina git
        3 farkli test method'u olustur
        1- url'in "amazon" icergini test et
        2- title'in "facebook" icermedigini test et
        3- sol ust kosede amazon logosunun gorundugunu test et
        */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
    }


    @AfterClass
    public static void tearDown(){
        driver.close();



    }

    @Test
    public void test01(){
        // 1- url'in "amazon" icergini test et
        String arananKelime = "amazon";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(arananKelime));


    }


    @Test
    public void test02(){
        // 2- title'in "facebook" icermedigini test et

        String istenenKelime = "facebook";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(istenenKelime));

    }

    @Test
    public void test03(){
        // 3- sol ust kosede amazon logosunun gorundugunu test et
        WebElement logoControl = driver.findElement(By.id("nav-logo-sprites"));

        Assert.assertTrue(logoControl.isDisplayed());



    }
}
