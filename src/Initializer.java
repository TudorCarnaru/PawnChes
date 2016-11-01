import java.util.ArrayList;
import java.util.Hashtable;

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

    public void AI(ArrayList<Pawn> Pawns, int [][] Board)
    {
        Hashtable MinMax = new Hashtable();
        int max =0;
        for( Pawn pawn: Pawns)
        {
            int value=0;
            int x=pawn.posX, y=pawn.posY;
            int x1=x+1;
            int x2=x+2;
            if(x+1<9 && y+1<9 && y-1<9 && Board[x+1][y-1]==1 || x+1<9 && y+1<9 && y-1<9 && Board[x+1][y+1]==1 )
            {
                value+=1;
                if(Board[x+1][y+1]==1)
                {
                    x=x+1;
                    y=y+1;
                    if(Board[x+1][y+1]==1|| Board[x+1][y-1]==1) value=0;
                }
                else if (Board[x+1][y-1]==1)
                {
                    x=x+1;
                    y=y-1;
                    if(Board[x+1][y+1]==1|| Board[x+1][y-1]==1) value=0;
                }
                else value=+1;
                MinMax.put(pawn,value);
            }
            else if(Board[x+2][y]==0 && Board[x+1][y]==0)
            {
                value+=2;
                MinMax.put(pawn,value);
            }
            else if(Board[x+1][y]==0)
            {
                value+=1;
                MinMax.put(pawn,value);
            }
            else MinMax.put(pawn,value);
        }
        System.out.println(MinMax.size());
        for(Pawn pawn : Pawns)
        {
            System.out.print(MinMax.get(pawn) + " ");
        }
    }

}
