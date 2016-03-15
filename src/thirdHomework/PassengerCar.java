package thirdHomework;

public class PassengerCar extends Car {
    @Override
    public String toString() {
        return super.toString() + " это легковой автомобиль";
    }

    @Override
    public int acceptVisitor(PriceVisitor priceVisitor) {
        return priceVisitor.visit(this);
    }
}
