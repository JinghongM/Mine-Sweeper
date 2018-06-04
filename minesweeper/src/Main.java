import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int xRange=10;
        int yRange=10;
        double threshold=0.5;
        for(int i = 0;i<args.length;i++)
        {
            if(i==0)
            {xRange = Integer.parseInt(args[i]);}
            if(i==1)
            {yRange = Integer.parseInt(args[i]);}
            if(i==2)
            {threshold = Double.parseDouble(args[i]);}
        }
        Board board=new Board(xRange,yRange,threshold);
        Player player = new Player(board);
        player.startGame();
    }

}
