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
        return new KnightsMoveChecker() {
            @Override
            public void check(String[] positions) throws IllegalMoveException, IllegalPositionException {
                boolean check = true;
                Position p1 = null;
                Position p2 = null;
                for (int i = 0; i < positions.length - 1 && check; i++) {
                    p1 = (Position) ChessPositionParser.parse(positions[i]);
                    p2 = (Position) ChessPositionParser.parse(positions[i + 1]);
                    check = (((Math.abs(p1.x() - p2.x()) == 2) && (Math.abs(p1.y() - p2.y()) == 1))
                            || ((Math.abs(p1.x() - p2.x()) == 1) && (Math.abs(p1.y() - p2.y()) == 2)));
                }
                if (!check) {
                    throw new IllegalMoveException(p1, p2);
                }
            }
        };
    }
}
