package croc.education.ws2023spb.knightsmove;

public class BoardChessPosition implements ChessPosition {
    final private int xPosition;
    final private int yPosition;

    public BoardChessPosition(int xPosition, int yPosition) throws IllegalPositionException {
        this.xPosition = checkPositionValidity(xPosition, "X position must be between a and h. ");
        this.yPosition = checkPositionValidity(yPosition, "Y position must be between 1 and 8. ");
        ;
    }

    private int checkPositionValidity(int a, String message) {
        if (!(a >= 0 && a <= 7)) {
            throw new IllegalPositionException(message + "Current position is " + a);
        }
        return a;
    }

    @Override
    public int x() {
        return xPosition;
    }

    @Override
    public int y() {
        return yPosition;
    }

    @Override
    public String toString() {
        char column = (char) ('a' + xPosition);
        return String.format("%s%s", column, yPosition + 1);
    }
}
