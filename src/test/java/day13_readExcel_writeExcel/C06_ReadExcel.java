package day13_readExcel_writeExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C06_ReadExcel {
    /*
    ==>Input olark verilen satirNo,sutunNo degerlerni paeametre olarak alip,
    o celldeki datayı String olarak donduren bir method olusturun,
    ==> donen String'in Cezayir old. test edin
     */

    @Test
    public void readExcelTest01() throws IOException {
        int satirNo = 18;
        int sutunNo = 4;

        String expecteData = "Brüksel";

        String actualData = banaDataGetir(satirNo-1,sutunNo-1);

        Assert.assertEquals(expecteData,actualData);
    }

    public static  String  banaDataGetir(int satirIndex,int sutunIndex) throws IOException {
        String istenenData = "";
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        istenenData = workbook
                .getSheet("Sayfa1")
                .getRow(satirIndex)
                .getCell(sutunIndex)
                .toString();


        return istenenData;
    }
}
