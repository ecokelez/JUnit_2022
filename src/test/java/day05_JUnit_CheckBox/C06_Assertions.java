package day05_JUnit_CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Assertions {

    WebDriver driver ;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
       // driver.close();
    }

    @Test
    public void test01(){
        /*
        Eger Test Methodumuzda hicbir test yoksa test calıstıktan sonra
        hicbir problemle karsılasılmadıgını raporlamak icin "Test Passed" yazısı cıkar
        Eger testleri if ile yaparsak test failed olsa bile kodlar problemsiz calıstıgı icin
        kod calısması bittiginde ekranın sol alt kısmında test passed yazacaktır
         */
        driver.get("https://amazon.com");

        //Url in facebook old test edin
        /* if (driver.getCurrentUrl().equals("https://facebook.com")){
            System.out.println("Url testi PASSED");
        }else System.out.println("Url testi FAILED");
        */

        String expectedUrl = "https://facebook.com";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Url beklenenden farkli ",expectedUrl,actualUrl);

         /*
        Assert ile yaptıgımız testlerde Assertion failed olursa
        Java kodalrın calısmasını durdurur ve Assert class'i bizi hata konuusnda
        bilgilendirir,boylece hatanın ne old. arastırmamıza gerek kalmadan JUnit
        bize raporlamıs olacaktır.

        org.junit.ComparisonFailure: Url beklenenden farkli
        Expected :https://facebook.com
        Actual   :https://www.amazon.com/
        <Click to see difference>

          */




    }
}
