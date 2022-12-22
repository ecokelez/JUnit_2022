package day05_JUnit_CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {


       // BeforeClass ve AfterClass notasyonlari kullaniyorsak
       // olusturacagimiz method'u static yapmammiz gerekiyor

    static WebDriver driver ;

    @BeforeClass
    // BeforeClass  notasyonu tum test suresince ve öncesinde 1 defa çalışır
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        //AfterClass notasyonu tum test suresince ve sonrasında 1 defa çalışır
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
    @Ignore           //Çalışmasını istemediğimiz test için @Ignore notasyonu kullanılır
    public void test03(){
        driver.get("https://hepsiburada.com");
    }






}
