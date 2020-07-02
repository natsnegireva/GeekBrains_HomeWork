package homeworkone;
public class HomeWorkOne {
    // Задание 2 : Создать переменные всех пройденных типов данных, и инициализировать их значения
    static byte m = 1;
    static short y = 2;
    static int n = 3;
    static long l = 12345678910L;
    static float f = 4.5f;
    static double z = 6.78;
    static char x = 'A';
    static boolean bool = true;
    String s = "Максим";

    public static void main(String[] args) {
        System.out.println("Задание 3 - " + calc(14, 11, 12, 13));
        diap(4, 7);
        comp(-9);
        min(-10);
        str("Максим");
        ves(2019);

    }

    // Задание 3 : вычислить выражение a * (b + (c / d)) и вернуть результат
    static int calc(int a, int b, int c, int d) {
        return a * (b + c / d);
    }

    // Задание 4 : если сумма лежит в пределах от 10 до 20(включительно) - вернуть true, в противном случае – false
    // public boolean isSumInRange (int g, int r) {
    //    int sum = g + r;
    //    return sum >= 10 && sum <+ 20;
    // }
    static void diap(int g, int r) {
        if ((g + r) >= 10 && (g + r) <= 20) {
            System.out.println("Задание 4 - true");
        } else {
            System.out.println("Задание 4 - false");
        }
    }

    // Задание 5 : напечатать в консоль положительное число или отрицательное
    // if (h > -1) вариант
    static void comp(int h) {
        if (h >= 0) {
            System.out.println("Задание 5 - Число положительное");
        } else {
            System.out.println("Задание 5 - Число отрицательное");
        }
    }

    // Задание 6 : если отрицательное число - вернуть true
    // public boolean min (int k) {
    //    return k < 0;
    //}
    static void min(int k) {
        if (k < 0) {
            System.out.println("Задание 6 - true");
        }
    }


    // Задание 7 : метод должен вывести в консоль сообщение «Привет, указанное_имя!»
    static void str(String s) {
        System.out.println("Задание 7 - Привет, " + s + "!");
    }

    // Задание 8 : метод определяет является ли год високосным, и выводит сообщение в консоль
    // if (w % 400 == 0 || (w % 100 != 0 && w % 4 == 0)) вариант
    static void ves(int w) {
        if (w % 4 == 0 && w % 100 != 0 || w % 400 == 0) {
            System.out.println("Задание 8 - Год " + w + " является високосным");
        } else {
            System.out.println("Задание 8 - Год " + w + " является не високосным");
        }
    }
}