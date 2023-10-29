package croc.education.ws2023spb.knightsmove;

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
        String[] test = {};
        try {
            KnightsMoveCheckerFactory.get().check(test);
            System.out.print("OK");
        } catch(IllegalPositionException | IllegalMoveException ex){
            System.out.print(ex.getMessage());
        }
    }
}
