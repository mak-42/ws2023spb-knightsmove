package croc.education.ws2023spb.knightsmove;

public class IllegalPositionException extends RuntimeException {

    public IllegalPositionException(String message) {
        super(message);
    }

    public IllegalPositionException(int x, int y) {
        super("Illegal position: {" + x + ":" + y + "}");
    }

}
