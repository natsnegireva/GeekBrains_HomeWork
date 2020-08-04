package homework2;

import java.util.Arrays;

class FieldSelection {
    private String[][] myArray;

    public FieldSelection(String[][] myArray) {
        this.myArray = myArray;
    }


    public void sumArray(String[][] myArray) throws MyArrayDataException, MyArraySizeException {
        // при подаче массива другого размера необходимо бросить исключение MyArraySizeException
        // если все верно, распечатать и заполнить значениями
        int i = 0;
        int j = 0;
        int sum = 0;
        if (myArray[j].length != 4) {
            throw new MyArraySizeException();
        } else if (myArray[j].length != i) {
            throw new MyArraySizeException();
        } else {
            for (i = 0; i < myArray.length; i++) {
                for (j = 0; j < myArray[i].length; j++) {
                    myArray[i][j] = String.valueOf(j + 1);
                }
            }
            for (String[] strings : myArray) {
                System.out.print(Arrays.deepToString(myArray) + " ");
                System.out.println();
            }
        }


        // должно быть брошено исключение MyArrayDataException,
        // с детализацией в какой именно ячейке лежат неверные данные
        try {
            for (i = 0; i < myArray.length; i++) {
                for (j = 0; j < myArray[i].length; j++) {
                    int num = Integer.parseInt(myArray[i][j]);
                    sum += num;
                }
            }
        } catch (MyArrayDataException e) {
           e.printError(myArray[i][j]);
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


