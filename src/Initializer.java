

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

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
//    public void afiss()
//    {
//
//        for(int i=1;i<9;i++) System.out.print(i);
//    }

    public void testAfis()
    {
        //System.out.println("Linii");
        System.out.print("    ");
        for(int i=1;i<9;i++) System.out.print(i+ " ");
        System.out.println(" ");
        for( int i=1; i <9; i++) {
            System.out.print(i + "   " );
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
            else if(Board[x+2][y]==0 && Board[x+1][y]==0 &&x<4)
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
            if(max<(int)MinMax.get(pawn)) max=(int)MinMax.get(pawn);
        }
        Random rand=  new Random();
        int randomNum = rand.nextInt((8) + 1) + 0;
        int ok = 0;
        Pawn pawnToMove = new Pawn(0,0);
        while(ok!=1) {
            int i = 0;
            for (Pawn pawn : Pawns) {
                if (max == (int) MinMax.get(pawn))
                {
                    pawnToMove = pawn;
                    ok=1;
                }
                i++;
                if (i > randomNum) break;
            }
        }
        MoveAI(pawnToMove,Board);
    }
    public void MoveAI(Pawn pawn, int [][] Board )
    {
        int x=pawn.posX, y=pawn.posY;
        if(x+1<9 && y+1<9 && y-1<9 && Board[x+1][y-1]==1 || x+1<9 && y+1<9 && y-1<9 && Board[x+1][y+1]==1 )
        {
            System.out.println("Ajunge1");
            if(Board[x+1][y+1]==1)
            {
                Board[pawn.posX][pawn.posY]=0;
                pawn.posX=x+1;
                pawn.posY=y+1;
                Board[pawn.posX][pawn.posY]=2;
                System.out.println("Ajunge2");
            }
            else if (Board[x+1][y-1]==1) {
                Board[pawn.posX][pawn.posY]=0;
                pawn.posX=x+1;
                pawn.posY=y-1;
                Board[pawn.posX][pawn.posY]=2;
                System.out.println("Ajunge3");
            }
        }
        else if(Board[x+2][y]==0 && Board[x+1][y]==0 && x<4)
        {
            System.out.println("Ajunge4");
            Board[pawn.posX][pawn.posY]=0;
            System.out.println("Initial" + Board[pawn.posX][pawn.posY]);
            pawn.posX=x+2;
            Board[pawn.posX][pawn.posY]=2;
            System.out.println("Test1" + Board[pawn.posX][pawn.posY]);
        }
        else if(Board[x+1][y]==0)
        {
            System.out.println("Ajunge5");
            Board[pawn.posX][pawn.posY]=0;
            pawn.posX=x+1;
            Board[pawn.posX][pawn.posY]=2;
        }
        System.out.println(pawn.posX + "  ; "  + pawn.posY);
        System.out.println("Final" + Board[pawn.posX][pawn.posY]);
    }
}
