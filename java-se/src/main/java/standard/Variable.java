package standard;

public class Variable {
    public static void main(String[] args) {
        int i2, j2;
        //连续赋值
        i2 = j2 = 10;
        //***************
        int i3 = 10, j3 = 20;
        int num1 = 10;
        num1 += 2;//num1 = num1 + 2;
        System.out.println(num1);//12

        int num2 = 12;
        num2 %= 5;//num2 = num2 % 5;
        System.out.println(num2);

        short s1 = 10;
//        s1 = (short) (s1 + 2);//编译失败
        s1 += 2;//结论：不会改变变量本身的数据类型
        System.out.println(s1);
    }
}
