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
        Pawn testPawn = initializer.WhitePawn.get(0);
        testPawn.move(5,1,initializer.Board);
        initializer.testAfis();
        initializer.AI(initializer.BlackPawn,initializer.Board);
    }
}
