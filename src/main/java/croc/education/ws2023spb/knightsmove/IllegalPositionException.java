package croc.education.ws2023spb.knightsmove;

import java.io.IOException;

public class IllegalPositionException extends RuntimeException {
    private String message;

    public IllegalPositionException(String message) {
        this.message = message;
    }

    public IllegalPositionException() {
        this.message = "IllegalPositionException";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
