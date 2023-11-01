package croc.education.ws2023spb.knightsmove;

public class IllegalPositionException extends RuntimeException {
    public IllegalPositionException(String errorMessage) {
        super(errorMessage);
    }
}
