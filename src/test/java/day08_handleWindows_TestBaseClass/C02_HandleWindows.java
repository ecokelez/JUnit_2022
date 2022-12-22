package day08_handleWindows_TestBaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {
    /*
        //1- Amazon Sayfasina girelim
        //2- Url'nin amazon içerdiğini test edelim
        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        //4- title'in BestBuy içerdiğini test edelim
        //5- İlk sayfaya dönüp sayfada java aratalım
        //6- Arama sonuclarının java içerdiğini test edelim
        //7- Yeniden bestbuy sayfasına gidelim
        //8- Logonun görünürlüğünü test edelim
        //9- Sayfaları Kapatalım
     */

    static WebDriver driver;
    @BeforeClass
    public static void seTup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }


    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test01() {
        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();
        //2- Url'nin amazon içerdiğini test edelim
        String arananKelime = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(arananKelime));
        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle = driver.getWindowHandle();
        //4- title'in BestBuy içerdiğini test edelim
        String arananStr = "Best Buy";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananStr) );
        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        //6- Arama sonuclarının Java içerdiğini test edelim
        String isteneKelime = "Java";
        WebElement sonucWE =
                driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        String aramaSonucYazisi = sonucWE.getText();
        Assert.assertTrue(aramaSonucYazisi.contains(isteneKelime));
        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);
        //8- Logonun görünürlüğünü test edelim
        WebElement logoWE = driver.findElement(By.xpath("//*[@class='logo'][1]"));
        Assert.assertTrue(logoWE.isDisplayed());

    }

}
