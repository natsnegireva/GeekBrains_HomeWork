package homeworktwo;

class HomeWorkTwo {


    public static void main(String[] args) {

    }

    // 1 - Задать целочисленный массив, состоящий из элементов 0 и 1.
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
    static void oneZeroArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
    }

    // 2 - Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями
    // 0 3 6 9 12 15 18 21;
    static void fillInArray() {
        int[] fillArray = new int[8];
        // Вариант 1
        for (int i = 0, x = 0; i < fillArray.length; i++, x += 3) {
            fillArray[i] = x;
        }
        // Вариант 2
        int step = 0;
        for (int i = 0; i < fillArray.length; i++) {
            fillArray[i] = step;
            step = step + 3;
        }
    }


    // 3 - Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
    // и числа меньшие 6 умножить на 2;
    static void ohangeArray() {
        int[] changesArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < changesArr.length; i++) {
            if (changesArr[i] < 6) {
                changesArr[i] *= 2;
            }
        }
    }


    // 4 - Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    static void squareArray() {
        int[][] squareArr = new int[10][10];
        for (int i = 0; i < squareArr.length; i++) {
            for (int j = 0; j < squareArr.length; j++) {
                if (i == j || i == squareArr.length - (j + 1)) {
                    squareArr[i][j] = 1;
                } else {
                    squareArr[i][j] = 0;
                }
            }
        }
    }

    // 5 - Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    static void minMaxArray() {
        int[] minmaxArr = {8, 5, 3, 2, 11, 4, 5, 2, 0, 7, 9, -8, -5, -3, -2, -22, -4, -5, 0, -7, 8};
        int minvalue = minmaxArr[0];
        int maxvalue = minmaxArr[0];
        for (int i : minmaxArr) {
            if (i < minvalue) {
                minvalue = i;
            } else if (i > maxvalue) {
                maxvalue = i;
            }
        }
        System.out.println("Минимальное значение " + minvalue + ". Максимальное значение " + maxvalue);
    }

    // 6 - Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    // добавилось @org.jetbrains.annotations.Contract(pure = true)
    static boolean checkBalanceArray(int[] balanceArr) {
        //Вариант - если сумма элементов масива будет четным значением, то true, нечетным false
        int sumArr = 0;
        for (int i = 0; i < balanceArr.length; ++i) {
            sumArr += balanceArr[i]; // находим сумму элементов массива
        }
        if (sumArr % 2 == 0) { // если сумма всех элементов массива четная - то есть вариант равенства правой и левой части
            return true;
        } else {
            return false;
        }
    }

//        int startPoint = 0;
//        int endPoint = 0;
//        while (startPoint != endPoint) {
//            for (int i = 0; i < balanceArr.length; i++) {
//                startPoint = startPoint + balanceArr[i];
//                for (int j = balanceArr.length - 1; j >= 0; j--) {
//                    endPoint = endPoint + balanceArr[j];
//                }
//            }
//        }
//        if (startPoint == endPoint) {
//            return true;
//        } else {
//            return false;
//        }

    // 7 - Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    // [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.
    static void moveToArr(int[] moveArr, int step) {
        int tmp = 0;
        if (step > 0) {
            for (int i = 0; i < step; i++) { // сдвигаем вправо на 1
                tmp = moveArr[0];
                for (int j = 0; j < moveArr.length - 1; j++) {
                    moveArr[j] = moveArr[j + 1];
                    moveArr[moveArr.length - 1] = tmp;
                }
            }
        } else if (step < 0) {
            for (int i = 0; i > step; i--) {
                tmp = moveArr[moveArr.length - 1];
                for (int j = moveArr.length - 1; j > 0; j--)
                    moveArr[j] = moveArr[j - 1];
                moveArr[0] = tmp;
            }
        }
    }
    // комментарии к 7 заданию
    // if (i == j || i > j - squarearray.length) {squarearray[i][j] = i;} - запонит массив последовательно одинаковыми числами в одной строке
    // if (i == j || squarearr.length - i == j + 1) - для не главной диагонали
}




