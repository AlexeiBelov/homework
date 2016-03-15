package thirdHomework;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Checkpoint checkpoint = new Checkpoint();
        for (int i = 0; i < 10; i++) {
            Car car = makeNewCar();
            CarProperties carProperties = makeCarProperties(car);
            checkpoint.handleCar(car, carProperties);
        }
    }

    private static CarProperties makeCarProperties(Car car) {
        CarProperties carProperties = new CarProperties();
        carProperties.setWeight(ThreadLocalRandom.current().nextInt(car.getCapacity()));
        carProperties.setSpeed(ThreadLocalRandom.current().nextInt(200));
        return carProperties;
    }

    private static Car makeNewCar() {
        return ThreadLocalRandom.current().nextBoolean() ? makeNewPassengerCar() : makeNewTruck();
    }

    private static Car makeNewTruck() {
        Truck truck = new Truck();
        truck.setSpecialCar(ThreadLocalRandom.current().nextBoolean());
        truck.setCapacity(15000);
        truck.setHeight(ThreadLocalRandom.current().nextInt(1, 6));
        truck.setTrailer(ThreadLocalRandom.current().nextBoolean());
        return truck;
    }

    private static Car makeNewPassengerCar() {
        PassengerCar car = new PassengerCar();
        car.setSpecialCar(ThreadLocalRandom.current().nextBoolean());
        car.setCapacity(2000);
        car.setHeight(ThreadLocalRandom.current().nextInt(1, 3));

        return car;
    }
}
