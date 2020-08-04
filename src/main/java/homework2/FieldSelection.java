package homework2;

import java.util.Arrays;

class FieldSelection {
    private String[][] myArray;

    public FieldSelection(String[][] myArray) {
        this.myArray = myArray;
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

    public String[][] getmyArray() {
        return myArray;
    }

    public void setmyArray(String[][] myArray) {
        this.myArray = myArray;
    }
}


