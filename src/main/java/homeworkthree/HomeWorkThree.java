package homeworkthree;

import java.util.Scanner;

class HomeWorkThree {

    static Scanner scanner = new Scanner(System.in);
    static int range = 9;

    public static void main(String[] args) {
        ScanerTest(9);
        scanner.close();
    }

    // Задание 1: Написать метод, который загадывает случайное число от 0 до 9
    // пользователю дается 3 попытки угадать это число.
    // При каждой попытке сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
    // После победы или проигрыша выводится запрос – «Повторить игру еще раз?
    // 1 – да / 0 – нет»(1 – повторить, 0 – нет).

    static void ScanerTest(int range) {
        System.out.println("Введите число от 0 до " + range + ", у вас есть 3 попытки");
        int randomNumber = (int) (Math.random() * range); // сгенерирует случайное не отрицательное число до range
        for (int count = 0; count < 3; count++) {
            int input_number = scanner.nextInt();
            if (input_number == randomNumber) {
                System.out.println("Вы угадали!");
                System.out.println("Попробовать еще? Введите 1, если ДА или 0, если НЕТ");
                int input_number2 = scanner.nextInt();
                if (input_number2 == 1) {
                    ScanerTest(9);
                } else {
                    break;
                }
            } else if (input_number > randomNumber) {
                System.out.println("Ваше число больше, чем загаданное");
            } else if (input_number < randomNumber) {
                System.out.println("Ваше число меньше, чем загаданное");
            } else {
                System.out.println("Вы проиграли");
                System.out.println("Еще одна попытка? введите 1 – да или 0 – нет");
                int input_number2 = scanner.nextInt();
                if (input_number2 == 1) {
                    ScanerTest(9);
                } else {
                    break;
                }
            }
        }

    }
}






