package day14_readExcel_writeExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Homework_ReadExcel {

          /*
          1.satirdaki 2.hucreye gidelim ve yazdiralim
          1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
          2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
          Satir sayisini bulalim
          Fiziki olarak kullanilan satir sayisini bulun
          Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
           */

    @Test
    public void readExcelTest01() throws IOException {
        //          1.satirdaki 2.hucreye gidelim ve yazdiralim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int satir = 1;
        int sutun = 2;

        String actualData = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(actualData);

        //          1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String ikinciHucre = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(ikinciHucre);
        //          2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        satir = 2;
        sutun = 4;

        String expectedData = "Kabil";
                actualData = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();

        System.out.println(actualData);
        Assert.assertEquals(expectedData,actualData);

        //          Satir sayisini bulalim
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("Satir sayisi : " + sonSatir);

        //          Fiziki olarak kullanilan satir sayisini bulun
        int kullanilanSatir = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("Kullanilan satir sayisi  : " + kullanilanSatir);

        //          Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

    }

}
