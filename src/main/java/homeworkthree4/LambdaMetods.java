package homeworkthree4;


import static java.lang.Integer.max;

public class LambdaMetods {

    public static void main(String[] args) {

        // 1. Напишите метод, который возвращает индекс первого вхождения данного целого числа в списке
        Lsearch lsearch = (n, list) -> {
            for (int i = 0; i < list.length; i++) {
                if (list[i].equals( n )) {
                    return i;
                }
            }
            return -1;
        };

        // 2. Напишите метод, переворачивающий строку.
        Lrev lrev = s -> {
            return s = new StringBuilder( s ).reverse().toString();
        };

        // 3. Напишите метод, который возвращает наибольшее целое число в списке
        Lmaximum lmax = list -> {
            Integer x = null;
                for (int i = 0; i < list.length - 1; i++) {
                    x = max( list[i], list[i + 1] );
                }
            return x;
        };

        // 4. Напишите метод, который возвращает среднее значение из списка целых чисел
        Laverage laverage = list -> {
            Double sum = 0.0;
                for (Integer integer : list) {
                    sum += integer;
                }
            return (double) sum / list.size();
        };

        // 5. Имея список строк, напишите метод, который возвращает список всех строк,
        // которые начинаются с буквы «а» (нижний регистр) и имеют ровно 3 буквы.
        LsearchWord lsearchWord = list -> {
            for (String s : list) {
                if (s.startsWith( "a" ) && s.length() == 3) {
                    list.add( s );
                }
            }
            return list;
        };

    }
}
