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

public class C04_IFrame {
    /*
    Bir class olusturun:IframeTest
    ●https://the-internet.herokuapp.com/iframe adresinegidin.
    ●Bir metod olusturun:iframeTest
    ○“An IFrame containing….” textinin erisilebilir old. test edin ve yazdirin.
    ○Text Box’a “Merhaba Dunya!”yazin.
    ○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur old. dogrulayin ve yazdirin.
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
        //driver.close();
    }

    @Test
    public  void test01() throws InterruptedException {
        //●https://the-internet.herokuapp.com/iframe adresinegidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //    ○“An IFrame containing….” textinin erisilebilir old. test edin ve yazdirin.
        WebElement baslikWE = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikWE.isEnabled());
        ///***Assert.assertTrue(driver.findElement(By.xpath("//h3")).isEnabled());
        System.out.println("baslikWE : " + baslikWE.getText());
        //    ○Text Box’a “Merhaba Dunya!”yazin.

        //*** searchTextBox 'ı dogru  locate etmemize ragmen driver bulamadi,
        //bunun uzerine HTML kodlarini inceleyince TextBoxın aslinda bir
        //IFrame old. gorduk , bu durumda onceIFrame'i locate edip
        // switch() to ile IFrame gecmeliyiz

        WebElement iFrameWE = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrameWE);

        WebElement searchBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
        searchBox.clear();
        searchBox.sendKeys("Merhaba Dunya!");

        Thread.sleep(3000);

        //    ○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur old. dogrulayin ve yazdirin.

        ///** link yazı WE  'i dogru  locate etmemize ragmen driver yazdirmadi,
        //cunku yukarida IFrame'e gecis yapmistik,
        //once oradan cikis yapmamiz gerekir

        driver.switchTo().defaultContent();

        WebElement linkWE = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(linkWE.isDisplayed());
        System.out.println("LinkWE  Yazisi : " + linkWE);



    }

}
