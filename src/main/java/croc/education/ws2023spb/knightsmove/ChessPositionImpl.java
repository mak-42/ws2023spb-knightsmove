package croc.education.ws2023spb.knightsmove;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChessPositionImpl implements ChessPosition {
    private final int x;
    private final int y;
    private static Map<Integer, String> chessColumns = new HashMap<>();

    // По ощущениям заполнение этой мапы можно было сделать элегантнее, но выбрал самый банальный вариант
    static {
        chessColumns.put(0, "a");
        chessColumns.put(1, "b");
        chessColumns.put(2, "c");
        chessColumns.put(3, "d");
        chessColumns.put(4, "e");
        chessColumns.put(5, "f");
        chessColumns.put(6, "g");
        chessColumns.put(7, "h");
        chessColumns = Collections.unmodifiableMap(chessColumns);
    }

    public ChessPositionImpl(int x, int y) throws IllegalPositionException{
        if (x < 0 || x > 7) {
            throw new IllegalPositionException("Illegal value of argument x = %d. 'X' position value ".formatted(x) +
                    "should belong [0, 7]");
        }

        if (y < 0 || y > 7) {
            throw new IllegalPositionException("Illegal value of argument y = %d. 'Y' position value ".formatted(y) +
                    "should belong [0, 7]");
        }

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
        return ChessPositionImpl.chessColumns.get(x) + (y + 1);
    }
}
