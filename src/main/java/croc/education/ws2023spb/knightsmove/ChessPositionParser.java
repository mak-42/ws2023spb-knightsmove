package croc.education.ws2023spb.knightsmove;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс, содержащий методы преобразования в объект расположения фигуры на шахматной доске из различных форматов.
 * 
 * @author Dmitry Malenok
 * @see ChessPosition
 */
public final class ChessPositionParser {
    private static Map<Character, Integer> chessColumns = new HashMap<>();

    // По ощущениям заполнение этой мапы можно было сделать элегантнее, но выбрал самый банальный вариант
    static {
        chessColumns.put('a', 0);
        chessColumns.put('b', 1);
        chessColumns.put('c', 2);
        chessColumns.put('d', 3);
        chessColumns.put('e', 4);
        chessColumns.put('f', 5);
        chessColumns.put('g', 6);
        chessColumns.put('h', 7);
        chessColumns = Collections.unmodifiableMap(chessColumns);
    }
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
    public static ChessPosition parse(final String position) throws IllegalPositionException{
        if (position.length() != 2) {
            throw new IllegalPositionException("Unknown position : " + position);
        }

        if (chessColumns.get(position.charAt(0)) == null) {
            throw new IllegalPositionException("Unknown position : " + position);
        }

        int x = chessColumns.get(position.charAt(0));

        Pattern pattern = Pattern.compile("[1-7]");
        Matcher matcher = pattern.matcher(position.substring(1, 2));

        if (!matcher.matches()) {
            throw new IllegalPositionException("Unknown position : " + position);
        }

        int y = Character.getNumericValue(position.charAt(1));

        return new ChessPositionImpl(x, y);
    }
}
