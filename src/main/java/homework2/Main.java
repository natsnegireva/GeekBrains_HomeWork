package homework2;

public class Main {

    public static void main(String[] args) {

        String[][] myArray = new String[4][4];
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                myArray[i][j] = String.valueOf(j + 1);
            }
        }
        FieldSelection fieldSelection = new FieldSelection(myArray);
        fieldSelection.printArray(myArray);

        try {
            fieldSelection.sumArray(myArray);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e1) {
            e1.getCause();
        } finally {
            System.out.println("Исключения отработаны");
        }
    }
}
