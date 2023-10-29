package croc.education.ws2023spb.knightsmove;

/**
 * Класс обработчик, проверяющий, что последовательность клеток на шахматной доске может быть пройдена ходом коня.
 *
 * @author Chernetsov Alexander
 */
public class KnightsMoveCheckerClass implements KnightsMoveChecker {
    /**
     * Проверяет, что указанная последовательность клеток на шахматной доске может быть пройдена ходом шахматного коня.
     *
     * @param positions последовательность клеток на шахматной доске, которую надо обойти от предыдущей клетки к следующей
     * @throws IllegalMoveException если при перемещении шахматного коня из текущей клетки в следующую происходит с нарушением правил
     */
    @Override
    public void check(String[] positions) throws IllegalMoveException {
        if (positions == null || positions.length == 0) {
            throw new IllegalMoveException(null, null);
        }
        if (positions.length == 1) {
            throw new IllegalMoveException(ChessPositionParser.parse(positions[0]), null);
        }
        ChessPosition previousPosition = ChessPositionParser.parse(positions[0]);
        for (int i = 1; i < positions.length; i++) {
            ChessPosition currentPosition = ChessPositionParser.parse(positions[i]);
            if (!isValidMove(previousPosition, currentPosition)) {
                throw new IllegalMoveException(previousPosition, currentPosition);
            }
            previousPosition = currentPosition;
        }
    }

    /**
     * Метод, проверяющий корректность хода из pos1 в pos2
     *
     * @param pos1
     *              начальная позиция фигуры
     * @param pos2
     *          конечная позиция фигуры
     * @return
     *          true в случае, если конь сможет совершить ход
     *          false в случае, если конь так ходить не может
     */
    private boolean isValidMove(ChessPosition pos1, ChessPosition pos2) {
        if (Math.abs(pos1.x() - pos2.x()) == 1 && Math.abs(pos1.y() - pos2.y()) == 2 ||
                Math.abs(pos1.x() - pos2.x()) == 2 && Math.abs(pos1.y() - pos2.y()) == 1) {
            return true;
        }
        return false;
    }
}
