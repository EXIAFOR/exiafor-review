package cn.exiafor.bean;

public class User {
    String name;
    int age;

    Pet pet;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
