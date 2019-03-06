package geekbrains.Java1Lesson5;
/**
 * Java 1. HomeWork 5
 *
 * @author Balabkin Kirill
 * @version dated 28.01.2019
 */

public class Java1Lesson5 {

    public static void main(String[] args) {
        Person [] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "i​vivan@mailbox.com", "84615854", 20000, 20);
        persArray[1] = new Person("Nikolay Petrov", "Director", "nikolpet@gmail.com", "815686564", 50000, 50);
        persArray[2] = new Person("Elena Petrova", "Secretary", "elenapet@gmail.com", "815686484", 30000, 45);
        persArray[3] = new Person("Pavel Sidorov", "Security", "pavsid@gmail.com", "81564895", 25000, 29);
        persArray[4] = new Person("Vera Sidorova", "Booker", "vesid@gmail.com", "815684516", 30000, 31);

        for(int i = 0; i < persArray.length; i++){
            if(persArray[i].getAge() >= 40) persArray[i].getInfo();
        }
    }
}

