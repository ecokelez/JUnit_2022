package day15_getScreenShotWE;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeAfter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class C01_GetScreenShotWE extends TestBase_BeforeAfter {


    @Test
    public void test01() throws IOException {
        //Amazona gidelim
        driver.get("https://amazon.com");
        //Nutella aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        //Arama sonuc yazisinin  resmini alalım
        WebElement aramaSonucu =
                driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));

        File nutellaAramaSonucu = aramaSonucu.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(nutellaAramaSonucu,new File("target/ekranGoruntusuWE/WebESS.jpeg"));

        //==> Sadece Web elementinin resmini alacaksak TakeScreenShot classını kullanmaya gerek yok
        //==>Locate ettiğimiz webelementini direk geçici olarak bir file'a atıp FileUtils ile kopyalayip
        //==> yolunu (path) belirtiriz

    }

}
