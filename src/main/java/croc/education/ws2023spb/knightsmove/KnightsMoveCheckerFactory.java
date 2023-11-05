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
        // Решил сделать через анонимный класс
        return new KnightsMoveChecker() {
            @Override
            public void check(String[] positions) throws IllegalMoveException {
                for (int i = 0; i < positions.length - 1; i++) {
                    if (!moveCanBeMade(positions[i], positions[i + 1])) {
                        throw new IllegalMoveException("конь так не ходит: " + positions[i] + " -> " + positions[i + 1]);
                    }
                }
            }

            private boolean moveCanBeMade(String start, String finish) {
                ChessPosition chessPositionStart = ChessPositionParser.parse(start);
                ChessPosition chessPositionFinish = ChessPositionParser.parse(finish);

                int dx = Math.abs(chessPositionStart.x() - chessPositionFinish.x());
                int dy = Math.abs(chessPositionStart.y() - chessPositionFinish.y());

                return dx == 1 && dy == 2 || dx == 2 && dy == 1;
            }
        };
    }
}
