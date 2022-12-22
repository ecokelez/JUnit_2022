package day10_fakerClass_fileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase_BeforeAfter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExist extends TestBase_BeforeAfter {
    /*
    //https://the-internet.herokuapp.com/download adresine gidelim.
    //test.txt dosyasını indirelim
    //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
    // İndirildiğini konsolda gösterin
     */

    @Test
    public void test01(){
        //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='LambdaTest.txt'][1]")).click();
        //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\win8\\Downloads\\LambdaTest.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        // İndirildiğini konsolda gösterin
        System.out.println("Dosya yolu : " + Files.exists(Paths.get(dosyaYolu)));
    }
}
