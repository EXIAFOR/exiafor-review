package singleton;

public class Person {
    private Person() {

    }

    private static Person person = new Person();

    public static Person getInstance() {
        return person;
    }
}
