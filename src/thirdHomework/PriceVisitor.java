package thirdHomework;

public class PriceVisitor {
    public int visit(Truck truck) {
        if (truck.getHeight() > 4) {
            throw new RuntimeException("Превышена высота грузовика.");
        }
        int result = truck.isTrailer() ? 2000 : 500;
        if (truck.getCapacity() > 10000){
            result += 800;
        }
        return result;
    }

    public int visit(PassengerCar passengerCar) {
        return 1000;
    }
}
