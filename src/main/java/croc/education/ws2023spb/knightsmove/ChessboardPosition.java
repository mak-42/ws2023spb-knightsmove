package croc.education.ws2023spb.knightsmove;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChessboardPosition implements ChessPosition {
    private final int columnX;
    private final int rowY;
    static final int MIN_POSITION = 0;
    static final int MAX_POSITION = 7;
    private static final Map<Integer, String> mutablePositionXToLetter = new HashMap<>();
    static {
        mutablePositionXToLetter.put(0, "a");
        mutablePositionXToLetter.put(1, "b");
        mutablePositionXToLetter.put(2, "c");
        mutablePositionXToLetter.put(3, "d");
        mutablePositionXToLetter.put(4, "e");
        mutablePositionXToLetter.put(5, "f");
        mutablePositionXToLetter.put(6, "g");
        mutablePositionXToLetter.put(7, "h");
    }
    static Map<Integer, String> positionXToLetter = Collections.unmodifiableMap(mutablePositionXToLetter);

    public ChessboardPosition(int columnX, int rowY) {
        if (columnX < MIN_POSITION || columnX > MAX_POSITION) {
            throw new IllegalPositionException("Позиция X должна находиться в диапазоне от " + MIN_POSITION + " до " + MAX_POSITION);
        }
        if (rowY < MIN_POSITION || rowY > MAX_POSITION) {
            throw new IllegalPositionException("Позиция Y должна находиться в диапазоне от " + MIN_POSITION + " до " + MAX_POSITION);
        }

        this.columnX = columnX;
        this.rowY = rowY;
    }

    @Override
    public int x() {
        return columnX;
    }

    @Override
    public int y() {
        return rowY;
    }

    @Override
    public String toString() {
        return positionXToLetter.get(columnX) + (rowY + 1);
    }
}
