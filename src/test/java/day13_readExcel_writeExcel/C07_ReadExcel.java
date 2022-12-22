package day13_readExcel_writeExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C07_ReadExcel {

    @Test
    public void readExcelTest01() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);
        //İngilizce baskentler sutununu yazdiralim

        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatir);

        String ingilizceBaskentler = "";

        for (int i = 0; i <=sonSatir ; i++) {
            ingilizceBaskentler = C06_ReadExcel.banaDataGetir(i,1);
            System.out.println(ingilizceBaskentler);
        }

    }
}
