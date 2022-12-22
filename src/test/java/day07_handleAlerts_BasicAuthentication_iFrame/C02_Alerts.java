package day07_handleAlerts_BasicAuthentication_iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
        /*
        Bir class olusturun: Alerts
        https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        Bir metod olusturun: acceptAlert
        1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve
        result mesajının  “You successfully clicked an alert” oldugunu test edin.
        Bir metod olusturun: dismissAlert
        2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        “successfuly” icermedigini test edin.
        Bir metod olusturun: sendKeysAlert
        3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
         */
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @AfterClass
    public static void tearDown(){
        // driver.close();
    }

    @Test
    public void test01(){
        //        1. butona tıklayın, uyarıdaki
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //      Alert uzuerindeki mesajı yazdırın
        System.out.println("1. butonun Alert mesaji : " + driver.switchTo().alert().getText());
        //     OK butonuna tıklayın ve
        driver.switchTo().alert().accept();

        //        result mesajının  “You successfully clicked an alert” oldugunu test edin.
       WebElement sonucYazisiWE = driver.findElement(By.xpath("//*[@id='result']"));
       String expectedResult = "You successfully clicked an alert";
        String actualResult = sonucYazisiWE.getText();
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void test02(){
        //      2. butona tıklayın, uyarıdaki
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        //      Alert uzuerindeki mesajı yazdırın
        System.out.println("2. butonun Alert mesaji :  " + driver.switchTo().alert().getText());
        //      Cancel butonuna tıklayın ve
        driver.switchTo().alert().dismiss();

        // result mesajının “successfuly” icermedigini test edin.
        WebElement sonucYazisiWE = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String arananKelime = "successfuly";
        String actualResult = sonucYazisiWE.getText();
        Assert.assertFalse(actualResult.contains(arananKelime));

    }

    @Test
    public void test03(){
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        WebElement jsPromptWE = driver.findElement(By.xpath("//*[@onclick='jsPrompt()']"));
        jsPromptWE.click();
        //      Alert uzuerindeki mesajı yazdırın
        System.out.println("3. butonun Alert mesaji :  " + driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Ersoy");
        //      OK butonuna tıklayın
        driver.switchTo().alert().accept();

        // result mesajında isminizin görüntülendiğini doğrulayın.
        WebElement resultWE = driver.findElement(By.xpath("//*[@id='result']"));
        String girilenIsim = "Ersoy";
        String actulaResult = resultWE.getText();
        Assert.assertTrue(actulaResult.contains(girilenIsim));

    }


}
