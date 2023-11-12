package croc.education.ws2023spb.knightsmove;

public class ConcreteKnightsMoveChecker implements KnightsMoveChecker {
    @Override
    public void check(String[] positions) throws IllegalMoveException {
        ChessPosition previousPosition = ChessPositionParser.parse(positions[0]);

        for (int i = 1; i < positions.length; i++) {
            ChessPosition currentPosition = ChessPositionParser.parse(positions[i]);
            if (!checkMoveDistance(previousPosition, currentPosition)) {
                throw new IllegalMoveException(previousPosition, currentPosition);
            }
            previousPosition = currentPosition;
        }
    }
    private boolean checkMoveDistance(ChessPosition startPosition, ChessPosition finalPosition) {
        int moveDistanceX = Math.abs(startPosition.x() - finalPosition.x());
        int moveDistanceY = Math.abs(startPosition.y() - finalPosition.y());

        return (moveDistanceX == 1 && moveDistanceY == 2) || (moveDistanceX == 2 && moveDistanceY == 1);
    }
}
