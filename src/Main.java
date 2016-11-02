import java.util.Scanner;

/**
 * Created by tcarnaru on 11/1/2016.
 */
public class Main {
    public static void main(String args[])
    {
        Initializer initializer = new Initializer();
        initializer.initialize();
        initializer.testAfis();
        Pawn testPawn;
        int ok=0;
        while(ok!=1)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Select a pawn from 1-8");
            int x = scan.nextInt();
            while(x<1||x>8)
            {
                System.out.println("Select a pawn from 1-8!!!!");
                x = scan.nextInt();
            }
            x=x-1;
            testPawn = initializer.WhitePawn.get(x);
            System.out.println("Select a position on the board to move the pawn in the x y coords format");
            int y = scan.nextInt();
            int z = scan.nextInt();
            while(testPawn.move(y,z,initializer.Board)!=1)
            {
                System.out.println("Select a position on the board to move the pawn in the x y coords format");
                y = scan.nextInt();
                z = scan.nextInt();
            }
            System.out.println("Your move");
            initializer.testAfis();
            initializer.AI(initializer.BlackPawn,initializer.Board);
            System.out.println("PC move");
            initializer.testAfis();
            for(int i=1;i<=8;i++)
            {
                if( initializer.Board[1][i]!=0 || initializer.Board[8][i]!=0)
                {
                    ok=1;
                    if(initializer.Board[1][i]==1) System.out.println("Player wins!");
                    else if(initializer.Board[8][i]==2) System.out.println("PC Master-race wins!");
                }
            }
        }
    }
}
