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

public class C02_ExplicitlyWait extends TestBase_BeforeAfter {
         /*
        1.Bir class olusturun :EnableTest
        2.Bir metod olusturun :isEnabled()
        3.https://the-internet.herokuapp.com/dynamic_controls adresinegidin.
        4.Textbox’in etkin olmadigini(enabled)dogrulayın
        5.Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        6.“It’s enabled!” mesajinin goruntulendiginidogrulayın.
        7.Textbox’in etkin oldugunu(enabled)dogrulayın
        */

    @Test
    public void EnableTest(){
        //        3.https://the-internet.herokuapp.com/dynamic_controls adresinegidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //        4.Textbox’in etkin olmadigini(enabled)dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//*[@type='text'][1]"));
        Assert.assertFalse(textBox.isEnabled());
        //        5.Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[@onclick='swapInput()'][1]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        //        6.“It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement eanbleWE = driver.findElement(By.xpath("//*[@id='message'][1]"));
        Assert.assertTrue(eanbleWE.isDisplayed());
        //        7.Textbox’in etkin oldugunu(enabled)dogrulayın
        Assert.assertTrue(textBox.isEnabled());
    }
}
