package croc.education.ws2023spb.knightsmove.GerasimikPavel;

/**
 * Класс, содержащий методы преобразования в объект расположения фигуры на шахматной доске из различных форматов.
 *
 * @author Dmitry Malenok
 * @see ChessPosition
 */
public final class ChessPositionParser {

    /**
     * Конструктор.
     */
    private ChessPositionParser() {
        // Конструктор задан только для того, чтобы экземпляр класса случайно не создали.
    }

    /**
     * Разбирает наименование клетки шахматной доски, на которой находится фигура, в
     * <a href="https://w.wiki/7pFN">шахматной нотации</a> и возвращает соответствующий ей объект расположения фигуры на
     * шахматной доске.
     *
     * @param position наименование клетки шахматной доски, на которой находится фигура
     * @return объект расположения фигуры на шахматной доске, соответствующий переданному наименованию клетки
     */
    public static ChessPosition parse(String position)  {
        if (position.length() != 2) {
            throw new IllegalPositionException(position);
        }
        char column = position.charAt(0);
        char row = position.charAt(1);
        if ((column < 'a' || column > 'h') || (row < '1' || row > '8')) {
            throw new IllegalPositionException(position);
        }
        int x = column - 'a';
        int y = row - '1';
        return new ChessPositionImpl(x, y);
    }
}
