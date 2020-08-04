package homework2;

public class MyArraySizeException extends Exception {
    String Message;

    public MyArraySizeException() {
        super();
    }

    @Override
    public String getMessage() {
        return Message;
    }


}
