package transportation.line;

public class TransportationException extends Exception { // Throwable?
    private String msg;

    public TransportationException(String msg) {
        // this.msg = msg;
        super(msg);
    }
}