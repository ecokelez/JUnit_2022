package day15_getScreenShotWE;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeAfter;

public class C02_JsExecutors extends TestBase_BeforeAfter {

    @Test
    public void test01(){
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Asagıdaki carrers butonunu görünceye kadar js ile scroll yapalım
        WebElement carrersWE = driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",carrersWE);
        //Carrers butonuna js ile click yapalım
        jse.executeScript("arguments[0].click();",carrersWE);

    }
}
