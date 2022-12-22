package day05_JUnit_CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {

    WebDriver driver ;

    @Before
    // Before notasyonu her testten önce çalışır
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        //After notasyonu her testten sonra çalışır
        driver.close();
    }


    @Test
    public void test01(){
        // 1 defa before methodu calsır ---> 1
        driver.get("https://amazon.com"); //--> 2
        // 1 defa after methodu calsıır   --->3
    }

    @Test
    public void test02(){
        // 1 defa before methodu calsır ----------------> 1
        driver.get("https://techproeducation.com"); //--> 2
        // 1 defa after methodu calsıır   --------------> 3
    }

    @Test
    public void test03(){
        driver.get("https://hepsiburada.com");
    }




}
