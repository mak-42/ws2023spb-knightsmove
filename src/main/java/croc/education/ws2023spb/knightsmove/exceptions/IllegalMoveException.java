package croc.education.ws2023spb.knightsmove.exceptions;

import croc.education.ws2023spb.knightsmove.ChessPosition;

/**
 * Исключение, выбрасываемое в случае, если при перемещении шахматного коня из текущей клетки в следующую происходит с
 * нарушением правил.
 * 
 * @author Dmitry Malenok
 */
public class IllegalMoveException extends Exception {
    public IllegalMoveException(String errorMessage) {
        super(errorMessage);
    }
    public IllegalMoveException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public IllegalMoveException(ChessPosition start, ChessPosition finish) {
        super(String.format("конь так не ходит: %s -> %s", start, finish));
    }
}