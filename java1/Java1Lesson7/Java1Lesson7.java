package geekbrains.Java1Lesson7;
/**
 * Java 1. HomeWork 7
 *
 * @author Balabkin Kirill
 * @version dated 04.02.2019
 */
public class Java1Lesson7 {

    public static void main(String[] args) {

        Plate plate = new Plate(100);

        Cat [] cats = new Cat[6];
        cats[0] = new Cat("Barsik", 20);
        cats[1] = new Cat("Tom", 15);
        cats[2] = new Cat("Genri", 12);
        cats[3] = new Cat("Murzik", 6);
        cats[4] = new Cat("Vas'ka", 30);
        cats[5] = new Cat("Grif", 25);

        for (Cat cat : cats) {
            System.out.println(cat.getInfo(plate));
            cat.eat(plate);
            System.out.println(cat.getName() + " satiety: " + cat.getSatiety());
            System.out.println(plate.getInfo());
            System.out.println();
        }

        System.out.println(plate.getInfo());
        plate.setFood(200);
        System.out.println();

        for (Cat cat : cats) {
            cat.setSatiety(false);
            System.out.println(cat.getInfo(plate));
            cat.eat(plate);
            System.out.println(cat.getName() + " satiety: " + cat.getSatiety());
            System.out.println(plate.getInfo());
            System.out.println();
        }
    }
}

