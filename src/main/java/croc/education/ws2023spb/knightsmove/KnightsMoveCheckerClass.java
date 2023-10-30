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
    public void check(String[] positions) throws IllegalMoveException, IllegalPositionException {
        if (positions == null || positions.length == 0) {
            throw new IllegalMoveException(null, null);
        }
        ChessPosition previousPosition;
        ChessPosition currentPosition;
        try {
            previousPosition = ChessPositionParser.parse(positions[0]);
        }catch (IllegalPositionException ex){
            throw new IllegalPositionException(1, ex);
        }
        for (int i = 1; i < positions.length; i++) {
            try{
                currentPosition = ChessPositionParser.parse(positions[i]);
            }catch (IllegalPositionException ex){
                throw new IllegalPositionException(i+1, ex);
            }
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
        return (Math.abs(pos1.x() - pos2.x()) == 1 && Math.abs(pos1.y() - pos2.y()) == 2 ||
                Math.abs(pos1.x() - pos2.x()) == 2 && Math.abs(pos1.y() - pos2.y()) == 1);
    }
}
