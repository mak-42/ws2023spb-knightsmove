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
    private static final Map<Character, Integer> mutableLetterToPositionX = new HashMap<>();
    static {
        mutableLetterToPositionX.put('a', 0);
        mutableLetterToPositionX.put('b', 1);
        mutableLetterToPositionX.put('c', 2);
        mutableLetterToPositionX.put('d', 3);
        mutableLetterToPositionX.put('e', 4);
        mutableLetterToPositionX.put('f', 5);
        mutableLetterToPositionX.put('g', 6);
        mutableLetterToPositionX.put('h', 7);
    }
    static Map<Character, Integer> letterToPositionX = Collections.unmodifiableMap(mutableLetterToPositionX);
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
        if ((position == null) || !position.matches("[a-h][1-8]")) {
            throw new IllegalPositionException("Наименование клетки должно состоять из двух символов: <колонка от 'a' до 'h'><строка от 1 до 8>");
        }

        char charX = position.charAt(0);
        int columnX = letterToPositionX.get(charX);

        char charY = position.charAt(1);
        int rowY = Character.getNumericValue(charY) - 1;

        return new ChessboardPosition(columnX, rowY);

    }
}
