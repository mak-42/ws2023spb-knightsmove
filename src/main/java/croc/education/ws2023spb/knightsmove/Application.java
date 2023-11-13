package croc.education.ws2023spb.knightsmove;

/**
 * Приложение, проверяющее возможность прохождения последовательности клеток на
 * шахматной доске ходом коня.
 */
public final class Application {

    /**
     * Основной метод приложения.
     *
     * @param args
     *             аргументы
     * @throws IllegalMoveException
     */
    public static void main(final String[] args) {
        try {
            KnightsMoveCheckerFactory.get().check(args);
            System.out.println("OK");
        } catch (IllegalMoveException e) {
            System.out.print(e.getMessage());
        }
    }
}
