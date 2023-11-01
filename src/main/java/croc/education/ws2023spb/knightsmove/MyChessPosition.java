package croc.education.ws2023spb.knightsmove;

public class MyChessPosition implements ChessPosition{
private int x;
private int y;
    public MyChessPosition(int x,int y) throws IllegalPositionException {
        if ((x >= 0 && x <= 7) && (y >= 0 && y <= 7)) {
            this.x = x;
            this.y = y;
        }else{
            throw new IllegalPositionException("Неверно заданные координаты");
        }
    }
    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }
    @Override
   public String toString(){
        return ((char) ('a' + x)) +Integer.toString(y+1);
    }
}
