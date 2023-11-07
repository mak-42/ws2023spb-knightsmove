package croc.education.ws2023spb.knightsmove;

public class IllegalPositionException extends RuntimeException {

    public IllegalPositionException(String message) {
        super(message);
    }

    public IllegalPositionException(int x, int y) {
        super("Неверно заданные координаты: " + x + ", " + y + " - введите цифры от 0 до 7.");

    }


    public static class IllegalPositionExceptionBuilder extends RuntimeException {
        private String position;
        private char letter, number;
        private boolean isValidLength, isValidLetter, isValidNumber;

        public IllegalPositionExceptionBuilder(boolean isValidLength, boolean isValidLetter, boolean isValidNumber) {
            this.isValidLength = isValidLength;
            this.isValidLetter = isValidLetter;
            this.isValidNumber = isValidNumber;
        }

        public IllegalPositionExceptionBuilder setPosition(String position) {
            this.position = position;
            return this;
        }

        public IllegalPositionExceptionBuilder setLetter(char letter) {
            this.letter = letter;
            return this;
        }

        public IllegalPositionExceptionBuilder setNumber(char number) {
            this.number = number;
            return this;
        }

        public IllegalPositionException build() {
            String errorMessage = "Неверно определена: " + position + " - введите  ";
            if (isValidLength) {
                errorMessage += "позицию двумя литерами";
                return new IllegalPositionException(errorMessage);
            }
            if (isValidLetter) {
                errorMessage += "вместо \"" + letter + "\" латинскую букву от a до h; ";
            }
            if (isValidNumber) {
                errorMessage += "вместо \"" + number + "\" цифру от 1 до 8.";
            }
            return new IllegalPositionException(errorMessage);
        }

    }
}
