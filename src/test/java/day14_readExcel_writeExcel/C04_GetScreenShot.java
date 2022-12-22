package day14_readExcel_writeExcel;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase_BeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShot extends TestBase_BeforeAfter {
    @Test
    public void test01() throws IOException {
        //Amazon sayfasına gidip tum sayfanın resmini alalım
        driver.get("https://www.mercedes-benz.com.tr");

        //==>Bir web sayfanın resmini alabilmek için TakesScreenshot class'ın obje olus.,
        //==>Geçici bir File class'ından değişkene TakesScreenShot'dan oluşturduğum obje'den
        //==> getScreenShotAs methonu kullanarak geçici bir file oluştururuz

        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSyfResim = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSyfResim,new File("target/ekranGoruntusu/allPage"+tarih+".jpeg"));

        /*
    NOT : => resmi resmin uzerine degil de yeni bir resim olarak alabilmek icin image ismine tarih ekleyip atadik
    =>tarih in normal formati dosya isimlendirmeye uygun olmadigi icin tarih yazim formati ile oynayip
    => uygun hale getirdik ==> sonra bu sekil bize her zaman lazim olabilir diye TestDataBase imize attik
        */

    }
}
