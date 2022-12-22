package day15_getScreenShotWE;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase_BeforeAfter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_JsExecuters_GetScreenShot extends TestBase_BeforeAfter {

    /*
    1- Amazon sayfasına gidelim
    2-Asagıdaki carrers butonunu görünceye kadar js ile scroll yapalım
    3-Carrers butonuna js ile click yapalım
     */

    @Test
    public void test01() throws IOException {
        //    1- Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //    2-Asagıdaki carrers butonunu görünceye kadar js ile scroll yapalım
        WebElement carrersWE = driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",carrersWE);
        //    3-Carrers butonuna js ile click yapalım
        jse.executeScript("arguments[0].click();",carrersWE);
        //    4-Carrers butonuna js ile click yapıldıgını  ScreenShot ile test edelim
        WebElement amazonJobWE  = driver.findElement(By.xpath("//*[@class='logo'][1]"));
        File carrersSonuc = amazonJobWE.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(carrersSonuc,new File("target/ekranGoruntusu/allPage"+tarih+".jpeg"));

        Assert.assertTrue("Ekran resmi alindi",amazonJobWE.isDisplayed());




    }
}
