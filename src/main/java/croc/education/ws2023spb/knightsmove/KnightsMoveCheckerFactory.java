package croc.education.ws2023spb.knightsmove;

import java.util.Arrays;

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
            public void check(String[] positions) throws IllegalMoveException {
                boolean check = true;
                Position p1 = (Position) ChessPositionParser.parse(positions[0]);
                for (int i = 1; i < positions.length; i++) {
                    var p2 = (Position) ChessPositionParser.parse(positions[i]);
                    check = (((Math.abs(p1.x() - p2.x()) == 2) && (Math.abs(p1.y() - p2.y()) == 1))
                            || ((Math.abs(p1.x() - p2.x()) == 1) && (Math.abs(p1.y() - p2.y()) == 2)));
                    if (!check) {
                        throw new IllegalMoveException(p1, p2);
                    }
                    p1 = p2;
                }
            }
        };
    }
}
