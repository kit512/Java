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
        if (!getSatiety()) {
            satiety = p.decreaseFood(appetite);
        }
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public boolean getSatiety() {
        return satiety;
    }

    public int getAppetite() {
        return appetite;
    }

    public String getInfo(Plate p) {
        if (getAppetite() < p.getFood()) {
            return name + " eat " + appetite + ".";
        } else {
            return name + " don't eat, because not enough food.";
        }
    }

    public String getName() {
        return name;
    }
}
