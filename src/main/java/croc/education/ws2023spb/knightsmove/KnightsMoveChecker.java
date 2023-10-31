package croc.education.ws2023spb.knightsmove;

import java.util.ArrayList;
import java.util.List;

/**
 * Обработчик, проверяющий, что последовательность клеток на шахматной доске может быть пройдена ходом коня.
 *
 * @author Dmitry Malenok
 */
public abstract class KnightsMoveChecker {

    /**
     * Проверяет, что указанная последовательность клеток на шахматной доске может быть пройдена ходом шахматного коня.
     *
     * @param positions последовательность клеток на шахматной доске, которую надо обойти от предыдущей клетки к следующей
     * @throws IllegalMoveException если при перемещении шахматного коня из текущей клетки в следующую происходит с нарушением правил
     */
    void check(String... positions) throws IllegalMoveException {
        List<ChessPosition> parsedPositions = new ArrayList<>();
        for (var position : positions) {
            parsedPositions.add(ChessPositionParser.parse(position));
        }

        final int legalDistance = 3;

        for (int destinationPointer = 1; destinationPointer < parsedPositions.size(); destinationPointer++) {

            ChessPosition start = parsedPositions.get(destinationPointer - 1);
            ChessPosition finish = parsedPositions.get(destinationPointer);

            var deltaX = Math.abs(finish.x() - start.x());
            var deltaY = Math.abs(finish.y() - start.y());

            if (deltaX + deltaY != legalDistance)
                throw new IllegalMoveException(start, finish);
        }
    }
}
