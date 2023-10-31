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
        // Решил сделать через анонимный класс
        return new KnightsMoveChecker() {
            @Override
            public void check(String[] positions) throws IllegalMoveException {
                for (int i = 0; i < positions.length - 1; i++) {
                    if (!moveCanBeMade(positions[i], positions[i + 1])) {
                        throw new IllegalMoveException("конь так не ходит: " + positions[i] + " -> " + positions[i + 1]);
                    }
                }
                System.out.print("OK");
            }

            // По ощущениям, немного кринжово сделано, но первое, что пришло в голову и что вроде как работает
            private boolean moveCanBeMade(String start, String finish) {
                List<String> possibleMoves = new ArrayList<>();
                ChessPosition chessPosition = ChessPositionParser.parse(start);
                int startX = chessPosition.x();
                int startY = chessPosition.y();
                int[] offsets = new int[]{-2, -1, 1, 2};

                for (int dx : offsets) {
                    for (int dy : offsets) {
                        if (Math.abs(dx) != Math.abs(dy) && moveIsValid(chessPosition, dx, dy)) {
                            possibleMoves.add(new ChessPositionImpl(startX + dx, startY + dy).toString());
                        }
                    }
                }

                return possibleMoves.contains(finish);
            }

            // Вынес проверку на возможность хода в отдельный метод
            private boolean moveIsValid(ChessPosition chessPosition, int dx, int dy) {
                return (chessPosition.x() + dx >= 0) && (chessPosition.x() + dx <= 7) &&
                        (chessPosition.y() + dy >= 0) && (chessPosition.y() + dy <= 7);
            }
        };
    }
}
