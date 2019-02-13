package geekbrains.Java2Lesson1;


import java.util.ArrayList;
import java.util.List;

public class Team {

    private String teamName = "V - Victory";
    List<Person> teammates = new ArrayList<>();
    Person person1 = new Person("Vasya", 4.5, 1500, 90);
    Person person2 = new Person("Petya", 6.8, 3000, 200);
    Person person3 = new Person("Grisha", 5.2, 2700, 150);
    Person person4 = new Person("Nastya", 4.7, 1700, 80);

    public void addTeammates() {
        teammates.add(person1);
        teammates.add(person2);
        teammates.add(person3);
        teammates.add(person4);
    }

    public void showResults() {
        System.out.println("Team \t" + teamName + ":");
        for (Person p : teammates) {
            System.out.println(p.getName() + "\t jump:"
                    + p.getMaxJumpValue() +  "\t run:"
                    + p.getMaxRunValue() + "\t swim:"
                    + p.getMaxSwimValue());
        }
    }

    public void showWinner(Person p) {
        System.out.println(p.getName() + " complected all course");
    }
}
