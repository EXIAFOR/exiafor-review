package collection.list;

import org.junit.Test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author exiafor
 * @create 2021-12-14-22:31
 */
public class ArraysReview {
    @Test
    public void test1(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(str);
    }

    @Test
    public void test2() {
        Set set = new HashSet();
        set.add("123");
        set.add("456");
        set.add("789");

        System.out.println(set);

    }
}
