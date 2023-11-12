package croc.education.ws2023spb.knightsmove;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChessboardPosition implements ChessPosition {
    private final int columnX;
    private final int rowY;
    private static final Map<Integer, String> positionXToLetter = Map.of(
        0, "a",
        1, "b",
        2, "c",
        3, "d",
        4, "e",
        5, "f",
        6, "g",
        7, "h"
    );

    
    public ChessboardPosition(int columnX, int rowY) {
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
