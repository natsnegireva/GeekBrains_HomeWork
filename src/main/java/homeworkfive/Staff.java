package homeworkfive;

public class Staff {
    // ЗАДАНИЕ. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    public static String fullName;
    public static String position;
    public static String email;
    public static String phoneNumber;
    public static double salary;
    public static int age;

    // ЗАДАНИЕ. Конструктор класса должен заполнять эти поля при создании объекта.
    public Staff(String fullName, String position, String email, String phoneNumber, double salary, int age) {
        fullName = fullName;
        position = position;
        email = email;
        phoneNumber = phoneNumber;
        salary = salary;
        age = age;

    }
    // ЗАДАНИЕ. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    public static void printSt() {
        System.out.println("ФИО: " + fullName + ". Должность: " + position + ". E-mail: "
                + email + ". Телефон: " + phoneNumber + ". Заработная плата: " + salary + ". Возраст: " + age + ".");
    }

    public static void main(String[] args) {
        printSt(); // печатает dafault

    }
    // ЗАДАНИЕ. Создать массив из 5 сотрудников
    public static void personnelsList() {
        Staff[] arrPers = new Staff[5];
        arrPers[0] = new Staff("Иванов Денис Юрьевич", "Монтажник утановок", "idyu@mail.ru", "+79567765300", 35000, 42);
        arrPers[1] = new Staff("Асачий Александр Матвеевич", "Сборщик", "aam@mail.ru", "+79164560023", 25000, 45);
        arrPers[2] = new Staff("Филипов Сергей Львович", "Сортировщик", "fsu@mail.ru", "+72873569823", 28000, 25);
        arrPers[3] = new Staff("Навалый Сергей Дмитриевич", "Электрик", "nsd@mail.ru", "+79872340900", 38000, 22);
        arrPers[4] = new Staff("Макаров Максим Максимович", "Наладчик конвеера", "mmm@mail.ru", "+73848848409", 39000, 59);

        // С помощью цикла вывести информацию только о сотрудниках старше 40 лет
        // НАВЕРНОЕ КАК-ТО ТАК
//        for (int i = 0; i < arrPers.length; i++) {
//            if (age < 40) {
//                System.out.println();
//            }
//        }
//        // ИЛИ КАК-ТО ТАК
//        for (int i = 0; i < arrPers.length; i++) {
//            for (int j = 0; j < 6; j++) {
//            if (arrPers[i][6] < 40) {
//                System.out.println();
//            }
//        }
   }
}






