package croc.education.ws2023spb.knightsmove;

/**
 * Исключение, выбрасываемое в случае, если объявденная клетка не существует на доске
 *
 * @author Alexander Samsonov
 */
public class IllegalPositionException extends IndexOutOfBoundsException {
    public IllegalPositionException(String errorMessage) {
        super(errorMessage);
    }
}
