package homeworkfive;

public class Main {

    public static void main(String[] args) {

        // создание нового обьекта в классе Main
        Staff personel = new Staff("Селезнев Тимур Максимович",
                "грузчик 4 разряда", "grip@mail.ru",
                "+79109765385", 30000, 35);
        System.out.println(personel); // печатает ссылку на память

    }
}

