package standard;

import java.util.Arrays;

public class For {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3, 4, 5};

        int[] array2 = array1.clone();

        System.out.println(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println(array2);
        System.out.println(Arrays.toString(array2));

//        for (int i = 0; i < array1.length / 2; ++i) {
//            int temp = array1[i];
//            array1[i] = array1[array1.length - i - 1];
//            array1[array1.length - 1 - i] = temp;
//        }

        System.out.println(Arrays.toString(array1));

        boolean isEquals = Arrays.equals(array1, array2);

        System.out.println("isEquals = " + isEquals);


        Arrays.fill(array2, 100);


        System.out.println();



    }
}
