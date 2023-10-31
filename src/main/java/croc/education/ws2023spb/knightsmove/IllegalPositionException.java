package croc.education.ws2023spb.knightsmove;

public class IllegalPositionException extends RuntimeException{
    private final String position;

    public IllegalPositionException(String position) {
        this.position = position;
    }

    @Override
    public String getMessage() {
        return "Позиции " + position + " несуществует, пожалуйста, проверьте корректность написания данной позиции.";
    }
}
