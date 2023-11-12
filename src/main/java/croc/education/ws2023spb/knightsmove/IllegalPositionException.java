package croc.education.ws2023spb.knightsmove;

public class IllegalPositionException extends RuntimeException {
    public IllegalPositionException(String message) {
        super(message);
    }
}
