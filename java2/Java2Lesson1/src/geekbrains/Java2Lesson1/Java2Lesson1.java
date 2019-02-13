package geekbrains.Java2Lesson1;
/**
 * Java 1. HomeWork 7
 *
 * @author Balabkin Kirill
 * @version dated 13.02.2019
 */
public class Java2Lesson1 {

    public static void main(String[] args) {

        Course course = new Course();
        Team team = new Team();
        team.addTeammates();
        course.doIt(team);
        team.showResults();
    }
}
