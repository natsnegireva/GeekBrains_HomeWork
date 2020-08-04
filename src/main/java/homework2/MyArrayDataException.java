package homework2;

public class MyArrayDataException extends IllegalArgumentException{

    public MyArrayDataException() {
        super();
    }
    public void printError(String s) {
        System.out.println("Не удалось приведение типов, ошибка в ячейке " + s);
    }

}
