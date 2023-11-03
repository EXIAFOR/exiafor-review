package cn.exiafor.skzy.userlog.bean;

import java.util.ArrayList;

public class UserTable {
    private static final ArrayList<User> list = new ArrayList<>();

    static {
        list.add(new User("Tom","123","tom@qq.com","001"));
        list.add(new User("Jerry","123","jerry@qq.com","002"));
    }

    public static void addUser(User user){
        list.add(user);
        System.out.println("--> 输出 list 开始");
        list.forEach(System.out::println);
        System.out.println("--> 输出 list 结束");
    }
}
