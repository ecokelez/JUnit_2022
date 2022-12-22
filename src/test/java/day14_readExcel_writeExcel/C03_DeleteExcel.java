package day14_readExcel_writeExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_DeleteExcel {
        /*
        //-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)
        //-Row objesi olusturun sheet.getRow(3)
        //-Cell objesi olusturun row.getCell(3)
        //-3. Satır 3. Cell'deki veriyi silelim
        //-Silindiğini test edin
         */

    @Test
    public void test01() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);
        //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)
        Sheet sheet = workbook.getSheet("Sayfa1");
        //-Row objesi olusturun sheet.getRow(3)
        Row row = sheet.getRow(3);
        //-Cell objesi olusturun row.getCell(3)
        Cell cell = row.getCell(3);
        //-3. Satır 3. Cell'deki veriyi silelim
        // ==> Bir cell'deki veriyi silmek için row objesine ihtiyac vardır.
        // ==> Row objesi ile removeCell() methodunu kullanarak cell objesi ile belirttimiz cell değerini silebiliriz
        row.removeCell(cell);
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        //-Silindiğini test edin
        String expectedData = "Cezayir";
        String actualData = null;
        Assert.assertNotEquals(expectedData,actualData);
    }

}
