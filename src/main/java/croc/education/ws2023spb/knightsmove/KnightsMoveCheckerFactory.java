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
        return (String[] positions) -> {
            if (positions.length > 1) {
                for (int i = 1; i < positions.length; i++) {
                    ChessPosition current = ChessPositionParser.parse(positions[i - 1]);
                    ChessPosition next = ChessPositionParser.parse(positions[i]);
                    int dx = Math.abs(current.x() - next.x());
                    int dy = Math.abs(current.y() - next.y());

                    if (!((dx == 1 && dy == 2) || (dx == 2 && dy == 1))) {
                        throw new IllegalMoveException(positions[i - 1], positions[i]);
                    }
                }
            } else if (positions.length == 1) {
                ChessPositionParser.parse(positions[0]);
                System.out.println("Вы ввели всего одну позицию, коню некуда ходить!");
            } else {
                System.out.println("Вы не ввели ни одной позиции.");
            }
        };
    }
}
