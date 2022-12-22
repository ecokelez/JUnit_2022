package day13_readExcel_writeExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void readExcelTest01() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); //Olusturdugumuz dosyayı sistemde isleme alır

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis); //Workbook obj. ile akısımıza aldıgımız dosyamızla
        // bir excel dosyası create ettik


        //- Sheet objesi olusturun workbook.getSheetAt(index)
        //- Row objesi olusturun sheet.getRow(index)
        //- Cell objesi olusturun row.getCell(index)

        String actualData = workbook
                            .getSheet("Sayfa1")
                            .getRow(3)
                            .getCell(3)
                            .toString();

        System.out.println(actualData);

    }
}
