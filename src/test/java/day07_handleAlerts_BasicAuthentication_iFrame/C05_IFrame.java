package day07_handleAlerts_BasicAuthentication_iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_IFrame {

    /*
        IFrame, bir web sayfasına icine yerlestirilmis
         baska bir web sayfasıdır veya bir HTML
         dokumaninin içine yerleştirilmiş baska bir HTML
         dokumanidir.
        IFrame genellikle bir Web sayfasına dokuman,
        video veya interaktif media gibi başka bir
        kaynaktan içerik eklemek için kullanılır. <iframe>
        tag’ı bir inline frame belirtir.
        */



    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @After
    public  void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //  driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://html.com/tags/iframe/");
         /*
       NOT ==> Bir web sitesinde bir video(youtube vb.) varsa <iframe> tag'ı içerisindeyse
       bu video'yu direk locate edip çalıştırmak dinamik olmaz çünkü link değişebilir ve locate'imiz çalışmaz.
          ===>Bunun için bütün frame'leri bir array liste atıp index ile frame'i seçip
       sonrasında play tuşunu locate edip  çalıştırabiliriz.
        */



    }
}
