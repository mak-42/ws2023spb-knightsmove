package croc.education.ws2023spb.knightsmove;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, реализующий фабричный метод, возвращающий обработчики, проверяющие, что последовательность клеток на шахматной
 * доске может быть пройдена ходом коня.
 *
 * @author Dmitry Malenok
 */
public final class KnightsMoveCheckerFactory {

    /**
     * Конструктор.
     */
    private KnightsMoveCheckerFactory() {
        // Конструктор задан только для того, чтобы экземпляр класса случайно не создали.
    }

    /**
     * Возвращает обработчик, проверяющий, что последовательность клеток на шахматной доске может быть пройдена ходом
     * коня.
     *
     * @return обработчик, проверяющий, что последовательность клеток на шахматной доске может быть пройдена ходом коня
     */
    public static KnightsMoveChecker get() {
        return positions -> {
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

                if (deltaX + deltaY != legalDistance || Math.abs(deltaX - deltaY) != 1)
                    throw new IllegalMoveException(start, finish);
            }
        };
    }
}
