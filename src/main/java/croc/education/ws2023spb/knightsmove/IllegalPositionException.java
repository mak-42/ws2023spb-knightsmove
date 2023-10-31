package croc.education.ws2023spb.knightsmove;

public class IllegalPositionException extends RuntimeException{

    private String message;

    public IllegalPositionException() {
        super();
    }

    public IllegalPositionException(String message) {
        this.message = message;
    }

    public IllegalPositionException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
