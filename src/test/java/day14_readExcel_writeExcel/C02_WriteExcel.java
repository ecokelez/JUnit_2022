package day14_readExcel_writeExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
        /*
        1)Yeni bir Class olusturalimWriteExcel
        2)Yeni bir test method olusturalim writeExcelTest()
        3)Adimlari takip ederek 1.satira kadargidelim
        4)5.hucreye yeni bir cellolusturalim
        5)Olusturdugumuz hucreye “Nufus”yazdiralim
        6)2.satir nufus kolonuna 1500000yazdiralim
        7)10.satir nufus kolonuna 250000yazdiralim
        8)15.satir nufus kolonuna 54000yazdiralim
        9)Dosyayi kaydedelim 10)Dosyayikapatalim
        */

    @Test
    public void writeExcelTest01() throws IOException {

        //        3)Adimlari takip ederek 1.satira kadargidelim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        //        4) 5.hucreye yeni bir cell olusturalim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        //        5)Olusturdugumuz hucreye “Nufus”yazdiralim
        //        6)2.satir nufus kolonuna 1500000yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(1500000);
        //        7)10.satir nufus kolonuna 250000yazdiralim
        workbook .getSheet("Sayfa1").getRow(9).getCell(4).setCellValue(250000);
        //        8)15.satir nufus kolonuna 54000yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).getCell(4).setCellValue("54000");
        //        9)Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        //==> Excel dosyamıza veri girişi yaptıktan sonra dosyayı akışa aldığımız gibi sonlandırmamız gerekir.
        //==> Sonrasında da workbook objemize kayıt etmemiz gerekir

        workbook.write(fos); //==> Write methodu ile sonlandırdığımız işlemi workbook'a yazdırdık

        //        10)Dosyayikapatalim
        fis.close();
        fos.close();
        workbook.close();


    }
}
