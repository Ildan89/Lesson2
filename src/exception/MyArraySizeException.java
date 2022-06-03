package exception;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super();
    }

    public MyArraySizeException(String msg) {
        super(msg);
    }
}
