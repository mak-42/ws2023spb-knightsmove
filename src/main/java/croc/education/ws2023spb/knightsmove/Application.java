package croc.education.ws2023spb.knightsmove;

import croc.education.ws2023spb.knightsmove.exceptions.IllegalMoveException;

/**
 * Приложение, проверяющее возможность прохождения последовательности клеток на шахматной доске ходом коня.
 */
public final class Application {

    /**
     * Основной метод приложения.
     *
     * @param args
     *            аргументы
     */
    public static void main(final String[] args) {
//        if (args.length < 2) System.out.println("Конь так не ходит");

        var checker = KnightsMoveCheckerFactory.get();

        try {
            checker.check(args);
            System.out.print("OK");
        }
        catch (IllegalMoveException e){
            System.out.print(e.getMessage());
        }
    }
}
