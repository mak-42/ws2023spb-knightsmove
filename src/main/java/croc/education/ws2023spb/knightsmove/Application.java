package croc.education.ws2023spb.knightsmove;

/**
 * Приложение, проверяющее возможность прохождения последовательности клеток на шахматной доске ходом коня.
 */
public final class Application {

    /**
     * Основной метод приложения.
     *
     * @param args аргументы
     */
    public static void main(final String[] args) {
        String output = "OK";
        try {
            KnightsMoveCheckerFactory.get().check(args);
        } catch (IllegalMoveException e) {
            output = e.getMessage();
        }
        System.out.print(output);
    }
}
