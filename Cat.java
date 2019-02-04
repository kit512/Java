package geekbrains.Java1Lesson7;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public void eat(Plate p) {
        p.decreaseFood(appetite);
    }

    public void setSatiety() {
        satiety = true;
    }
    public boolean getSatiety() {
        return satiety;
    }

    public int getAppetite() {
        return appetite;
    }

    public void getInfo() {
        System.out.println(name + " eat " + appetite + ".");
    }

    public String getName() {
        return name;
    }
}
