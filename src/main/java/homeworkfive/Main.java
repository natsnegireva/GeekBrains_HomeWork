package homeworkfive;

public class Main {

    public static void main(String[] args) {

        // ЗАДАНИЕ. Создать массив из 5 сотрудников
        Staff[] personal = new Staff[5];
        personal[0] = new Staff("Иванов Денис Юрьевич", "Монтажник утановок", "idyu@mail.ru", "+79567765300", 35000, 42);
        personal[1] = new Staff("Асачий Александр Матвеевич", "Сборщик", "aam@mail.ru", "+79164560023", 25000, 45);
        personal[2] = new Staff("Филипов Сергей Львович", "Сортировщик", "fsu@mail.ru", "+72873569823", 28000, 25);
        personal[3] = new Staff("Навалый Сергей Дмитриевич", "Электрик", "nsd@mail.ru", "+79872340900", 38000, 22);
        personal[4] = new Staff("Макаров Максим Максимович", "Наладчик конвеера", "mmm@mail.ru", "+73848848409", 39000, 59);

        // С помощью цикла вывести информацию только о сотрудниках старше 40 лет
        for (int i = 0; i < personal.length; i++) {
            if (personal[i].age > 40){
                System.out.println(personal[i].fullName);
            }
        }
    }
}

