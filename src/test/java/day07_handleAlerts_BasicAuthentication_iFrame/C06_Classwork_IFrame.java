package day07_handleAlerts_BasicAuthentication_iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C06_Classwork_IFrame {
    /*
    ●Bir class olusturun:IframeTest02
    1)http://demo.guru99.com/test/guru99home/sitesinegidiniz
    2)sayfadaki iframe sayısınıbulunuz.
    3)ilk iframe'deki (Youtube) play butonunatıklayınız.
    4)ilk iframe'den çıkıp ana sayfayadönünüz
    5)ikinci iframe'deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html)
    tıklayınız
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
    public void test01(){
        //    1)http://demo.guru99.com/test/guru99home/sitesinegidiniz
        driver.get("https://demo.guru99.com/test/guru99home/");
        //    2)sayfadaki iframe sayısını bulunuz

        List<WebElement>iFrameList =
                new ArrayList<>(driver.findElements(By.xpath("//*[@src='https://www.youtube.com/embed/RbSlW8jZFe8']")));

        System.out.println("iFrameList sayisi :  " + iFrameList.size());

        //    3)ilk iframe'deki (Youtube) play butonuna tıklayınız.
        List<WebElement> iFrameYoutube = driver.findElements(By.xpath("//*[@class='rt-grid-6 rt-omega'][2]"));
        driver.switchTo().frame(iFrameList.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();

        //    4)ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //    5)ikinci iframe'deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html)tıklayınız
        ///List<WebElement> jMIFrameList = driver.findElements(By.xpath("//*[@src='Jmeter720.png']"));
        ///driver.switchTo().frame(jMIFrameList.get(0));

    }





}
