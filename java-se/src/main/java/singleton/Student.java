package singleton;

public class Student {
    private Student() {

    }

    private static Student student = null;

    public static Student getInstance() {
        if (student == null) {
            synchronized (Student.class) {
                if (student == null) {
                    student = new Student();
                }
            }
        }

        return student;
    }
}
