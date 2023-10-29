package croc.education.ws2023spb.knightsmove;
/**
 * Класс, работающий с координатами клетки
 *
 * @author Chernetsov Alexander
 * @see ChessPosition
 */
public class ChessPositionClass implements  ChessPosition{
    /**
     * Поле, содержащее корректные значения координат
     */
    public static final String validPositions = "01234567";
    /**
     * Поля, содержащие координаты
     */
    private int x;
    private int y;

    /**
     * Конструктор, задающий координаты
     * @param x
     *          значение первой координаты
     * @param y
     *          значение второй координаты
     * @throws IllegalPositionException
     *                                  исключение, выбрасываемое в случае некорректных значений полей
     */
    public ChessPositionClass(int x, int y) throws IllegalPositionException {
        setX(x);
        setY(y);
    }

    /**
     * Геттер первой координаты
     * @return
     *         значение первой координаты
     */
    @Override
    public int x() {
        return x;
    }

    /**
     * Геттер второй координаты
     * @return
     *         значение второй координаты
     */
    @Override
    public int y() {
        return y;
    }

    /**
     * Сеттер первой координаты
     * @param x
     *         значение первой координаты
     * @throws IllegalPositionException
     *                                 исключение, выбрасываемое в случае некорректного значения поля
     */
    public void setX(int x) throws IllegalPositionException {
        if(x > 7 || x < 0){
            throw new IllegalPositionException(validPositions);
        }
        this.x = x;
    }

    /**
     * Сеттер второй координаты
     * @param y
     *         значение второй координаты
     * @throws IllegalPositionException
     *                                 исключение, выбрасываемое в случае некорректного значения поля
     */
    public void setY(int y) throws IllegalPositionException {
        if(y > 7 || y < 0){
            throw new IllegalPositionException(validPositions);
        }
        this.y = y;
    }

    /**
     * Возвращает наименование клетки шахматной доски, на которой находится фигура, в
     * <a href="https://w.wiki/7pFN">шахматной нотации</a>.
     *
     * @return наименование клетки шахматной доски, на которой находится фигура, в шахматной нотации
     */
    @Override
    public String toString() {
        return String.valueOf(ChessPositionParser.validPositionsAtX.charAt(x)) +
                String.valueOf(ChessPositionParser.validPositionsAtY.charAt(y));
    }
}
