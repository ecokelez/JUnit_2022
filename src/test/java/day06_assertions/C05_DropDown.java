package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C05_DropDown {
      /*
    Bir class oluşturun:C3_DropDownAmazon
    https://www.amazon.com/ adresinegidin.
    -Test1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    oldugunu test edin
    -Test2
    1.Kategori menusunden Books secenegini secin
    2.Arama kutusuna Java yazin vearatin
    3.Bulunan sonuc sayisiniyazdirin
    4.Sonucun Java kelimesini icerdigini testedin
    */

    WebDriver driver ;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01(){
        //***-Test1

        driver.get("https://www.amazon.com/");
        WebElement ddM = driver.findElement(By.xpath("//*[@id='searchDropdownBox'][1]"));
        Select select = new Select(ddM);

        //    Arama kutusunun yanindaki kategori menu. kategori sayisinin 45 old. test edin
        List<WebElement> optionList = select.getOptions();
        System.out.println("Toplam kategori sayisi : " + optionList.size());

        int expectedOptionSayisi = 45 ;
        int actualOptionSayisi = optionList.size();

        Assert.assertNotEquals(expectedOptionSayisi,actualOptionSayisi);

    }

    @Test
    public void test02() {
        //***-Test2
        //    1.Kategori menusunden Books secenegini secin
        driver.get("https://www.amazon.com/");
        WebElement ddM = driver.findElement(By.xpath("//*[@id='searchDropdownBox'][1]"));
        Select select = new Select(ddM);
        select.selectByVisibleText("Books");

        // Bir dropDown ile calisiyorken son secilen option' a ulasmak isterseniz
        // ==> select.getFirstSelectedOption() methodunu kullanmalisiniz  ==>
        // Bu method bize WebElement dondurur,
        //==> uzerindeki yaziyi yazdirmak icin getText() unutulmamalidir.
        System.out.println(select.getFirstSelectedOption().getText());

        //    2.Arama kutusuna Java yazin ve aratin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java", Keys.ENTER);
        //    3.Bulunan sonuc sayisini yazdirin
        List<WebElement> sonucYazisiWE = driver.findElements(By.xpath("//*[@class='sg-col-inner'][1]"));
        String sonucYazisi = sonucYazisiWE.get(0).getText();
        System.out.println("Arama sonucu  : " + sonucYazisi);
        //Sadece sonuc sayisini yazdirma
        String[] sonucSayisi = sonucYazisi.split(" ");
        System.out.println(" Arama sonuc sayisi : " + sonucSayisi[3]);
        ///Lambda ile sonuc sayisini  yazdırma
        System.out.println("Lambda ile arama sonuc sayisi :");
        Arrays.stream(sonucYazisi.split(" ")).limit(4).skip(3).forEach(t -> System.out.println(t));

        //    4.Sonucun Java kelimesini icerdigini test edin
        String arananKelime = "Java";
        String actualSonucYazisi = sonucYazisiWE.get(0).getText();

        Assert.assertTrue(actualSonucYazisi.contains(arananKelime));
    }
}
