package homeworktwo;

import java.util.Arrays;

public class HomeWorkTwo {


    public static void main(String[] args) {
    }

    // 1 - Задать целочисленный массив, состоящий из элементов 0 и 1. С помощью цикла и условия заменить 0 на 1, 1 на 0;

    public static void oneZeroArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
    }


    // 2 - Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

    public static void fillInArray() {
        int[] array = new int[8];
        // Вариант 1
        for (int i = 0, x = 0; i < array.length; i++, x += 3) {
            array[i] = x;
        }
        // Вариант 2
        int step = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = step;
            step = step + 3;
        }
    }


    // 3 - Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

    public static void ohangeArray() {
        int[] changesArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < changesArr.length; i++) {
            if (changesArr[i] < 6) {
                changesArr[i] *= 2;
            }
        }
    }


    // 4 - Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void squareArray() {
        int[][] squarearr = new int[10][10];
        for (int i = 0; i < squarearr.length; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) {
                    squarearr[i][j] = 1;
                } else {
                    squarearr[i][j] = 0;
                }
            }
        }
    }

    // 5 - Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void minMaxArray() {
        int[] minmaxarr = {8, 5, 3, 2, 11, 4, 5, 2, 0, 7, 9, -8, -5, -3, -2, -22, -4, -5, 0, -7, 8};
        int minvalue = minmaxarr[0];
        int maxvalue = minmaxarr[1];
        for (int i : minmaxarr) {
            if (i < minvalue) {
                minvalue = i;
            } else if (i > maxvalue) {
                maxvalue = i;
            }
        }
    }

    // 6 - Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    static boolean checkBalanceArray(int[] balanceArr) {
        int startpoint = 0;
        int endpoint = 0;
        while (startpoint != endpoint) {
            for (int i = 0; i < balanceArr.length; i++) {
                startpoint = startpoint + balanceArr[i];
                for (int j = balanceArr.length - 1; j >= 0; j--) {
                    endpoint = endpoint + balanceArr[j];
                }
            }
        }
        if (startpoint == endpoint) {
            return true;
        } else {
            return false;
        }
    }

    // 7 - Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    // [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.
    public static void moveToArr(int[] movearr, int step) {
        int tmp = 0;
        if (step > 0) {
            for (int i = 0; i < step; i++) {
                tmp = movearr[0];
                for (int j = 0; j < movearr.length - 1; j++)
                    movearr[j] = movearr[j + 1];
                movearr[movearr.length - 1] = tmp;
            }
        } else if (step < 0) {
            for (int i = 0; i > step; i--) {
                tmp = movearr[movearr.length - 1];
                for (int j = movearr.length - 1; j > 0; j--)
                    movearr[j] = movearr[j - 1];
                movearr[0] = tmp;
            }
        }
    }
}




