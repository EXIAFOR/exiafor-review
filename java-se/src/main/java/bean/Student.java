package bean;

public class Student extends Person {
    // 学号
    private Integer number;

    private String schoolName;

    public static void eat() {
        System.out.println(Student.class.getCanonicalName() + ".eat()...");
    }

    public static void learn(final String subject) {



    }
}
