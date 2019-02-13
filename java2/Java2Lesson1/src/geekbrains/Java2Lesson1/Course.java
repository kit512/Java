package geekbrains.Java2Lesson1;

public class Course implements Swiming, Running, Jumping {

    private int [] distanceCourse = new int[] {5,1500,150};

    public void doIt(Team t) {
        for (int i = 0; i < t.teammates.size(); i++) {
            if (jump(t.teammates.get(i).getMaxJumpValue())
                    && run(t.teammates.get(i).getMaxRunValue())
                    && swim(t.teammates.get(i).getMaxSwimValue())) {
            t.showWinner(t.teammates.get(i));
            }
        }
    }

    public boolean swim(int distanceSwim) {
        if (distanceSwim >= distanceCourse[2]) {
            return true;
        } else
            return false;
    }

    public boolean run(int distanceRun) {
        if (distanceRun >= distanceCourse[1]) {
            return true;
        } else
            return false;
    }

    public boolean jump(double distanceJump) {
        if (distanceJump >= distanceCourse[0]) {
            return true;
        } else
            return false;
    }
}
