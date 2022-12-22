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

public class C04_DropDownHandle {

     /*
    -Test1
    1.Kategori menusunden Books secenegini secin
    2.Arama kutusuna Java yazin vearatin
    3.Bulunan sonuc sayisiniyazdirin
    4.Sonucun Java kelimesini icerdigini testedin
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

        driver.get("https://www.amazon.com/");

        //Dropdown'dan bir option secmek icin 3 adim vardir;
        //* 1- DropDown 'ı locate edelim
        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox'][1]"));
        //* 2- Select Class'ından bir Select obj. olusturp parametre olarak
        // locate ettigimiz dropdown webelement'ini select class'ina tanimlariz
        Select select = new Select(dropDownMenu);

        //* 3- Dropdown' da var olan option'lardan istedigimiz bir taneyi seceriz
        select.selectByVisibleText("Books");// Eğer Dropdown menudeki option'a string olarak ulaşmak istersek bu methodu kullanırız
        //select.selectByIndex(5); // Eğer dropdown menusünun index'i ile ulasmak istersek bu methodu kullanırız
        //select.selectByValue("search-alias=stripbooks-intl-ship"); // Eğer dropdown menusundeki optiona value ile ulaşmak istersek bu methodu kullanırız

        //    2.Arama kutusuna Java yazin ve aratin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java", Keys.ENTER);
        //    3.Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisiWE = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        String sonucYazisi =  sonucYazisiWE.getText();

        ///Lambda ile sadece sonuc sayısını da  yazdıralım
        String [] sonucSayisiWE = sonucYazisi.split(" ");
        System.out.println("sSonuc sayisi : " + sonucSayisiWE[3]);
        System.out.println("Lambda ile sadece sonuc sayısı :");
        Arrays.stream(sonucYazisi.split(" ")).limit(4).skip(3).forEach(System.out::println);

        //    4.Sonucun Java kelimesini icerdigini test edin
        String arananKelime = "Java";
        String actualSonucYazisi = sonucYazisiWE.getText();

        Assert.assertTrue(actualSonucYazisi.contains(arananKelime));



    }


}
