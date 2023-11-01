package croc.education.ws2023spb.knightsmove;

/**
 * Обработчик, проверяющий, что последовательность клеток на шахматной доске может быть пройдена ходом коня.
 *
 * @author Dmitry Malenok
 */
public interface KnightsMoveChecker {
    void check(String[] positions) throws IllegalMoveException;
}
