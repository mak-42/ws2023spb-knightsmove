package croc.education.ws2023spb.knightsmove;

public class IllegalPositionException extends Exception{
    public IllegalPositionException(String errorMessage) {
        super(errorMessage);
    }
}
