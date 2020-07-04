package homeworktwo;

public class AdditionTaskTwo {

    public static void main(String[] args) {
        spiralArray(7);
        centerSpiralArr(7);
    }

    // Заполнение квадратного массива по спирали (начало верхняя левая точка).
    public static void spiralArray(int n) {
        int[][] SpiralArr = new int[n][n];
        int rowArray = 0; // иницмализируем переменную для строк
        int colArray = 0; // иницмализируем переменную для колонок
        int dx = 1;
        int dy = 0;
        int dirChanges = 0;
        int walkWay = n;

        for (int i = 0; i < n * n; i++) { // по количеству элементов в массиве определяем границу
            SpiralArr[rowArray][colArray] = i + 1; // начальное значение движения до n
            if (--walkWay == 0) {
                walkWay = SpiralArr.length * (dirChanges % 2) + SpiralArr.length * ((dirChanges + 1) % 2) - (dirChanges / 2 - 1) - 2;
                int tempVariable = dx;
                dx = -dy;
                dy = tempVariable;
                dirChanges++;
            }
            colArray = colArray + dx;
            rowArray = rowArray + dy;
        }
        // печатаем маcсив
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(SpiralArr[i][j] + "\t");
            System.out.println();
        }
        System.out.println(); // tab
    }

    // Заполнение квадратного массива по спирали из центра массива при помощи case
    public static void centerSpiralArr(int n) {
        int[][] CSpiralArr = new int[n][n];
        // устанавливаем центр
        int i = n / 2;
        int j = n / 2;
        // задаем границы движения в массиве
        int min_i = i;
        int max_i = i; // влево вправо
        int min_j = j;
        int max_j = j; // вверх вниз
        int d = 0; // устанавливаем движение влево
        for (int a = 1; a < (n * n)+1; a++) {
            CSpiralArr[i][j] = a;
            switch (d) {
                case 0:
                    i = i - 1;  // движение влево
                    if (i < min_i) { // проверка выхода за заполненную центральную часть слева
                        d = 1; // меняем направление
                        min_i = i; // увеличиваем заполненную часть влево
                    }
                    break;
                case 1:  // движение вверх проверка сверху
                    j = j - 1;
                    if (j < min_j) {
                        d = 2;
                        min_j = j;
                    }
                    break;
                case 2:  // движение вправо проверка справа
                    i = i + 1;
                    if (i > max_i) {
                        d = 3;
                        max_i = i;
                    }
                    break;
                case 3:  // движение вниз проверка снизу
                    j = j + 1;
                    if (j > max_j) {
                        d = 0;
                        max_j = j;
                    }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int v = 0; v < n; v++)
                System.out.print(CSpiralArr[k][v] + "\t");
            System.out.println();
        }
    }
}
