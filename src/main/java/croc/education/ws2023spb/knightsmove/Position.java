package croc.education.ws2023spb.knightsmove;

public class Position implements ChessPosition {
    private final int x;
    private final int y;


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
            throw new IllegalPositionException("Illegal Position: " + this.chessPosition(x, y));
        }
        this.x = x;
        this.y = y;
    }

    private String chessPosition(int x, int y) {
        char column = (char) ('a' + x);
        int row = y + 1;
        return "" + column + row;
    }

    @Override
    public String toString() {
        return chessPosition(this.x, this.y);
    }
}
