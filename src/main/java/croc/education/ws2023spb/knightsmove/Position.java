package croc.education.ws2023spb.knightsmove;

public class Position implements ChessPosition {
    private int x;
    private int y;


    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }

    public Position() {
        x = 0;
        y = 0;
    }

    public Position(int x, int y) throws IllegalPositionException {
        if (x < 0 || y < 0 || x > 7 || y > 7) {
            throw new IllegalPositionException();
        }
        this.x = x;
        this.y = y;
    }

    public void setX(int x) throws IllegalPositionException {
        if (x < 0 || x > 7) {
            throw new IllegalPositionException();
        }
        this.x = x;
    }

    public void setY(int y) throws IllegalPositionException {
        if (y < 0 || y > 7) {
            throw new IllegalPositionException();
        }
        this.y = y;
    }

    @Override
    public String toString() {
        char column = (char) ('a' + x);
        int row = y + 1;
        return "" + column + row;
    }
}
