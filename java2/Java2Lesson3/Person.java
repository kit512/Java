package geekbrains.Java2Lesson3;

public class Person {
    private String name;
    private int phoneNumber;

    public Person(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
