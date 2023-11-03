import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author exiafor
 * @create 2021-12-14-22:31
 */
public class ArraysReviewTest {
    public void test1(){
        String[] strs = new String[]{"153135","561651","515153"};
        for (String str : strs) {
            System.out.println(str);
        }
    }

    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("789");
        list.add("abc");
        list.add("def");
        list.add("ghi");

        System.out.println(list.contains("123"));

        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());

        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));

        for (Object object : objects) {
            System.out.println(object);
        }


//        Collection coll = new ArrayList();
    }

    public void test3(){
        List<String> list = Arrays.asList(new String[]{"abc", "def", "ghi"});
        System.out.println(list);

        System.out.println(list.size());
    }
}
