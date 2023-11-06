package croc.education.ws2023spb.knightsmove;

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
    public static ChessPosition parse(final String position) throws IllegalPositionException {
        int x, y;
        // TODO: создать реализацию метода.
        if (position.length() != 2) {
            throw new IllegalPositionException(position);
        }
        char letter = position.charAt(0);
        char number = position.charAt(1);
        if (letter < 'a' || letter > 'h') {
            throw new IllegalPositionException(letter,position);
        }
        if (number - '0'  < 1 || number - '0' > 8) {
           throw new IllegalPositionException(position,number);
        }
        x = letter - 'a';
        y = number - '1';
        return new MyChessPosition(x, y);
    }
}


