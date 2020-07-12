package homeworkfive;

public class Staff {
    // ЗАДАНИЕ. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    public String fullName;
    public String position;
    public String email;
    public String phoneNumber;
    public double salary;
    public int age;

    // ЗАДАНИЕ. Конструктор класса должен заполнять эти поля при создании объекта.
    public Staff(String fullName, String position, String email, String phoneNumber, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;

    }

    // ЗАДАНИЕ. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    public void printStaff() {
        System.out.println("ФИО: " + fullName + ". Должность: " + position + ". E-mail: "
                + email + ". Телефон: " + phoneNumber + ". Заработная плата: " + salary + ". Возраст: " + age + ".");
    }

    public static void main(String[] args) {

    }

}






