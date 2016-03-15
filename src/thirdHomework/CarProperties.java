package thirdHomework;

public class CarProperties {
    private int weight;//вес
    private int speed;//скорость

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Текущее состояние авто{" +
                "вес = " + weight +
                ", скорость = " + speed +
                '}';
    }
}
