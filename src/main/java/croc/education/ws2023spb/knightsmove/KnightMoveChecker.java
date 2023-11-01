package croc.education.ws2023spb.knightsmove;

import java.util.ArrayList;

public class KnightMoveChecker implements KnightsMoveChecker {
    @Override
    public void check(String[] positions) throws IllegalMoveException {
        ArrayList<ChessPosition> chessPositions = new ArrayList<ChessPosition>();
        for (String position : positions) {
            chessPositions.add(ChessPositionParser.parse(position));
        }
        for (int i = 0; i < chessPositions.size() - 1; i++) {
            if (!checkMove(chessPositions.get(i), chessPositions.get(i + 1))) {
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
