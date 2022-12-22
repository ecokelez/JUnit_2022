package day13_readExcel_writeExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C08_ReadExcel {

    @Test
    public void readExcelTest01() throws IOException {
        //==>Excel dosyasindaki tum verileri classimiza alip bir Java obj. store edelim,
        // boylece her seferinde Excel'e ulasip satir sutun vs.. ugrasmayalim
        //==>Database yapısında olan Excel'i koyabilecegimiz en uygun Java obj. Map'tir


        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);

        Map<String,String> ulkelerMap = new HashMap<>();

        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i <sonSatirIndex ; i++) {
                String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

                String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+","+
                        workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+","+
                        workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

                ulkelerMap.put(key,value);
            System.out.println(key + "," + value);
        }

        System.out.println(ulkelerMap);

        //Listede Switzerlandold. test edelim

        Assert.assertTrue(ulkelerMap.keySet().contains("Switzerland"));
    }
}
