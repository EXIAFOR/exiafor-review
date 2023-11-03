package cn.exiafor.test;

import java.util.Random;

public class FlowControl {
    public static void main(final String[] args) {
        outputRandomNumber();
    }

    private static void outputRandomNumber() {
        //noinspection InfiniteLoopStatement
        while (true) {
            int i = new Random().nextInt(10000);
            System.out.println("debug -- i : " + i);
            try {
                //noinspection BusyWait
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
