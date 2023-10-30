package croc.education.ws2023spb.knightsmove;
/**
 * Класс, работающий с координатами клетки
 *
 * @author Chernetsov Alexander
 * @see ChessPosition
 */
public class ChessPositionClass implements  ChessPosition{
    /**
     * Поле, содержащее первую координату
     */
    private int x;
    /**
     * Поле, содержащее вторую координату
     */
    private int y;

    /**
     * Конструктор, задающий координаты
     * @param x
     *          значение первой координаты
     * @param y
     *          значение второй координаты
     */
    public ChessPositionClass(int x, int y) {
        this.x = x;
        this.y = y;
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
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Сеттер второй координаты
     * @param y
     *         значение второй координаты
     */
    public void setY(int y){
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
