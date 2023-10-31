package croc.education.ws2023spb.knightsmove;

/**
 * Исключение, выбрасываемое в случае, если при перемещении шахматного коня из текущей клетки в следующую происходит с
 * нарушением правил.
 * 
 * @author Dmitry Malenok
 */
public class IllegalMoveException extends Exception {
    private final ChessPosition startPos;
    private final ChessPosition endPos;

    public IllegalMoveException(ChessPosition startPos, ChessPosition endPos){
        this.startPos = startPos;
        this.endPos = endPos;
    }

    @Override
    public String getMessage(){
        return "конь так не ходит: " + startPos + " -> " + endPos;
    }
}
