package croc.education.ws2023spb.knightsmove;
/**
 * Исключение, выбрасываемое в случае, если задается некорректное значение позиции фигуры
 *
 * @author Chernetsov Alexander
 */
public class IllegalPositionException extends RuntimeException{
    /**
     * Поля, содержащие корректные значения
     */
    public final String validPositionsAtX;
    public final String validPositionsAtY;

    /**
     *  Конструктор с параметрами, содержащие корректные значения для каждой координаты
     * @param validPositionsAtX
     *                          корректные значения по первой координате
     * @param validPositionsAtY
     *                          корректные значения по второй координате
     *
     */
    public IllegalPositionException(String validPositionsAtX,String validPositionsAtY){
        this.validPositionsAtX = validPositionsAtX;
        this.validPositionsAtY = validPositionsAtY;
    }

    /**
     *  Конструктор с параметрами, содержащий корректные значения для обеих координат
     * @param validPositions
     *                       корректные значения по двум координатам
     */
    public IllegalPositionException(String validPositions){
        this.validPositionsAtX = validPositions;
        this.validPositionsAtY = validPositions;
    }

    /**
     * Перегрузка метода получения сообщения ошибки
     * @return
     *          информация о корректных значениях координат
     */
    @Override
    public String getMessage(){
        return "X must be one value from " + validPositionsAtX +
                ", Y must be one value from " + validPositionsAtY;
    }
}
