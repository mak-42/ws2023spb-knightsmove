package croc.education.ws2023spb.knightsmove;

/**
 * Класс, реализующий фабричный метод, возвращающий обработчики, проверяющие,
 * что последовательность клеток на шахматной
 * доске может быть пройдена ходом коня.
 *
 * @author Dmitry Malenok
 */
public final class KnightsMoveCheckerFactory {

    /**
     * Конструктор.
     */
    private KnightsMoveCheckerFactory() {
        // Конструктор задан только для того, чтобы экземпляр класса случайно не
        // создали.
    }

    /**
     * Возвращает обработчик, проверяющий, что последовательность клеток на
     * шахматной доске может быть пройдена ходом
     * коня.
     *
     * @return обработчик, проверяющий, что последовательность клеток на шахматной
     *         доске может быть пройдена ходом коня
     */
    public static KnightsMoveChecker get() {
        return new KnightsMoveChecker() {
            @Override
            public void check(String[] positions) throws IllegalMoveException {
                ChessPosition pos;
                try {
                    pos = ChessPositionParser.parse(positions[0]);
                    for (int i = 1; i < positions.length; i++) {
                        ChessPosition nextPos = ChessPositionParser.parse(positions[i]);
                        int dx = nextPos.x() - pos.x();
                        int dy = nextPos.y() - pos.y();
                        if (Math.abs(dx) + Math.abs(dy) != 3 || dx * dy == 0) {
                            throw new IllegalMoveException(
                                    "конь так не ходит: " + pos + " -> " + nextPos);
                                    
                        }
                        pos = nextPos;
                    }
                } catch (IllegalPositionException e) {
                    throw new IllegalMoveException(
                            "некорректная позиция: " + e.getMessage());
                }
            }
        };
    }
}
