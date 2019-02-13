package geekbrains.Java1Lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if ( food < n ) {
            return false;
        }
        food -= n;
        return true;
    }

    public String getInfo() {
        return "Plate: " + food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int n) {
        System.out.println("Put in a plate " + n + " food.");
        food += n;
    }

}
