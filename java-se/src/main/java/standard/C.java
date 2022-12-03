package standard;

import bean.Season;

import java.util.Arrays;
import java.util.List;

public class C {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());//2


        System.out.println();
    }
}
