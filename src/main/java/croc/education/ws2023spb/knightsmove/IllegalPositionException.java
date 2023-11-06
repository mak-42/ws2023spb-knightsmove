package croc.education.ws2023spb.knightsmove;

public class IllegalPositionException extends RuntimeException {
    public IllegalPositionException(String position) {
        super("Неверно заданная длина шахматной аннотации: " + position + " - введите позицию двумя литералами");

    }

    public IllegalPositionException(int x, int y) {
        super("Неверно заданные координаты: " + x + ", " + y + " - введите цифры от 0 до 7.");

    }

    public IllegalPositionException(String position, char number) {
        super("Неверно определена: " + position  +  " - введите вместо второго литерала \"" + number + "\" от 1 до 8.");
    }


    public IllegalPositionException(char letter, String position) {
        super("Неверно определена: " + position  + " - введите вместо второго литерала \"" + letter + "\" латинскую букву от a до h.");
    }
}