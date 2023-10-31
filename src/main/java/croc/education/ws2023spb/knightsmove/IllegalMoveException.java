package croc.education.ws2023spb.knightsmove;

/**
 * Исключение, выбрасываемое в случае, если при перемещении шахматного коня из текущей клетки в следующую происходит с
 * нарушением правил.
 * 
 * @author Dmitry Malenok
 */
public class IllegalMoveException extends Exception {
    private ChessPosition p1;
    private ChessPosition p2;

    public IllegalMoveException() {
    }

    public IllegalMoveException(ChessPosition p1, ChessPosition p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public String getMessage() {
        return "Конь так не ходит: " + p1 + " -> " + p2;
    }
}
