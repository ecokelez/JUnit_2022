package day10_fakerClass_fileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir"));
        //icinde bulunulan klasörün yolunu (Path)verir ==>C:\SeleniumBatch81\com.Batch81JUnit_01

        System.out.println(System.getProperty("user.home"));
        //bilgisayarimizda bulunan user klasörünü verir
        // //Gecerli kullanıcının ana dizinini verir ==> C:\Users\win8

        String farlıBolum = System.getProperty("user.home");
        //C:\Users\win8\Desktop\Selenium.txt -> Masa usutndeki Slenium dosya. yolu
        String ortakBolum = "\\Desktop\\Selenium.txt";

        String masaustuDosyaYolu = farlıBolum + ortakBolum; //Masa ustundeki dosya yolu
        System.out.println(masaustuDosyaYolu);
        System.out.println(Files.exists(Paths.get(masaustuDosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));



        //Masa usutundeki text dosyasının varlıgını test edelim
        String filePath = "C:\\Users\\win8\\Desktop\\Selenium.txt";
        System.out.println(Files.exists(Paths.get(filePath)));
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

        /*
        ==> Bir web sitesinden indirdiğimiz yada windows içinde oluşturduğumuz dosyanın indiğini
        yada orda olduğunu test edebilmek için ;
        ==> o dosyanın üzerine shift tuşuna basılı olarak sağ klik yapıp dosyanın yolunu kopyalayıp
        bir string değişkene atarız ve dosyayı doğrulamak için ;
        ==> Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); bu methodu kullanırız
         */
    }

}
