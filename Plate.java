package geekbrains.Java1Lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void getInfo() {
        System.out.println("Plate: " + food);
    }

    public int getFood() {
        return food;
    }

    public void setFood(int n) {
        System.out.println("Put in a plate " + n + " food.");
        food += n;
    }

}
