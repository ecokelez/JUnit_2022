package day13_readExcel_writeExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel {
    /*
        //-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        //-Turkce baskentler sutununu yazdiralim
     */

    @Test
    public void readExcelTest01() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //-Turkce baskentler sutununu yazdiralim
        //==> getLastRowNum() methodu bize excel syf.daki tun satir num. verir.
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatir);

        String turkceBaskentler = "";

        for (int i = 0; i <= sonSatir; i++) {
            turkceBaskentler = workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(turkceBaskentler);
        }
    }

}
