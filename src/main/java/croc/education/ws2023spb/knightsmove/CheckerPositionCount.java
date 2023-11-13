package croc.education.ws2023spb.knightsmove;

public class CheckerPositionCount {
    public static void checkPositionCount(String[] str) throws PositionCountException {
        if (str.length < 2) {
            throw new PositionCountException();
        }
    }
}
