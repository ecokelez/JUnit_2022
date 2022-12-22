package day10_fakerClass_fileExist;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeAfter;

public class C01_Faker extends TestBase_BeforeAfter {
    /*
    1."https://facebook.com" Adresinegidin
    2.“create new account” butonunabasin
    3.“firstName” giris kutusuna bir isimyazin
    4.“surname” giris kutusuna bir soyisimyazin
    5.“email” giris kutusuna bir emailyazin
    6.“email” onay kutusuna emaili tekraryazin
    7.Bir sifregirin
    8.Tarih icin gunsecin
    9.Tarih icin aysecin
    10.Tarih icin yilsecin
    11.Cinsiyetisecin
    12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini testedin.
    13.Sayfayikapatin
     */

    @Test
    public void test01() throws InterruptedException {
        //    1."https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
        //    2.“create new account” butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy'][1]")).click();
        //    3.“firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        WebElement isimBox = driver.findElement(By.xpath("//*[@class='inputtext _58mg _5dba _2ph-'][1]"));
        String email = faker.internet().emailAddress();
        actions.click(isimBox).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("20").sendKeys(Keys.TAB).sendKeys("Sep").
                sendKeys(Keys.TAB).sendKeys("2023").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        Thread.sleep(5000);


        /*
        ==> NOT : Aynı mail adresini girmesi için String bir değişkene atama yaptık
        ==> Faker classını kullanma amacımız form doldurmamız gereken web sitelerinde
        defalarca kendi üreteceğimiz veriler yerine faker bizim için random veriler üretir ve işimizi kolaylaştırır
        ==> Faker classını kullanmak için mvnrepository.com adresinden java-faker kütüphanesini aratır
        ve en çok kullanılanı pom.xml dosyamıza ekleriz.
        ==> Ve faker class'ından bir obje oluşturup;
        email için faker.internet() methodunu kullanarak emailAddress() methodunu seçeriz.
        ==> password içinde aynı internet methodunu kullanırız.
        ==> İsim ve soyisimler için faker.name() methodu ile firstname() ve lastname() methodunu kullanırız
         */
    }

}
