package croc.education.ws2023spb.knightsmove;

/**
 * Исключение, выбрасываемое в случае, если при перемещении шахматного коня из текущей клетки в следующую происходит с
 * нарушением правил.
 *
 * @author Dmitry Malenok
 */
public class IllegalMoveException extends Exception {
    private final String currentPosition;
    private final String nextPosition;

    public IllegalMoveException(String currentPosition, String nextPosition) {
        this.currentPosition = currentPosition;
        this.nextPosition = nextPosition;
    }

    @Override
    public String getMessage() {
        return "конь так не ходит: " + currentPosition + " -> " + nextPosition;
    }
}
