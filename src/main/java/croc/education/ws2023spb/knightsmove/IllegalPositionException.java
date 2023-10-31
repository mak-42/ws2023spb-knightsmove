package croc.education.ws2023spb.knightsmove;
/**
 * Исключение, выбрасываемое в случае, если задается некорректное значение позиции фигуры
 *
 * @author Chernetsov Alexander
 */
public class IllegalPositionException extends RuntimeException{
    /**
     * Поле, содержащее номер позиции
     */
    private int number;
    /**
     * Поле, содержащее введенное значение первой координаты
     */
    public final String enteredPositionAtX;
    /**
     * Поле, содержащее введенное значение второй координаты
     */
    public final String enteredPositionAtY;
    /**
     * Поле, содержащее корректные значения первой координаты
     */
    public final String validPositionsAtX;
    /**
     * Поле, содержащее корректные значения второй координаты
     */
    public final String validPositionsAtY;

    /**
     *
     * @param number
     *              номер позиции в массиве
     * @param ex
     *          исключение парсера, который идентифицировал эту позицию как некорректную
     */
    public IllegalPositionException(int number, IllegalPositionException ex) {
        this.number = number;
        this.enteredPositionAtX = ex.enteredPositionAtX;
        this.enteredPositionAtY = ex.enteredPositionAtY;
        this.validPositionsAtX = ex.validPositionsAtX;
        this.validPositionsAtY = ex.validPositionsAtY;
    }

    /**
     *  Конструктор с параметрами, содержащие введенные и корректные значения для каждой координаты
     *
     * @param enteredPositionAtX
     *                          введенное значение первой координаты
     * @param enteredPositionAtY
     *                          введенное значение второй координаты
     * @param validPositionsAtX
     *                          корректные значения по первой координате
     * @param validPositionsAtY
     *                          корректные значения по второй координате
     */
    public IllegalPositionException(String enteredPositionAtX, String enteredPositionAtY,
                                    String validPositionsAtX, String validPositionsAtY) {
        this.enteredPositionAtX = enteredPositionAtX;
        this.enteredPositionAtY = enteredPositionAtY;
        this.validPositionsAtX = validPositionsAtX;
        this.validPositionsAtY = validPositionsAtY;
    }

    /**
     *  Конструктор с параметрами, содержащий введенные значения для каждой координаты и
     *  корректные значения для обеих координат
     *
     * @param enteredPositionAtX
     *                          введенное значение первой координаты
     * @param enteredPositionAtY
     *                          введенное значение второй координаты
     * @param validPositions
     *                      корректные значения для обеих координат
     */
    public IllegalPositionException(String enteredPositionAtX, String enteredPositionAtY,
                                    String validPositions) {
        this.enteredPositionAtX = enteredPositionAtX;
        this.enteredPositionAtY = enteredPositionAtY;
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
        StringBuilder message = new StringBuilder("Your " + number + " position: [" + enteredPositionAtX + enteredPositionAtY + "] ");
        if(enteredPositionAtX == null ||
                enteredPositionAtX.length() != 1 ||
                !validPositionsAtX.contains(enteredPositionAtX)){
            message.append("\nYour first coordinate must be one value from \"")
                    .append(validPositionsAtX)
                    .append("\", not ")
                    .append(enteredPositionAtX);
        }
        if(enteredPositionAtY == null ||
                enteredPositionAtY.length() != 1 ||
                !validPositionsAtY.contains(enteredPositionAtY)){
            message.append("\nYour second coordinate must be one value from \"")
                    .append(validPositionsAtY)
                    .append("\", not ")
                    .append(enteredPositionAtY);
        }
        return message.toString();
    }
}
