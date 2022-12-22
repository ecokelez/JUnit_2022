package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01_MavenFirstClass {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

         /*
       1- https://www.amazon.com/ sayfasina gidelim
       2- arama kutusunu locate edelim
       3- “Samsung headphones” ile arama yapalim
       4- Bulunan sonuc sayisini yazdiralim
       5- Ilk urunu tiklayalim
       6- Sayfadaki tum basliklari yazdiralim
        */


        //       1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //       2- arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        //       3- “Samsung headphones” ile arama yapalim
        searchBox.sendKeys("Samsung headphones", Keys.ENTER);
        //       4- Bulunan sonuc sayisini yazdiralim
        List<WebElement> sonucYazisi =
                driver.findElements(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        String sonucSayisiWE = sonucYazisi.get(0).getText();
        System.out.println("Samsung headphones arama sonucu :" + sonucSayisiWE);

        ///--> Sadece sonuc sayısını yazdıralım ;
        String [] sonucSayisi = sonucSayisiWE.split(" ") ;
        System.out.println("Samsung headphones arama sonucu :  " + sonucSayisi[2]);
        /// ==> Lambda ile yazdıralım ;
        System.out.println("Samsung headphones arama sonucunu Lambda ile yazdirma : ");
        Arrays.stream(sonucSayisiWE.split(" ")).limit(3).skip(2).forEach(System.out::println);

        //       5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("//*[@class='s-image'][1]")).click();

        //       6- Sayfadaki tum basliklari yazdiralim
        driver.navigate().back();

        WebElement allOfTittles =
                driver.findElement(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));

        System.out.println("Sayfadaki tum basliklari : " + allOfTittles.getText());

        // List ile yazdırma ;

        /* List<WebElement>allOfTittles =
                driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement w:allOfTittles) {
            System.out.println("Sayfadaki tum basliklari : " + w.getText() );
        }
         */

        // Sayfayı kapatalım
        driver.close();

    }
}
