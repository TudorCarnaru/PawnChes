import java.util.ArrayList;

/**
 * Created by tcarnaru on 11/1/2016.
 */
public class Initializer {
    public int[][] Board = new int[9][9];
    public ArrayList<Pawn> BlackPawn = new ArrayList<Pawn>();
    public ArrayList<Pawn> WhitePawn = new ArrayList<Pawn>();
    public void initialize()
    {
        for( int i=1; i <9; i++)
            for(int j=1;j<9;j++)
                Board[i][j]=0;

        for( int i=1;i<9;i++) {
            Board[2][i] = 2;
            Pawn newPawn = new Pawn(2,i);
            BlackPawn.add(newPawn);
        }
        for( int i=1;i<9;i++) {
            Board[7][i] = 1;
            Pawn newPawn = new Pawn(7,i);
            WhitePawn.add(newPawn);
        }
    }
    public void testAfis()
    {
        for( int i=1; i <9; i++) {
            for (int j = 1; j < 9; j++) {
                System.out.print(Board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
