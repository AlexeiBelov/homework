package thirdHomework;

public abstract class Car {
    private boolean specialCar;//признак спецтранспорта
    private int capacity;//грузоподъемность
    private int height;//высота


    public boolean isSpecialCar() {
        return specialCar;
    }

    public void setSpecialCar(boolean specialCar) {
        this.specialCar = specialCar;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract int acceptVisitor(PriceVisitor priceVisitor);

    @Override
    public String toString() {
        return "Автомобиль{" +
                "спецтранспорт = " + specialCar +
                ", грузоподъемность = " + capacity +
                ", высота = " + height +
                '}';
    }
}
