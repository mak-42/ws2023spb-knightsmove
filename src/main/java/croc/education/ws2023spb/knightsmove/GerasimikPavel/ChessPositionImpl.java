package croc.education.ws2023spb.knightsmove.GerasimikPavel;

public class ChessPositionImpl implements ChessPosition{
    private int x;
    private int y;

    public ChessPositionImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }

    @Override
    public String toString() {
        char column = (char) ('a' + x);
        char row = (char) ('1' + y);
        return column + String.valueOf(row);
    }
}
