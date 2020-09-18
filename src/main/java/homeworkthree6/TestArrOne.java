package homeworkthree6;

import java.util.Arrays;

public class TestArrOne {

    // 3. Написать метод, который проверяет состав массива из чисел 1 и 4.
    // Если в нем нет хоть одной четверки или единицы, то метод вернет false;
    // Написать набор тестов для этого метода (по 3-4 варианта входных данных).

    public static boolean OneFourArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 || arr[i] == 4) return true;
        }
        return false;
    }

    // 2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
    // Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
    // идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
    // необходимо выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    // Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

    public int[] ReturnArrAfter(int[] arr)  {
        int n = 0;
        String m = Arrays.toString(arr);
        if (m.indexOf(String.valueOf(4)) != -1) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 4) n = i;
            }
            int[] arr1 = new int[arr.length - n - 1];
            System.arraycopy(arr, n + 1, arr1, 0, arr1.length);
            return arr1;
        } else {
            throw new RuntimeException("массив не содержит 4");
        }
    }
}
