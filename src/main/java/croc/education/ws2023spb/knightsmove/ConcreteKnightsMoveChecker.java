package croc.education.ws2023spb.knightsmove;

import java.util.ArrayList;

public class ConcreteKnightsMoveChecker implements KnightsMoveChecker {
    @Override
    public void check(String[] positions) throws IllegalMoveException, IllegalPositionException {
        ArrayList<ChessPosition> parsedPositions = new ArrayList<>();
        for (var position : positions) {
            parsedPositions.add(ChessPositionParser.parse(position));
        }
        for (int i = 0; i < parsedPositions.size() - 1; i++) {
            if (!checkMoveDistance(parsedPositions.get(i), parsedPositions.get(i+1))) {
                throw new IllegalMoveException(parsedPositions.get(i), parsedPositions.get(i+1));
            }
        }
    }
    private boolean checkMoveDistance(ChessPosition startPosition, ChessPosition finalPosition) {
        int moveDistanceX = Math.abs(startPosition.x() - finalPosition.x());
        int moveDistanceY = Math.abs(startPosition.y() - finalPosition.y());

        return (moveDistanceX == 1 && moveDistanceY == 2) || (moveDistanceX == 2 && moveDistanceY == 1);
    }
}
