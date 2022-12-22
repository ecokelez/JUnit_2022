package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    /*
        1.http://zero.webappsecurity.comsayfasinagidin
        2.Signin buttonunatiklayin
        3.Login alanine “username”yazdirin
        4.Password alanine “password”yazdirin
        5.Sign in buttonunatiklayin
        6.Pay Bills sayfasinagidin
        7.amount kismina yatirmak istediginiz herhangi bir miktariyazin
        8.tarih kismina “2020-09-10”yazdirin
        9.Pay buttonunatiklayin
        10.“The payment was successfully submitted.” mesajinin ciktigini controledin
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //        1.http://zero.webappsecurity.com sayfasinagidin
        driver.get("http://zero.webappsecurity.com");
        //        2.Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        //        3.Login alanine “username”yazdirin
        WebElement loginBox = driver.findElement(By.xpath("//*[@id='user_login'][1]"));
        loginBox.sendKeys("username");
        //        4.Password alanine “password”yazdirin
        WebElement passwordBox = driver.findElement(By.xpath("//*[@id='user_password'][1]"));
        passwordBox.sendKeys("password");
        //        5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@value='Sign in']")).click();
        driver.navigate().back();
        //        6.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu'][1]")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link'][1]")).click();

        //        7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amountBox = driver.findElement(By.xpath("//*[@id='sp_amount'][1]"));
        amountBox.sendKeys("100");
        //        8.tarih kismina “2020-09-10”yazdirin
        WebElement dateBox = driver.findElement(By.xpath("//*[@id='sp_date']"));
        dateBox.sendKeys("2020-09-10");
        //        9.Pay buttonunatiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //        10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement messageControl = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));

        if (messageControl.isDisplayed()){
            System.out.println("Pay Control testi PASSED");
        }else System.out.println("Pay Control testi FAILED");


    }
}
