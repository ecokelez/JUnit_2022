package day05_JUnit_CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButton {
        /*
        1.Bir class oluşturun :RadioButtonTest
        2.Gerekli yapiyi olusturun ve aşağıdaki görevitamamlayın.
        -https://www.facebook.com adresinegidin
        -Cookies’i kabuledin
        -“Create an Account” button’unabasin
        -“radio buttons” elementlerini locateedin
        -Secili degilse cinsiyet butonundan size uygun olanisecin
         */

   static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
         driver.close();
    }

    @Test
    public void test01(){
        //         -https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //        -Cookies’i kabul edin
        //        -“Create an Account” button’unabasin
       driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();
        //        -“radio buttons” elementlerini locateedin
        WebElement femaleButton = driver.findElement(By.xpath("//*[@class='_8esa'][1]"));
        WebElement maleButton = driver.findElement(By.xpath("//*[text()='Erkek']"));
        WebElement customButton = driver.findElement(By.xpath("//*[text()='Özel']"));

        //        -Secili degilse cinsiyet butonundan size uygun olanisecin
       if (!maleButton.isSelected()){
           maleButton.click();
       }

    }
}
