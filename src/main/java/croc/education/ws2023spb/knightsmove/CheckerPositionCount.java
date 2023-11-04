package croc.education.ws2023spb.knightsmove;

public class CheckerPositionCount {
    public static boolean check (String[] str) {
        if (str.length >= 2) {
            return true;
        } else {
            throw new PositionCountException();
        }
    }
}
