package day09_testBaseClass_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeAfter;

public class C04_Actions extends TestBase_BeforeAfter {

    /*
    Yeni bir class olusturalim: MouseActions2
    1-https://demoqa.com/droppable adresinegidelim
    2-“Drag me” butonunu tutup “Drop here” kutusunun ustunebirakalim
    3-“Drop here” yazisi yerine “Dropped!” oldugunu testedin
     */

    @Test
    public void test01(){
        //    1-https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //    2-“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement tasınacakWE = driver.findElement(By.xpath("//*[@id='draggable'][1]"));
        WebElement dropHereWE = driver.findElement(By.xpath("//*[@id='droppable'][1]"));
        actions.dragAndDrop(tasınacakWE,dropHereWE).perform();

        //    3-“Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement sonucWE = driver.findElement(By.xpath("//*[text()='Dropped!'][1]"));
        String expectedYazi = "Dropped!";
        String actualYazi = sonucWE.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

    }
}
