package croc.education.ws2023spb.knightsmove;

/**
 * Исключение, выбрасываемое в случае, если при перемещении шахматного коня из текущей клетки в следующую происходит с
 * нарушением правил.
 * 
 * @author Dmitry Malenok
 */
public class IllegalMoveException extends Exception {
    private String fromPosition;
    private String toPosition;
    // TODO: наполнить класс.
    public IllegalMoveException(String message) {
        super(message.trim());
       // this.fromPosition=fromPosition;
        //this.toPosition=toPosition;
    }
}
