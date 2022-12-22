package day10_fakerClass_fileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeAfter;

public class C02_ActionsClasswork extends TestBase_BeforeAfter {
    /*
    1-Bir Class olusturalim KeyboardActions2
    2-https://html.com/tags/iframe/ sayfasina gidelim
    3-video’yu gorecek kadar asagiinin
    4-videoyu izlemek icin Play tusunabasin
    5-videoyu calistirdiginizi testedin
     */

    @Test
    public void test01() throws InterruptedException {
        //    1-Bir Class olusturalim KeyboardActions2
        //    2-https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //    3-video’yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        //    4- videoyu izlemek icin Play tusunabasin
        WebElement iFrame = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc'][1]"));
        driver.switchTo().frame(iFrame);
        WebElement playButton =
                driver.findElement(By.xpath("//*[@aria-label='Oynat'][1]"));
        playButton.click();

        //    5-videoyu calistirdiginizi test edin
        Thread.sleep(3000);
        WebElement videoLink = driver.findElement(By.xpath("//*[@class='ytp-title-link yt-uix-sessionlink'][1]"));
        Assert.assertTrue("YouTube videosu calistirildi", videoLink.isDisplayed());
    }
}
