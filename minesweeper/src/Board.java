public class Board {
    private final int xRange;
    private final int yRange;
    private final double threshold;
    private int[][] neighboard;
    private boolean[][] mineBoard;
    private boolean[][] visited;
    public boolean end;
    public Board(int xRange,int yRange,double threshold)
    {
        this.xRange=xRange;
        this.yRange=yRange;
        this.threshold = threshold;
        neighboard=new int[xRange][yRange];
        mineBoard=new boolean[xRange][yRange];
        visited=new boolean[xRange][yRange];
        end=false;
        for(int x = 0;x<xRange;x++)
        {
            for(int y=0;y<yRange;y++)
            {
                if(Math.random()<threshold)
                {
                    mineBoard[x][y] = true;
                }
                else
                {
                    mineBoard[x][y] = false;
                }
            }
        }
        for(int x = 0;x<xRange;x++)
        {
            for(int y=0;y<yRange;y++)
            {
                if(mineBoard[x][y] == false)
                {
                    int neigh=0;
                    for(int i = Math.max(0,x-1);i<=Math.min(xRange-1,x+1);i++)
                    {
                        for(int j = Math.max(0,y-1);j<=Math.min(yRange-1,y+1);j++)
                        {
                            if(mineBoard[i][j] == true)
                            {
                                neigh++;
                            }
                        }
                    }
                    neighboard[x][y] = neigh;
                }
            }
        }
    }
    public void showFullBoard()
    {
        for(int i = 0;i<xRange;i++)
        {
            for(int j = 0;j<yRange;j++)
            {
                if(mineBoard[i][j]==true)
                {
                    System.out.print('*');
                }
                else
                {
                    System.out.print(neighboard[i][j]);
                }
                System.out.print(' ');
            }
            System.out.println();
        }
    }
    public void showTempBoard()
    {
        for(int i = 0;i< xRange;i++)
        {
            for(int j = 0;j<yRange;j++)
            {
                if(visited[i][j] == false)
                {
                    System.out.print('-');
                }
                else
                {
                    System.out.print(neighboard[i][j]);
                }
                System.out.print(' ');
            }
            System.out.println();
        }
    }
    public int getxRange()
    {
        return this.xRange;
    }
    public int getyRange()
    {
        return this.yRange;
    }

    private boolean isVictory()
    {
        for(int i = 0;i<xRange;i++)
        {
            for(int j  = 0;j<yRange;j++)
            {
                if(mineBoard[i][j] ^visited[i][j] == false)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public void onClick(int x,int y)
    {
        if(mineBoard[x][y] == true)
        {
            System.out.println("Game Over!");
            showFullBoard();
            end=true;
        }
        else {
            visited[x][y] = true;
            showTempBoard();
            if (isVictory())
            {
                System.out.println("Victory!");
                end=true;
            }
        }
    }
}
