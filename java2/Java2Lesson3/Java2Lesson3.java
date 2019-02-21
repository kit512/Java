package geekbrains.Java2Lesson3;

public class Java2Lesson3 {

    public static void main(String[] args) {

        //17 всего, 13 уникальных
        String [] name = new String[] { "Liam",	"Emma","Logan","Olivia", "Emma",
                "Ethan", "Sophia", "Logan",	"Isabella", "Lucas",
                "Mia", "Jackson", "Emma",	"Charlotte", "Aiden",
                "Logan",	"Amelia"};
        Massive massive = new Massive();

        System.out.println("Task 1");
        System.out.println("Массив состоит из следующих имен:");
        massive.sumRepeatName(name);
        System.out.println("В массиве содержатся следующие уникальные имена:");
        massive.uniqueName(name);
        System.out.println();
        System.out.println("Task 2");
        Phonebook phonebook = new Phonebook();
        phonebook.fillPhonebook();
        System.out.println("Поиск по именам");
        phonebook.findNumber("Jackson");
        phonebook.findNumber("Emma");
        System.out.println("Вывод всей книги после добавления элемента");
        Person newperson = new Person("Charlotte", 77777777);
        phonebook.addPerson(newperson);
        phonebook.printPhonebook();

    }
}
