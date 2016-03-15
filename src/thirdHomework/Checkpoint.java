package thirdHomework;

public class Checkpoint {
    public void handleCar(Car car, CarProperties carProperties) {
       try {
           System.out.println("Приехал автомобиль: " + car);
           System.out.println(carProperties);
           if (car.isSpecialCar()) {
               System.out.println("это спецтранспорт");
               return;
           }
           if (carProperties.getSpeed() > 180) {
               throw new RuntimeException("Превышена скорость - вызов патруля");
           }
           PriceVisitor p  = new PriceVisitor();
           int price = car.acceptVisitor(p);
           if (carProperties.getSpeed() > 80){
               price += 1000;
           }
           System.out.println("Итоговая стоимость: " + price);
       }catch (Exception e){
           System.out.println("Произошла ошибка: " + e.getMessage());
       }

    }
}
