package day10_fakerClass_fileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeAfter;

public class C05_FileUpload  extends TestBase_BeforeAfter {
        /*

        2.https://the-internet.herokuapp.com/upload adresinegidelim
        3.chooseFile butonunabasalim
        4.Yuklemek istediginiz dosyayisecelim.
        5.Upload butonunabasalim.
        6.“File Uploaded!” textinin goruntulendigini testedelim.
         */

    @Test
    public void test01(){
        //        2.https://the-internet.herokuapp.com/upload adresinegidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //        3.chooseFile butonuna basalim
        WebElement dosyaSecWE = driver.findElement(By.id("file-upload"));
        //        4.Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = "C:\\Users\\win8\\Desktop\\Selenium.txt";
        dosyaSecWE.sendKeys(dosyaYolu);

        //        5.Upload butonunabasalim.
        driver.findElement(By.id("file-submit")).click();

        //        6.“File Uploaded!” textinin goruntulendigini testedelim.
        WebElement yaziWE = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(yaziWE.isDisplayed());
        ////==> 2. yol:
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
