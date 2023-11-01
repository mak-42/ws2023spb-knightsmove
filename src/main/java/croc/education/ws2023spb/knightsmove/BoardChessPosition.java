package croc.education.ws2023spb.knightsmove;

public class BoardChessPosition implements ChessPosition {
    private int xPosition;
    private int yPosition;

    public BoardChessPosition(int xPosition, int yPosition) throws IllegalPositionException {
        if (checkPositionValidity(xPosition)) {
            this.xPosition = xPosition;
        } else {
            throw new IllegalPositionException("X position must be between a and h");
        }
        if (checkPositionValidity(yPosition)) {
            this.yPosition = yPosition;
        } else {
            throw new IllegalPositionException("Y position must be between 1 and 8");
        }
    }

    private boolean checkPositionValidity(int a) {
        return a >= 0 && a <= 7;
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
        char column = (char) (97 + xPosition);
        return String.format("%s%s", column, yPosition + 1);
    }

    public void setXPosition(int xPosition) throws IllegalPositionException {
        if (checkPositionValidity(xPosition)) {
            this.xPosition = xPosition;
        } else {
            throw new IllegalPositionException("X position must be between 0 and 7");
        }
    }


    public void setYPosition(int yPosition) throws IllegalPositionException {
        if (checkPositionValidity(yPosition)) {
            this.yPosition = yPosition;
        } else {
            throw new IllegalPositionException("Y position must be between 0 and 7");
        }
    }
}
