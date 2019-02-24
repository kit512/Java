package geekbrains.Java2Lesson3;

public class Massive {

    public void sumRepeatName(String [] massive) {
        for (int i = 0; i < massive.length; i++) {
            if (checkUniqueName(massive, massive[i], i))
                System.out.println(massive[i] + " repeat " + countRepeat(massive, massive[i]));
        }
    }

    public void uniqueName(String [] massive) {
        for (int i = 0; i < massive.length; i++) {
            if (checkUniqueName(massive, massive[i], i)) {
                System.out.println(massive[i]);
            }
        }
    }

    private static boolean checkUniqueName(String [] massive, String name, int position) {
        for (int i = 0; i < position; i++) {
            if (massive[i].equals(name)) {
                return false;
            }
        }
        return true;
    }

    private static int countRepeat(String [] massive, String name) {
        int count = 0;
        for (String s : massive) {
            if (s.equals(name)) {
                count++;
            }
        }
        return count;
    }
}
