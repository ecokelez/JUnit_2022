package day13_readExcel_writeExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel{

    //- Dosya yolunu bir String degiskene atayalim
    //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //- WorkbookFactory.create(fileInputStream)
    //- Sheet objesi olusturun workbook.getSheetAt(index)
    //- Row objesi olusturun sheet.getRow(index)
    //- Cell objesi olusturun row.getCell(index)
    //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin

         /*=============================================
         Ara-->dosyaYolu
         Windows Gezgini ile ac-->FileInputStream
         Excel i ac-->Workbook
         Sayfa1 e git-->Sheet
         Satiri bul-->Row
         ====================================================*/

    @Test
    public void ReadExcelTest01() throws IOException, InterruptedException {
        //1- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //2- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); //Olusturdugumuz dosyayı sistemde isleme alır

        //3- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis); //Workbook obj. ile akısımıza aldıgımız dosyamızla
                                                        // bir excel dosyası create ettik

        //4- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet =workbook.getSheet("Sayfa1"); //Excel dosyamızda calısmak istedigimiz sayfayı
                                                    // bu sekilde seceriz

        //5- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3);    // ==> Sayfa 1 deki 3. satırı bu sekilde seceriz

        //6- Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3);  // Satır secimi yapıldıktan sonra hucre secimi bu sekilde yapılır
        System.out.println(cell);

        //7-  3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        Thread.sleep(1000);
        String expectedData = "Cezayir";
        String actualData = cell.toString();
        Assert.assertEquals(expectedData,actualData);
        Assert.assertEquals(expectedData,cell.getStringCellValue());




    }

}
