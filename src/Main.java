/**
 * Created by tcarnaru on 11/1/2016.
 */
public class Main {
    public static void main(String args[])
    {
        Initializer initializer = new Initializer();
        initializer.initialize();
        initializer.Board[6][1]=2;
        initializer.testAfis();
        Pawn testPawn = initializer.WhitePawn.get(1);
        testPawn.move(6,1,initializer.Board);
        initializer.testAfis();
    }
}
