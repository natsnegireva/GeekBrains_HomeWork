package homework2;

public class Main {

    public static void main(String[] args) {
        String[][] myArray = new String[4][4];
        FieldSelection fieldSelection = new FieldSelection(myArray);

        try {
            fieldSelection.sumArray(myArray);
        } catch (MyArraySizeException e) {
            System.out.println("Передан массив других параметров");
        }

    }
}
