package croc.education.ws2023spb.knightsmove;

import croc.education.ws2023spb.knightsmove.exceptions.IllegalMoveException;

import java.util.*;

/**
 * Обработчик, проверяющий, что последовательность клеток на шахматной доске может быть пройдена ходом коня.
 * 
 * @author Dmitry Malenok
 */
public abstract class KnightsMoveChecker {

    /**
     * Проверяет, что указанная последовательность клеток на шахматной доске может быть пройдена ходом шахматного коня.
     * 
     * @param positions
     *            последовательность клеток на шахматной доске, которую надо обойти от предыдущей клетки к следующей
     * @throws IllegalMoveException
     *             если при перемещении шахматного коня из текущей клетки в следующую происходит с нарушением правил
     */
    void check(String... positions) throws IllegalMoveException{
        List<ChessPosition> parsedPositions = new ArrayList<>();
        for (var i: positions) {
            parsedPositions.add(ChessPositionParser.parse(i));
        }

        for (int i = 1; i < parsedPositions.size(); i++) {
            ChessPosition start = parsedPositions.get(i-1);
            ChessPosition finish = parsedPositions.get(i);
            if (Math.abs(finish.x() - start.x()) + Math.abs(finish.y() - start.y()) != 3)
                throw new IllegalMoveException(String.format("конь так не ходит: %s -> %s", start, finish));
        }
    }
}
