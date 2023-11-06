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
        // TODO: реализовать логику исполнения программы.
        if (args.length < 2) {
            System.out.println("Введите больше >=2 аргументов");
            return;
        }
        KnightsMoveChecker checker = KnightsMoveCheckerFactory.get();
        try {
            checker.check(args);
            System.out.print("OK");
        } catch (IllegalMoveException knightIllegalMove) {
            System.out.print(knightIllegalMove.getMessage());
        }
    }
}
