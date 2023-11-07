package croc.education.ws2023spb.knightsmove;

import java.util.ArrayList;

public class KnightMoveChecker implements KnightsMoveChecker {
    @Override
    public void check(String[] positions) throws IllegalMoveException {
        for (int i = 0; i < positions.length - 1; i++) {
            if (!checkMove(ChessPositionParser.parse(positions[i]), ChessPositionParser.parse(positions[i + 1]))) {
                throw new IllegalMoveException(String.format("конь так не ходит: %s -> %s", positions[i], positions[i + 1]));
            }
        }
    }

    private boolean checkMove(ChessPosition position1, ChessPosition position2) {
        int dx = Math.abs(position1.x() - position2.x());
        int dy = Math.abs(position1.y() - position2.y());
        return dx == 1 && dy == 2 || dx == 2 && dy == 1;
    }
}
