package day08_handleWindows_TestBaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C03_WindowHandles {
        /*
        ●Tests package’inda yeni bir class olusturun:WindowHandle2
        ●https://the-internet.herokuapp.com/windows adresine gidin.
        ●Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        ●Sayfa başlığının (title) “The Internet” olduğunu doğrulayın.
        ●Click Here butonuna basın.
        ●Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        ●Sayfadaki textin “New Window” olduğunu doğrulayın.
        ●Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
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
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        //        https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //        ●Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement linkWE = driver.findElement(By.xpath(" //h3"));
        String expectedText = "Opening a new window";
        String actualText = linkWE.getText();
        Assert.assertEquals(expectedText,actualText);
        //        ●Sayfa başlığının (title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        /*
        Eger kontrolsuz acilan bir tab ve ya window varsa o zaman sayfaların
        window handle degerlerini elde etmem gerekir
        Oncelikle 2. sayaf acilmadan  ilk sayfanın windowHandle degerini bir String'e atayalım
         */
        String ilkSayfaWindowHandle = driver.getWindowHandle();

        //        ●Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here'][1]")).click();

        List<String > windowList = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Window Handle degerleri : " + windowList);
        driver.switchTo().window(windowList.get(1));


        /*
        ==> driver.switchTo().newWindow() demeden link tıklayarak yenii tab ve ya window olus.
        biz driver'a yeni sayfaya gec demedikce  driver eski sayfada kalır ve yeni syf. ile ilgili
        hicbir islem yapamaz,
        ==>Yeni sayfada driver'ı calstırmak isterseniz once driver'ı yeni syfya gondermelisiniz
        ==> Yeni syfya geceblmek icin ikinciSayfaWindowHandle degerini bulmak gerekir,
        bunun icin driver.getWindowHandles() methodunu kullanarak acık olan tum sayafların
        window handle degerlerini alip bir sete assign ederiz

        ==> İlk syf window handle degerini zaten biliyoruz,Set'teki window Handle degerlerini
        kontrol edip ilk syfnın handle degerlerine esit olmayan deger ikinci sayfanın window handle'dır.
                 */


        String ikinciSyfWindowHandle = driver.getWindowHandle();

        Set<String> windowHandleSeti = driver.getWindowHandles();
        System.out.println(windowHandleSeti);
        String ikinciSayfaWindowHandle = "";

        for (String w: windowHandleSeti) {
            if (!w.equals(ilkSayfaWindowHandle)){
                 ikinciSayfaWindowHandle = w;
            }
        }


        //=>Artık ikinci sayfanın window handle degerini biliyoruz,sayflar arası gecis yapabiliriz
        driver.switchTo().window(ikinciSayfaWindowHandle);

        //        ●Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expectedNewTitle = "New Window";
        String actualNewTitle = driver.getTitle();
        Assert.assertEquals(expectedNewTitle,actualNewTitle);

        //        ●Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement textWE = driver.findElement(By.xpath("//*[@class='example'][1]"));
        String expectedNewText = "New Window";
        String actualNewText = textWE.getText();
        Assert.assertEquals(expectedNewText,actualNewText);


        //        ●Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        Thread.sleep(1000);
        driver.switchTo().window(ilkSayfaWindowHandle);
         expectedTitle = "The Internet";
         actualTitle = driver.getTitle();

         Assert.assertEquals(expectedTitle,actualTitle);

    }
}
