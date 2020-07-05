package homeworkthree;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkThreeAdd {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GuessWord();
        scanner.close();

    }

    // Задание 2:  Создать массив из слов При запуске программы компьютер загадывает слово,
    // запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает правильно ли
    // ответил пользователь. Играем до тех пор, пока игрок не отгадает слово.
    // Вариант 1
    public static void GuessWord() {
        String[] WordsArr = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
                "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};
        Random random = new Random();
        int randomWord = random.nextInt(WordsArr.length);
        String str = WordsArr[randomWord];
        char result = str.charAt(0);
        char result1 = str.charAt(1);
        System.out.println("Угадайте слово " + result + " " + result1 + " #############");

        while (true) {
            String inputWord = scanner.next();
            if (str.equals(inputWord)) {
                System.out.println("Вы угадали. Сыграем еще!");
                GuessWord();
            } else {
                System.out.println("Вы не угадали. ");
            }
        }
    }
      // Вариант 2
      // Если слово не угадано, компьютер показывает буквы которые стоят на своих местах

//    public static void GuessWord() {
//        String[] WordsArr = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
//                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
//                "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
//                "pumpkin", "potato"};
//        Random random = new Random();
//        int randomWord = random.nextInt(WordsArr.length);
//        String str = WordsArr[randomWord];
//        char result = str.charAt(0);
//        char result1 = str.charAt(1);
//        System.out.println("Угадайте слово " + result + " " + result1 + " #############");
//
//        String inputWord = scanner.next();
//            if (str.equals(inputWord)) {
//                System.out.println("Вы угадали. ");
//                GuessWord();
//            } else {
//                System.out.println("Вы не угадали. ");
//                System.out.println("Загаданное слово " + str);
//            }
//
//    }
}

