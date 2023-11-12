package croc.education.ws2023spb.knightsmove;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс, содержащий методы преобразования в объект расположения фигуры на шахматной доске из различных форматов.
 * 
 * @author Dmitry Malenok
 * @see ChessPosition
 */
public final class ChessPositionParser {
    private static final Map<Character, Integer> letterToPositionX = Map.of(
            'a',0,
            'b',1,
            'c',2,
            'd',3,
            'e', 4,
            'f', 5,
            'g', 6,
            'h', 7
    );
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
     * @param position
     *            наименование клетки шахматной доски, на которой находится фигура
     * @return объект расположения фигуры на шахматной доске, соответствующий переданному наименованию клетки
     */
    public static ChessPosition parse(final String position) {
        if ((position == null)) {
            throw new IllegalPositionException("Наименование клетки должно состоять из двух символов: <колонка от 'a' до 'h'><строка от 1 до 8>");
        }
        if (!position.matches("[a-h][1-8]")) {
            if (position.matches("(.*)[1-8]")) {
                throw new IllegalPositionException(String.format("Наименование клетки %s введено неверно. Колонка %c должна быть 'a' до 'h'",position, position.charAt(0)));
            }
            else if (position.matches("[a-h](.*)")) {
                throw new IllegalPositionException(String.format("Наименование клетки %s введено неверно. Строка %c должна быть 1 до 8",position, position.charAt(1)));
            }
            throw new IllegalPositionException(String.format("Наименование клетки %s введено неверно. Колонка %c должна быть 'a' до 'h', Строка %c должна быть 1 до 8", position, position.charAt(0), position.charAt(1)));
        }

        char charX = position.charAt(0);
        int columnX = letterToPositionX.get(charX);

        char charY = position.charAt(1);
        int rowY = Character.getNumericValue(charY) - 1;

        return new ChessboardPosition(columnX, rowY);

    }
}
