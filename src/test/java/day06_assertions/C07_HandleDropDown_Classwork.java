package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_HandleDropDown_Classwork {
    /*
    1.http://zero.webappsecurity.com/ Adresinegidin
    2.Sign in butonunabasin
    3.Login kutusuna “username”yazin
    4.Password kutusuna “password.”yazin
    5.Sign in tusunabasin
    6.Pay Bills sayfasinagidin
    7.“Purchase Foreign Currency” tusunabasin
    8.“Currency” drop down menusunden Eurozone’usecin
    9.“amount” kutusuna bir sayigirin
    10.“US Dollars” in secilmedigini testedin
    11.“Selected currency” butonunusecin
    12.“Calculate Costs” butonuna basin sonra “purchase” butonunabasin
    13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontroledin.
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
        //    1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //    2.Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button'][1]")).click();
        //    3.Login kutusuna “username”yazin
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='user_login'][1]"));
        loginButton.sendKeys("username");
        //    4.Password kutusuna “password.”yazin
        WebElement paaswordButton = driver.findElement(By.xpath("//*[@id='user_password']"));
        paaswordButton.sendKeys("password");
        //    5.Sign in tusuna basin
        driver.findElement(By.xpath("//*[@value='Sign in']")).click();
        //    6.Pay Bills sayfasina gidin
        //    7.“Purchase Foreign Currency” tusunabasin
        //    8.“Currency” drop down menusunden Eurozone’usecin
        //    9.“amount” kutusuna bir sayigirin
        //    10.“US Dollars” in secilmedigini testedin
        //    11.“Selected currency” butonunusecin
        //    12.“Calculate Costs” butonuna basin sonra “purchase” butonunabasin
        //    13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontroledin.
    }
}
