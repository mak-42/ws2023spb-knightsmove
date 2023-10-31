package croc.education.ws2023spb.knightsmove;

import java.io.IOException;

public class IllegalPositionException extends IOException {
    private String message;

    public IllegalPositionException(String message) {
        this.message = message;
    }

    public IllegalPositionException() {
        this.message = "Incorrect position for chess figure";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
