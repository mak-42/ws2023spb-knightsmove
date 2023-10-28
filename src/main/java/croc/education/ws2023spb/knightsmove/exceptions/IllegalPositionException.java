package croc.education.ws2023spb.knightsmove.exceptions;

/**
 * Исключение, выбрасываемое в случае, если при перемещении шахматного коня из текущей клетки в следующую происходит с
 * нарушением правил.
 *
 * @author Dmitry Malenok
 */
public class IllegalPositionException extends IndexOutOfBoundsException {
    public IllegalPositionException(String errorMessage) {
        super(errorMessage);
    }
}
