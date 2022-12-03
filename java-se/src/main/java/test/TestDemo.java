package test;

import org.junit.Test;

import java.io.File;

public class TestDemo {
    @Test
    public void test1() {
        File file = new File("D:" + File.separator + "75987" + ".png");


        System.out.println(file.getAbsoluteFile());


        System.out.println(file.length());
    }
}
