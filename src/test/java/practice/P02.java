package practice;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P02 {
    
        //Verify that we have pom.xml file in our project => please try in 4 min s


    @Test
    public void test01() {
        String path = "C:\\SeleniumBatch81\\com.Batch81JUnit_01\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(path)));
    }
}
