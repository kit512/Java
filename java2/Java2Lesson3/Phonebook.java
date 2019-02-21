package geekbrains.Java2Lesson3;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {

    List<Person> phonebook = new ArrayList<>();

    public void fillPhonebook() {
        Person person1 = new Person("Liam", 84564425);
        Person person2 = new Person("Emma", 51564685);
        Person person3 = new Person( "Ethan", 15415456);
        Person person4 = new Person("Charlotte", 94564655);
        Person person5 = new Person("Aiden",45646544);
        Person person6 = new Person("Jackson",15155898);
        Person person7 = new Person("Logan",15312555);
        Person person8 = new Person("Logan",55555555);
        Person person9 = new Person("Emma", 56456486);
        phonebook.add(person1);
        phonebook.add(person2);
        phonebook.add(person3);
        phonebook.add(person4);
        phonebook.add(person5);
        phonebook.add(person6);
        phonebook.add(person7);
        phonebook.add(person8);
        phonebook.add(person9);
    }

    public void addPerson(Person person) {
        phonebook.add(person);
    }


    public void findNumber(String name) {
        for (Person s: phonebook) {
            if (name.equals(s.getName())) {
                System.out.println(s.getName() + " " + s.getPhoneNumber());
            }
        }
    }

    public void printPhonebook () {
        for (Person person : phonebook) {
            System.out.println(person.getName() + " " + person.getPhoneNumber());
        }
    }
}
