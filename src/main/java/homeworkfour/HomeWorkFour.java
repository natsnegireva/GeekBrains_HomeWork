package homeworkfour;

import java.util.Scanner;

class HomeWorkFour {


    public static Scanner sc = new Scanner(System.in);
    public static char[][] map;
    public final static int SIZE = 5; // заданная константа длинна массива
    public final static int DOT_TO_WIN = 4; // точка победы

    public final static char DOT_X = 'X'; // заданная константа
    public final static char DOT_O = 'O'; // заданная константа
    public final static char EMPTY_DOT = '•'; // заданная константа

    public static void main(String[] args) {
        initMap(); // создаем карту
        printMap(); // печатаем карту
        while (true) {
            humanTurn(); // ход игрока
            printMap(); // печатаем карту
            if (isWin(DOT_X)) { // если сложилась победа для Х
                System.out.println("YOU WIN!");
                break;
            }
            if (isMapFull()) { // если все заполнено но победы нет
                System.out.println("Game ended in draw");
                break;
            }
            aITurn(); // ход компьютера
            printMap(); // печатаем карту
            if (isWin(DOT_O)) { // если сложилась победа для Y
                System.out.println("YOU LOSE(((((((!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Game ended in draw");
                break;
            }
        }
    }

    private static boolean isMapFull() {
        int count = 0; // количество проверок есть ли точки
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == EMPTY_DOT) {
                    count++;
                }
            }
        }
        return count == 0;
    }

    private static boolean isTurnValid(int y, int x) {
        if (y < 0 || y > SIZE - 1 || x < 0 || x > SIZE - 1) { // если вышли за область поля
            return false;
        } else if (map[y][x] == EMPTY_DOT) { // если поле свободно для игры
            return true;
        }
        return false;
    }

    private static void aITurn() { // ход компьютера
        int x, y;
        do {
            x = (int) (Math.random() * SIZE);
            y = (int) (Math.random() * SIZE);
        } while (!isTurnValid(y, x));
        map[y][x] = DOT_O;
    }

    // Проба переписать под блокировку выигрыша игрока
    private static void aITurn2() { // ход компьютера с блокировкой игрока
        int x, y;
        System.out.println("AI turned");
        do {
            if (map[0][0] == map[0][1] && map[2][2] == map[1][2] && map[2][0] == map[1][1]) {
                y = 0;
                x = 2;
            } else if (map[2][0] == map[2][1] && map[1][2] == map[0][2] && map[0][0] == map[1][1]) {
                y = 2;
                x = 2;
            } else if (map[0][1] == map[0][2] && map[1][0] == map[2][0] && map[1][1] == map[2][2]) {
                y = 0;
                x = 0;
            } else if (map[1][0] == map[0][0] && map[2][1] == map[2][2] && map[1][1] == map[0][2]) {
                y = 2;
                x = 0;
            } else if (map[0][0] == map[2][2] && map[0][2] == map[2][0] && map[0][1] == map[2][1] && map[1][0] == map[1][2]) {
                y = 1;
                x = 1;
            } else if (map[1][1] == map[1][2] && map[0][0] == map[2][0]) {
                y = 1;
                x = 0;
            } else if (map[1][1] == map[2][1] && map[0][0] == map[0][2]) {
                y = 0;
                x = 1;
            } else if (map[0][2] == map[2][2] && map[1][0] == map[1][1]) {
                y = 1;
                x = 2;
            } else if (map[1][1] == map[0][1] && map[2][0] == map[2][2]) {
                y = 2;
                x = 1;
            } else {
                y = sc.nextInt(SIZE);
                x = sc.nextInt(SIZE);
            }
        } while (!isTurnValid(y, x));
        map[y][x] = DOT_O;
    }

    private static void humanTurn() { // ход игрока
        int x, y;
        System.out.println("Please input dot coordinates, in format Y X");
        do {
            y = sc.nextInt();
            x = sc.nextInt();
        } while (!isTurnValid(y - 1, x - 1));
        map[y - 1][x - 1] = DOT_X;
    }

    private static void printMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + "");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = EMPTY_DOT;
            }
        }
    }

    // РЕАЛИЗАЦИЯ ПРОВЕРКИ ПОБЕДЫ ДЛЯ ЛЮБЫХ МАССИВОВ
    private static boolean isWin(char symbol) {
        int count = 0; // инициируем переменную шагов
        // проверяем главную диагональ
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == j && map[i][j] == symbol) { // когда i = j (главная диагональ) и если символ один
                    count++; // добавляет проверку следующего значения
                } else if (i == j && !(map[i][j] == symbol)) {
                    count = 0; // сбрасываем каунт, если нет символов на диагонали
                }
            }
            if (count == DOT_TO_WIN) { // если уже есть 4 заполненных
                return true;
            }
        }
        count = 0; // опять обнуляем счетчик после проверки

        // проверяем обратную главную диагональ
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (j == map.length - (i + 1) && map[i][j] == symbol) { // если есть символы на i = map.length - (i + 1); (обратной диагонали)
                    count++; // добавляет проверку следующего значения
                } else if (j == map.length - (i + 1) && !(map[i][j] == symbol)) {
                    count = 0; // сбрасываем каунт если не нашел символ
                }
            }
            if (count == DOT_TO_WIN) { // если уже есть 4 заполненных
                return true;
            }
        }
        count = 0;

        // вертикальные линии проверки
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[j][i] == symbol) {
                    count++;
                } else if (!(map[i][j] == symbol)) {
                    count = 0;
                }
                if (count == DOT_TO_WIN) {
                    return true;
                }
            }
        }
        count = 0;

        // проврека по горизонтали
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[j][i] == symbol) {
                    count++;
                } else if (!(map[j][i] == symbol)) {
                    count = 0;
                }
                if (count == DOT_TO_WIN) {
                    return true;
                }
            }
        }
        count = 0;

        // для других диогоналей в массиве (маленьких) слева на право верхняя
        for (int i = 0; i < map.length - DOT_TO_WIN; i++) {
            for (int j = 0; j + DOT_TO_WIN <= map[i].length; j++) {
                if (i != j) { // чтоб пропускал главные диагонали
                    if (j == i + 1 && map[i][j] == symbol) {
                        count++;
                    } else if (j == i + 1 && !(map[i][j] == symbol)) {
                        count = 0;
                    }
                }
            }
            if (count == DOT_TO_WIN) { // если уже есть 4 заполненных
                return true;
            }
        }

        // для других диогоналей в массиве (маленьких) слева на право нижняя
        for (int i = 0; i < map.length - DOT_TO_WIN; i++) {
            for (int j = 0; j + DOT_TO_WIN <= map[i].length; j++) {
                if (i != j) { // чтоб пропускал главные диагонали
                    if (j == i - 1 && map[i][j] == symbol) {
                        count++;
                    } else if (j == i - 1 && !(map[i][j] == symbol)) {
                        count = 0;
                    }
                }
            }
            if (count == DOT_TO_WIN) { // если уже есть 4 заполненных
                return true;
            }
        }

        // для других диогоналей в массиве (маленьких) с низу вверх нижняя
        for (int i = 0; i < map.length - DOT_TO_WIN; i++) {
            for (int j = 0; j + DOT_TO_WIN <= map[i].length; j++) {
                if (j != map.length - (i + 1)) { // чтоб пропускал главную диагональ
                    if (j == map.length - i && map[i][j] == symbol) {
                        count++;
                    } else if (j == map.length - i && !(map[i][j] == symbol)) {
                        count = 0;
                    }
                }
            }
            if (count == DOT_TO_WIN) { // если уже есть 4 заполненных
                return true;
            }
        }

        // для других диогоналей в массиве (маленьких) с низу вверх верхняя
        for (int i = 0; i < map.length - DOT_TO_WIN; i++) {
            for (int j = 0; j + DOT_TO_WIN <= map[i].length; j++) {
                if (j != map.length - (i + 1)) { // чтоб пропускал главную диагональ
                    if (j == map.length - (i + 2) && map[i][j] == symbol) {
                        count++;
                    } else if (j == map.length - (i + 2) && !(map[i][j] == symbol)) {
                        count = 0;
                    }
                }
            }
            if (count == DOT_TO_WIN) { // если уже есть 4 заполненных
                return true;
            }
        }
        return false;
    }
}

