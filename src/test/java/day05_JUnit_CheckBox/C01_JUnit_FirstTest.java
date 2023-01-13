package day05_JUnit_CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JUnit_FirstTest {

    /*
     Junit ile Main Method kullanma donemini bitiriyoruz.
    ❖Junit Framework kullandigimizda yazdığımız test metodunun calismasi icin başına @Test
     notasyonu eklememiz yeterlidir.
    ❖@Test notasyonu eklemedigimiz metot test sırasında çalışıtırılmaz. Ancak cagrilirsa calisir.
     ==> Burada junit ile testlerimizi yapabilmek icin üzerine @ annotations dedigimiz @ isaretini
     koyuyoruz ve test yazıyoruz
    ==> run tusu main method yazarsak veya test notasyonunu yazarsak cıkar.
    JUnit ten run yaparsak buradaki bütün methodlar calisir yani aynı anda birden fazla yerin testini yapabiliriz.
     */


    @Test
    public void method01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");
      //  driver.close();
    }

    @Test
    public void test02(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://techproeducation.com");
        driver.close();
    }

    @Test
    public void test03(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.hepsiburada.com");
        driver.close();
    }
}
