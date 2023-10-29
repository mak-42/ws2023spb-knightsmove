package croc.education.ws2023spb.knightsmove;

import croc.education.ws2023spb.knightsmove.exceptions.IllegalMoveException;

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
            void check(String... positions) throws IllegalMoveException {
                super.check(positions);
            }
        };
    }
}
