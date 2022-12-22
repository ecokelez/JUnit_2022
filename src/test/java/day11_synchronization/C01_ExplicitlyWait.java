package day11_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase_BeforeAfter;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase_BeforeAfter {
        /*
        Bir class olusturun : WaitTest
        Iki tane metod olusturun : implicitWait() , explicitWait()
        Iki metod icin de asagidaki adimlari test edin.
        https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        Remove butonuna basin.
        “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Add buttonuna basin
        It’s back mesajinin gorundugunu test edin
         */
    @Test
    public void implicitWaitTest(){
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get(" https://the-internet.herokuapp.com/dynamic_controls");
        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()'][1]")).click();
        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneWE = driver.findElement(By.xpath("//p[@id='message'][1]"));
        Assert.assertTrue(itsGoneWE.isDisplayed());
        // Add buttonuna basin
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()'][1]")).click();
        //        It’s back mesajinin gorundugunu test edin
        WebElement linkWE = driver.findElement(By.xpath("//*[@id='message'][1]"));
        Assert.assertTrue(linkWE.isDisplayed());

    }
    @Test
    public void explicitWaitTest(){
        //        https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //        Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()'][1]")).click();
        //        “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

        /*
         ===> explicitWait itsgoneWE görünür olmasını beklerken o web elementinin locatini kullanarak
        assert yapmak sorun olur ve exeption fırlatır.
        ==> Henüz görülmeyen bir Webelementin locate edilmeside otamasyon için
        mümkün olmaz. Bu durumda bekleme işlemi için explicitWait'i locate ile birlikte kullanırız
         */
        WebElement itsGoneWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message'][1]")));
        Assert.assertTrue(itsGoneWE.isDisplayed());
        //        Add buttonuna basin
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()'][1]")).click();

        //        It’s back mesajinin gorundugunu test edin
        WebElement itsBackWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message'][1]")));
        Assert.assertTrue(itsBackWE.isDisplayed());

    }
}
