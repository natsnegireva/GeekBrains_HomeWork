package homework2;

import java.util.Arrays;

class FieldSelection {
    private final String[][] myArray;
    private int sum;
    private int j;

    public FieldSelection(String[][] myArray) {
        this.myArray = myArray;
        this.sum = sum;
    }

    // распечатать массив
    public void printArray(String[][] myArray){
        for (String[] strings : myArray) {
            System.out.print(Arrays.deepToString(myArray) + " ");
            System.out.println();
        }
    }

    // просуммировать значения элементов
    public void sumArray(String[][] myArray) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                int num = Integer.parseInt(myArray[i][j]);
                sum += num;
            }
        }
        System.out.print("Сумма элементов массива равна " + sum * myArray.length);
        System.out.println();
    }


    // просуммировать количество элементов
    public void sumArrayIndex(String[][] myArray) {
        int sum = 0;
        for (String[] str : myArray) {
            str = myArray[j];
            int num = Integer.parseInt(str[j]);
            sum += num;
        }
        System.out.println(sum);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int maxrun) {
        this.sum = sum;
    }
}


