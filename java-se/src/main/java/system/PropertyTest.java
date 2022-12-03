package system;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class PropertyTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        Properties properties = System.getProperties();
//
//        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
//
//        List<String> strs = new ArrayList<>();
//
//        for (Map.Entry<Object, Object> entry : entries) {
//            strs.add(entry.getKey() + " --> " + entry.getValue());
//        }
//
//        for (String str : strs) {
//            if (str.contains("desk")) {
//                System.out.println(str);
//            }
//        }




        Scanner scanner = new Scanner(System.in,"UTF-8");

        String next = scanner.next();

        byte[] gbks = next.getBytes();// utf-8

        for (byte gbk : gbks) {
            System.out.println(gbk);
        }

        System.out.println("next --> " + next);

        String chinese = "汉字";
        byte[] bytes = chinese.getBytes();

        for (byte aByte : bytes) {
            System.out.println(aByte);
        }

        System.out.println(chinese);
    }
}
