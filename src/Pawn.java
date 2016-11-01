/**
 * Created by tcarnaru on 11/1/2016.
 */
public class Pawn {
    int posX= 0;
    int posY= 0;
    Pawn(int x, int y)
    {
        posX=x;
        posY=y;
    }
    public void getPawn()
    {
        System.out.println(posX +"+" +posY);
    }

    public void move(int x, int y , int[][]Board)
    {
        System.out.println(posX +"+" +posY + ";"+x +"-"+ y);
        if(x<posX-2 || y>posY+1 || y<posY-1 || x==posX || x>posX+2 ) System.out.println("Mutare incorecta1");
        else
        {
            if(Board[x][y]==2)
            {
                if(x==posX-1 && y==posY+1 || x==posX-1&& y==posY-1)
                {
                    Board[posX][posY]=0;
                    this.posY=y;
                    this.posX=x;
                    Board[x][y]=1;
                }
                else System.out.println("Mutare incorecta2");
            }
            else if(Board[x][y]==0)
            {
                if(y==posY)
                {
                    Board[posX][posY]=0;
                    this.posY=y;
                    this.posX=x;
                    Board[x][y]=1;
                }
                else System.out.println("Mutare incorecta4");
            }
            else System.out.println("Mutare incorecta3");

        }
    }
}