//    // 2. Переделать проверку победы, чтобы она не была реализована просто набором условий (как 138), например,
//    // с использованием циклов.
//    private static boolean isWin(char symbol) {
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if (map[i][0] == symbol && map[i][1] == symbol && map[i][2] == symbol) return true;
//                if (map[0][j] == symbol && map[1][j] == symbol && map[2][j] == symbol) return true;
//                if (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) return true;
//                if (map[2][0] == symbol && map[1][1] == symbol && map[0][2] == symbol) return true;
//            }
//        }
//        return false;
//    }

//    // 3. Переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
//    // Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
//    static boolean isWin(char symbol) {
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if (map[i][0] == symbol && map[i][1] == symbol && map[i][2] == symbol && map[i][3] == symbol && map[i][4] == symbol)
//                    return true;
//                if (map[0][j] == symbol && map[1][j] == symbol && map[2][j] == symbol && map[3][j] == symbol && map[4][j] == symbol)
//                    return true;
//                if (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol && map[3][3] == symbol && map[4][4] == symbol)
//                    return true;
//                if (map[4][0] == symbol && map[3][1] == symbol && map[2][2] == symbol && map[1][3] == symbol && map[0][4] == symbol)
//                    return true;
//            }
//        }
//        return false;
//    }

//    // вариант с урока
//    private static boolean isWin(char symbol) {
//        if (map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol) return true;
//        if (map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol) return true;
//        if (map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol) return true;
//        if (map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol) return true;
//        if (map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol) return true;
//        if (map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol) return true;
//        if (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) return true;
//        if (map[2][0] == symbol && map[1][1] == symbol && map[0][2] == symbol) return true;
//        return false;
//    }


