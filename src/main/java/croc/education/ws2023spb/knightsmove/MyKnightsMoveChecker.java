package croc.education.ws2023spb.knightsmove;

public class MyKnightsMoveChecker implements KnightsMoveChecker {
    @Override
    public void check(String[] positions) throws IllegalMoveException {
        String fromPosition, toPosition;
        for (int i = 1; i < positions.length; i++) {
            fromPosition = positions[i-1];
            toPosition= positions[i];
            if (!isKnightMove(fromPosition, toPosition)) {
               throw new IllegalMoveException(fromPosition,toPosition);
            }
        }
    }

    public boolean isKnightMove(String from, String to) {
        int x2 = ChessPositionParser.parse(to).x();
        int x1 = ChessPositionParser.parse(from).x();
        int y2 = ChessPositionParser.parse(to).y();
        int y1 = ChessPositionParser.parse(from).y();
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        return ((dx == 2 && dy == 1) || (dx == 1 && dy == 2));
    }
}
