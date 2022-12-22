package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDown {
    /*
        Bir class oluşturun: DropDown
        https://the-internet.herokuapp.com/dropdown adresine gidin.
        Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        Tüm dropdown değerleri(value) yazdırın
        Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        False yazdırın.
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
        // driver.close();
    }

    @Test
    public void test01() {
        //        https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //        Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddM = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(ddM);
        select.selectByIndex(1);
        System.out.println("(Option 1 :  " + select.getFirstSelectedOption().getText());
        //        Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println("Option 2 : " + select.getFirstSelectedOption().getText());
        //        Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println("Option 1 : " + select.getFirstSelectedOption().getText());
        //        Tüm dropdown değerleri(value) yazdırın
        List<WebElement> ddMAllOptions = select.getOptions();
        ///System.out.println("Tüm dropdown değerleri : " + allOptions.get(0).getText());:

        for (WebElement w : ddMAllOptions) {
            System.out.println("Tum dropdown degerleri : " + w.getText());
        }

        ///*** Lambda methodu ile tüm optionları yazdiralim
        System.out.println("Lambda methodu ile tum optionlar :");
        ddMAllOptions.forEach(t -> System.out.println(t.getText()));

        //        Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //        False yazdırın
        int ddmBoyut = ddMAllOptions.size();
        if (ddmBoyut == 4) {
            System.out.println("True");
        } else System.out.println("False");

             /*
            if (ddMAllOptions.size()==4){
            System.out.println("True");
            } else System.out.println("False");
            */


        }
    }

