package geekbrains.Java2Lesson1;

public class Person {

    private String name;
    private double maxJumpValue;
    private int maxRunValue;
    private int maxSwimValue;

    public Person(String name, double maxJumpValue, int maxRunValue, int maxSwimValue) {
        this.name = name;
        this.maxJumpValue = maxJumpValue;
        this.maxRunValue = maxRunValue;
        this.maxSwimValue = maxSwimValue;
    }

    public String getName() {
        return name;
    }

    public double getMaxJumpValue() {
        return maxJumpValue;
    }

    public int getMaxRunValue() {
        return maxRunValue;
    }

    public int getMaxSwimValue() {
        return maxSwimValue;
    }
}
