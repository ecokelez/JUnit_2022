package day08_handleWindows_TestBaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {

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
        //driver.close();
    }

    @Test
    public void test01(){

        //        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        String ilkSayfaHandleDegeri = driver.getWindowHandle();
        /* bu acilan sayfanin unique hash kodudur.Selenium sayfalar arası geciste bu window handle degerini kullanir
        Eger sayfalar arasinda driver'ımızı gezdiriyorsak ve
        herhangi bir sayfadan su anda bulundugumuz sayfaya gecmek istiyorsak driver.switchTo().window("");
        */

        //       Nutella icin arama yaptırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

        //        İlk urunun resmini tıklayarak farklı bir sayfada tab olrak acın
        WebElement ilkUrun = driver.findElement(By.xpath("//*[@class='s-image'][1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        Bu komutu kullandıgımızda driver otomatik olarak olusturulan new Tab'a gecer,
        yeni Tab'da gorevi gerceklestirmek icin adimlari bastan almamiz gerekir
        */
        driver.get("https://amazon.com");
        System.out.println(driver.getTitle());
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        driver.findElement(By.xpath("//*[@class='s-image'][1]")).click();


        //        Yeni TAB' da acilan urunun title'ını yazdiralim
        WebElement urunTitle = driver.findElement(By.xpath("//*[@id='productTitle'][1]"));
        System.out.println("Urun title :" + urunTitle.getText());

        //         İlk sayfaya dönüp url yazdrialim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println( driver.getCurrentUrl());



    }
}
