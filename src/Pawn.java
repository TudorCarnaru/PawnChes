
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by tcarnaru on 11/1/2016.
 */
public class Pawn {
    public int posX= 0;
    public int posY= 0;
    public int flag= 0;
    Pawn(int x, int y,int z)
    {
        posX=x;
        posY=y;
        flag=z;
    }
    public int getPawnx()
    {
        return posX;
    }
    public int getPawny() { return posY; }

    public int move(int x, int y , int[][]Board)
    {
        if(posX==-1 || posY==-1)
        {
            System.out.println("Pionul a fost mancat");
            return 1;
        }
        if(x>posX)
        {
            System.out.println("Mutare incorecta");
            return 0;
        }
        if(x<posX-2 || y>posY+1 || y<posY-1 || x==posX || x>posX+2 )
        {
            System.out.println("Mutare incorecta1");
            return 0;
        }
        else
        {
            if(Board[x][y]==2)
            {
                if(x==posX-2 && Board[x-1][y]!=0)
                {
                    System.out.println("Mutare incorecta 5");
                    return 0;
                }
                if(x==posX-1 && y==posY+1 || x==posX-1&& y==posY-1)
                {
                    Board[posX][posY]=0;
                    this.posY=y;
                    this.posX=x;
                    Board[x][y]=1;
                    return 1;
                }
                else
                {
                    System.out.println("Mutare incorecta2");
                    return 0;
                }
            }
            else if(Board[x][y]==0)
            {
                if(x==posX-2 && Board[x+1][y]!=0)
                {
                    System.out.println("Mutare incorecta 5");
                    return 0;
                }
                else {
                    if (y == posY) {
                        Board[posX][posY] = 0;
                        this.posY = y;
                        this.posX = x;
                        Board[x][y] = 1;
                        return 1;
                    } else
                    {
                        System.out.println("Mutare incorecta4");
                        return 0;
                    }
                }
            }
            else
            {
                System.out.println("Mutare incorecta3");
                return 0;
            }

        }
    }


}