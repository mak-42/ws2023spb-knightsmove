package croc.education.ws2023spb.knightsmove;

public class MyKnightsMoveChecker implements KnightsMoveChecker {
    @Override
    public void check(String[] positions) throws IllegalMoveException {
        String from, to;
        for (int i = 1; i < positions.length; i++) {
            from = positions[i-1];
            to= positions[i];
            if (!isKnightMove(from, to)) {
               throw new IllegalMoveException("конь так не ходит: " + from + " -> " + to.trim());
            }
        }
        System.out.print("OK");
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
