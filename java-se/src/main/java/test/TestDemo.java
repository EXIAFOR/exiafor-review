package test;


import java.io.File;

public class TestDemo {
    public void test1() {
        File file = new File("D:" + File.separator + "75987" + ".png");


        System.out.println(file.getAbsoluteFile());


        System.out.println(file.length());
    }
}
