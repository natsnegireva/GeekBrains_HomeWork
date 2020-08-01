package homework2;

public class MyArrayDataException extends IllegalArgumentException {
// должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные

    public MyArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
