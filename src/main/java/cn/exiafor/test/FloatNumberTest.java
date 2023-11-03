package cn.exiafor.test;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FloatNumberTest {
    public static void main(final String[] args) {
        inputIntegerNumber();
//        intForceCastToShort();
//        bitCalculate();
//        test1();
//        floatResultPrecision();
    }

    private static void floatResultPrecision() {
        System.out.println("debug -- f : " + (0.1 + 0.2));
    }

    private static void test1() {
        int i = 0;
        i = i++;

        System.out.println("debug -- i : " + i);
    }

    private static void bitCalculate() {
        int i = 2;
        i = i << 3;

        System.out.println("debug -- i : " + i);
    }

    private static void intForceCastToShort() {
        int i = 2032432432;
        short s = (short) i;

        System.out.println("debug -- s : " + s);

        i = 32770;
        s = (short) i;
        System.out.println("debug -- s : " + s);
    }

    private static void inputIntegerNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("--> 请输入任意长度的整数值\n--> ");
        BigDecimal bigDecimal;

        while (true) {
            try {
                bigDecimal = scanner.nextBigDecimal();
                break;
            } catch (InputMismatchException e) {
                System.out.print("--> 输入的数据类型有误，请重新输入\n--> ");
                scanner.nextLine();
            }
        }

        System.out.println("--> 输入的数据值为 : " + bigDecimal);
        scanner.close();
    }
}
