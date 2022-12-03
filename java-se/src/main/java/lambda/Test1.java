package lambda;

import org.junit.Test;

public class Test1 {
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("1 --> 北京天安门");
            }
        };

        r1.run();

        System.out.println("*********************");

        Runnable r2 = () -> System.out.println("2 --> 北京天安门");
        r2.run();
    }
}
