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
        private char letter,number;

        public IllegalPositionExceptionBuilder setPosition(String position){
            this.position=position;
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
        public IllegalPositionException build(){
            String errorMessage="Неверно определена: "+position+" - введите  ";
            if(position.length() != 2){
                errorMessage+="позицию двумя литерами";
                return new IllegalPositionException(errorMessage);
            }
            if (letter < 'a' || letter > 'h'){
                errorMessage+= "вместо \""+letter+ "\" латинскую букву от a до h; ";
            }
            if (number - '0'  < 1 || number - '0' > 8){
                errorMessage+= "вместо \""+number+"\" цифру от 1 до 8.";
            }
            return new IllegalPositionException(errorMessage);
        }
    }
}
