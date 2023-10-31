package croc.education.ws2023spb.knightsmove;


/**
 * Класс, содержащий методы преобразования в объект расположения фигуры на шахматной доске из различных форматов.
 *
 * @author Dmitry Malenok
 * @see ChessPosition
 */
public final class ChessPositionParser {
    /**
     * Корректные наименования первой координаты
     */
    public static final String validPositionsAtX = "abcdefgh";
    /**
     * Корректные наименования второй координаты
     */
    public static final String validPositionsAtY = "12345678";

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
        if (position == null || position.length() == 0) {
            throw new IllegalPositionException(null, null, validPositionsAtX, validPositionsAtY);
        }

        String x = String.valueOf(position.charAt(0));
        if (position.length() == 1) {
            throw new IllegalPositionException(x, null, validPositionsAtX, validPositionsAtY);
        }

        if (position.length() != 2) {
            throw new IllegalPositionException(x, position.substring(1), validPositionsAtX, validPositionsAtY);
        }

        String y = String.valueOf(position.charAt(1));
        int indexX = validPositionsAtX.indexOf(x);
        int indexY = validPositionsAtY.indexOf(y);

        if (indexX == -1 || indexY == -1) {
            throw new IllegalPositionException(x, y, validPositionsAtX, validPositionsAtY);
        }
        return new ChessPositionClass(indexX, indexY);
    }
}
