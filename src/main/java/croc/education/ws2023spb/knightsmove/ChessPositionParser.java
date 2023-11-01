package croc.education.ws2023spb.knightsmove;

/**
 * Класс, содержащий методы преобразования в объект расположения фигуры на
 * шахматной доске из различных форматов.
 * 
 * @author Dmitry Malenok
 * @see ChessPosition
 */
public final class ChessPositionParser {

    /**
     * Конструктор.
     */
    private ChessPositionParser() {
        // Конструктор задан только для того, чтобы экземпляр класса случайно не
        // создали.
    }

    /**
     * Разбирает наименование клетки шахматной доски, на которой находится фигура, в
     * <a href="https://w.wiki/7pFN">шахматной нотации</a> и возвращает
     * соответствующий ей объект расположения фигуры на
     * шахматной доске.
     * 
     * @param position
     *                 наименование клетки шахматной доски, на которой находится
     *                 фигура
     * @return объект расположения фигуры на шахматной доске, соответствующий
     *         переданному наименованию клетки
     * @throws IllegalPositionException
     */
    public static ChessPosition parse(final String position) throws IllegalPositionException {
        if (position.length() != 2) {
            throw new IllegalPositionException(position);
        }
        int x = position.charAt(0) - 'a';
        int y = position.charAt(1) - '1';
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new IllegalPositionException(position);
        }
        return new ChessPosition() {

            @Override
            public int x() {
                return x;
            }

            @Override
            public int y() {
                return y;
            }

            @Override
            public String toString() {
                return position;
            }

        };
    }
}
