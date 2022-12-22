package day07_handleAlerts_BasicAuthentication_iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {

         /*================================== NOT: ======================================
    Bir web sitesine girdiğimizde karşımıza bir uyarı mesayı yada bir buttona tıkladığımızda bir uyarı(alert)
    çıkabilir. Eğer bu uyarıya incele(mause sağ tik-inspect) yapabiliyorsak bu tür alert'lere HTML alert denir
    ve istediğimiz locate'i alabiliriz. Ama gelen uyarı kutusuna müdehale(Sağ tik-incele) edemiyorsak bu tür
    alert'lere js alert denir. js alert'lere müdehale edebilmek için
    - tamam yada ok için driver.switchTo().alert().accept() kullanılır
    - iptal için driver.switchTo().alert().dismiss() methodu kullanılır
    - Alert içindeki mesajı almak için driver.switchTo().alert().getText() kullanılır
    - Alert bizden bir metin istiyorsa driver.switchTo().alert().sendKeys("") kullanılır
     */
    /*
        ● accept() => Bir uyarıda(alert) OK'ı tıklamakla aynı.
              driver.switchTo().alert().accept();
        ● dismiss() => Bir uyarıda(alert) Cancel'ı tıklamakla aynı.
            driver.switchTo().alert().dismiss();
        ●getText() => Uyarıdaki(alert) mesajı almak için.
            driver.switchTo().alert().getText();
        ●sendKeys(“Text”) => Uyarı(alert) text kutusuna text göndermek için
            driver.switchTo().alert().sendKeys("Text");
        */


        /*========================= Classwork =========================================
        https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        Click for JS Alert butonuna tıklayalım
        Tıkladıktan sonra çıkan uyarı mesajına (Alerte) tamam diyelim
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
        //driver.quit();
    }

    @Test
    public void test01(){
        //        https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //        Click for JS Alert butonuna tıklayalım
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //        Tıkladıktan sonra çıkan uyarı mesajına (Alerte) tamam diyelim
        driver.switchTo().alert().accept();

        WebElement sonucYaziWE = driver.findElement(By.xpath("//*[@id='result'][1]"));
        String expectedResult = "You successfully clicked an alert";
        String actualResult = sonucYaziWE.getText();

        Assert.assertEquals(expectedResult,actualResult);



    }
}
