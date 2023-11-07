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
                Position[] parsedPositions = Arrays.stream(positions)
                        .map(ChessPositionParser::parse)
                        .toArray(Position[]::new);
                for (int i = 0; i < positions.length - 1; i++) {
                    var p1 = parsedPositions[i];
                    var p2 = parsedPositions[i + 1];
                    check = (((Math.abs(p1.x() - p2.x()) == 2) && (Math.abs(p1.y() - p2.y()) == 1))
                            || ((Math.abs(p1.x() - p2.x()) == 1) && (Math.abs(p1.y() - p2.y()) == 2)));
                    if (!check) {
                        throw new IllegalMoveException(p1, p2);
                    }
                }
            }
        };
    }
}
