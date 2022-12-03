package bean;

public class MyException extends RuntimeException {
    static final long serialVersionUID = -7034897880745766939L;

    public MyException() {

    }

    public MyException(String message) {
        super(message);
    }
}
