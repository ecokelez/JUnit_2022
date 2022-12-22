package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
    /*
     * https://www.youtube.com adresine gidin
     * Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.youtube.com");

    }
    @After
    public  void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void titleTest01(){
        //* titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void test02(){
        // imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logoYoutube = driver.findElement(By.xpath("//*[@id='logo-icon'][1]"));

        Assert.assertTrue("YouTube resmi goruntulendi",logoYoutube.isDisplayed());
    }
    @Test
    public void test03(){
        //* Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='search'][1]"));
        Assert.assertTrue(searchBox.isEnabled());

    }
    @Test
    public void wrongTitleTest04(){
        //* * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String expectedTitle = "youtube";
        String actualTitle01 = driver.getTitle();
       Assert.assertNotEquals(expectedTitle,actualTitle01);
    }
}
