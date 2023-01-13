package automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeAfter;

public class C06_ContactUsFrom extends TestBase_BeforeAfter {
        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Contact Us' button
        5. Verify 'GET IN TOUCH' is visible
        6. Enter name, email, subject and message
        7. Upload file
        8. Click 'Submit' button
        9. Click OK button
        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        11. Click 'Home' button and verify that landed to home page successfully
         */

    @Test
    public void test01() {
        Actions actions = new Actions(driver);
        //        1. Launch browser
        //        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //        3. Verify that home page is visible successfully
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com"));
        //        4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();
        //        5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouchWE = driver.findElement(By.xpath("//*[@class='title text-center'][1]"));
        Assert.assertTrue(getInTouchWE.isDisplayed());
        //        6. Enter name, email, subject and message

        WebElement emailWE = driver.findElement(By.xpath("//*[@class='form-control'][1]"));
        actions.click(emailWE).sendKeys("Ali").sendKeys(Keys.TAB).
                sendKeys("e067@gmail.com").sendKeys(Keys.TAB).
                sendKeys("Selenium").sendKeys(Keys.TAB).
                sendKeys("Never Give Up").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //        7. Upload file
        String dosyaYolu = "C:\\Users\\win8\\java_error_in_idea64_56024.log";
        WebElement uploadWE = driver.findElement(By.xpath("//*[@name='upload_file']"));
        uploadWE.sendKeys(dosyaYolu);
        //        8. Click 'Submit' button
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        //        9. Click OK button
        driver.switchTo().alert().accept();
        //        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement messageWE = driver.findElement(By.xpath("//*[@class='status alert alert-success']"));
       Assert.assertTrue(messageWE.isDisplayed());
        //        11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//*[@class='fa fa-angle-double-left']")).click();
        WebElement autoLogoWE = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(autoLogoWE.isDisplayed());

        /*
        ================================ NOT: ======================================
    Bir web sitesine girdiğimizde karşımıza bir uyarı mesayı yada bir buttona tıkladığımızda bir uyarı(alert)
    çıkabilir. Eğer bu uyarıya incele(mause sağ tik-inspect) yapabiliyorsak bu tür alert'lere HTML alert denir
    ve istediğimiz locate'i alabiliriz. Ama gelen uyarı kutusuna müdehale(Sağ tik-incele) edemiyorsak bu tür
    alert'lere js alert denir. js alert'lere müdehale edebilmek için
    - tamam yada ok için driver.switchTo().alert().accept() kullanılır
    - iptal için driver.switchTo().alert().dismiss() methodu kullanılır
    - Alert içindeki mesajı almak için driver.switchTo().alert().getText() kullanılır
    - Alert bizden bir metin istiyorsa driver.switchTo().alert().sendKeys("") kullanılır
     */
    /*
        ● accept() => Bir uyarıda(alert) OK'ı tıklamakla aynı.
              driver.switchTo().alert().accept();
        ● dismiss() => Bir uyarıda(alert) Cancel'ı tıklamakla aynı.
            driver.switchTo().alert().dismiss();
        ●getText() => Uyarıdaki(alert) mesajı almak için.
            driver.switchTo().alert().getText();
        ●sendKeys(“Text”) => Uyarı(alert) text kutusuna text göndermek için
            driver.switchTo().alert().sendKeys("Text");
        */

    }
}
