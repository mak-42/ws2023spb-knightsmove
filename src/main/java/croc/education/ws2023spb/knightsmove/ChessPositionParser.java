package croc.education.ws2023spb.knightsmove;

/**
 * Класс, содержащий методы преобразования в объект расположения фигуры на шахматной доске из различных форматов.
 *
 * @author Dmitry Malenok
 * @see IChessPosition
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
    public static ChessPosition parse(final String position) throws IllegalPositionException {
        if (position.length() > 2) {
            throw new IllegalPositionException("X position must be between a and h, Y position must be between 1 and 8");
        }
        int column = position.toLowerCase().charAt(0) - 97;
        int line = position.toLowerCase().charAt(1) - 49;
        return new ChessPosition(column, line);
    }
}
