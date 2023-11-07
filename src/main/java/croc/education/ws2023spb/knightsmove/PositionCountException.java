package croc.education.ws2023spb.knightsmove;

public class PositionCountException extends Exception{
    @Override
    public String getMessage() {
        return "Пожалуйста, укажите как минимум две позиции";
    }
}
