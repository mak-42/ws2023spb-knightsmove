package croc.education.ws2023spb.knightsmove;

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
            final int LEGAL_DISTANCE = 3;
            ChessPosition prev = null;

            for (var position : positions) {
                var cur = ChessPositionParser.parse(position);

                if (prev == null) {
                    prev = cur;
                    continue;
                }

                var deltaX = Math.abs(cur.x() - prev.x());
                var deltaY = Math.abs(cur.y() - prev.y());

                if (deltaX + deltaY != LEGAL_DISTANCE || Math.abs(deltaX - deltaY) != 1)
                    throw new IllegalMoveException(prev, cur);
                prev = cur;
            }
        };
    }
}
