package croc.education.ws2023spb.knightsmove.GerasimikPavel;

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
        try {
            KnightsMoveChecker checker = KnightsMoveCheckerFactory.get();
            checker.check(args);
            System.out.print("OK");
        } catch (IllegalMoveException e) {
            System.out.print(e.getMessage());
        }
    }
}
