package homework1.lesson1;

public interface  CarServiceService {
    // отвечает за то, что делают все сервисы

    boolean toTrash (Car car); // проверяем состояние машины
    Car repare (Car car); // возвращаем машину после ремонта
    int payCash(); // возвращаем стоимость ремонта
}
