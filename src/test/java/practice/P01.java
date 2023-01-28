package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBase_BeforeAfter {
    /*
    go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    ikinci emojiye tıklayın (hayvan emojisini seçin)
    tüm hayvan emojilerine tıklayın
    formu doldurun (dilediğinizi yazabilirsiniz)
    apply butonuna tıklayın

     */

    @Test
    public void test01() {
        //   go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        //    ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement
                (By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        //    tüm hayvan emojilerine tıklayın
        List<WebElement> animalsWE = driver.findElements(By.xpath("//*[@class='mdl-tabs__panel is-active']//img"));
        animalsWE.stream().forEach(System.out::println);
        //animalsWE.stream().forEach(t->t.click());
         /*
         for (WebElement w:animalsWE) {
            w.click();
        }
        */

        driver.switchTo().defaultContent();

        //    formu doldurun (dilediğinizi yazabilirsiniz)
        List<WebElement> formList = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        //=>bu listi kullanarak her bir webelementi kolayca boxes listinde bulunan webelementlerimize gönderebileceğiz
        List<String> textWE = new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k"));
        for (int i = 0; i <formList.size() ; i++) {
            formList.get(i).sendKeys(textWE.get(i));
        }

        //    apply butonuna tıklayın
        driver.findElement(By.xpath("//button[@id='send']")).click();
    }
}
