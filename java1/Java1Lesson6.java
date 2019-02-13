/**
 * Java 1. HomeWork 6
 *
 * @author Balabkin Kirill
 * @version dated 01.02.2019
 */

public class Java1Lesson6 {

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Dog dog1 = new Dog();
        System.out.println("Cat run: " + cat1.run(150));
        System.out.println("Dog run: " + dog1.run(150));
        System.out.println("Cat jump: " + cat1.jump(2));
        System.out.println("Dog jump: " + dog1.jump(2));
        System.out.println("Cat swim: " + cat1.swim(10));
        System.out.println("Dog swim: " + dog1.swim(10));
    }
}

abstract class Animal {

    public abstract boolean swim(double a);
    public abstract boolean run(double a);
    public abstract boolean jump(double a);
}

class Cat extends Animal {
    @Override
    public boolean swim(double a) {
        return false;
    }

    @Override
    public boolean run(double a) {
        return a <= 200 + Math.random()*200;
    }

    @Override
    public boolean jump(double a) {
        return a <= 2 + Math.random()*2;
    }
}

class Dog extends Animal {
    @Override
    public boolean swim(double a) {
        return a <= 10 + Math.random()*5;
    }

    @Override
    public boolean run(double a) {
        return a <= 500 + Math.random()*250;
    }

    @Override
    public boolean jump(double a) {
        return a <= 0.5 + Math.random()*1;
    }
}