package homework1.lesson1;

public class CarColdService implements CarServiceService {
// переопредляет методы из CarServiceService

    @Override
    public boolean toTrash(Car car) { // проверяет, если соточние машины 50 - то чинить
        if (car.getIntegrity() < 50) {
            return false;
        }
        return true;
    }

    @Override
    public Car repare (Car car) { // делает, если состояние машины 100 - то починена
        if (!toTrash(car)) {
            car.setIntegrity(100);
            payCash();
        }
        return car;
    }

    @Override
    public int payCash() { // отвечает - заплатите 1000
        return 1000;
    }
}
