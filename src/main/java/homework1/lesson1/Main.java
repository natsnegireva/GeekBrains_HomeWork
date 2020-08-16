/*
package homework1.lesson1;

public class Main {
    public static void main(String[] args) {
        // создаем машину
        Car car = new Car("X5");
        // машина поехала
        car.run();
        // машина сломалась
        car.crash(40);
        // создаем сервисы
        CarServiceService serviceOne = new HandsHookService();
        CarServiceService serviceTwo = new CarColdService();

        // состояние машины заносим в темп
        int tmpIntegrity = car.getIntegrity();
        // говорим сервису - чинить машину
        serviceTwo.repare(car);
        // если полученное состояние - 100, если сервис стоит больше 7000
        // то возвращаем исходое значение состояния - good bye
        // или чиним
            if (car.getIntegrity() == 100) {
                if (serviceTwo.payCash() > 7000) {
                    car.setIntegrity(tmpIntegrity);
                    System.out.println("Good bye");
                } else {
                    System.out.println("OK I pay");
                }
            }
        // едем в другой сервис и так же проверяем
        serviceOne.repare(car);
        if (car.getIntegrity() == 100) {
            if (serviceOne.payCash() > 7000) {
                car.setIntegrity(tmpIntegrity);
                System.out.println("Good bye");
            } else {
                System.out.println("OK I pay");
            }
        }
    }
}
*/
