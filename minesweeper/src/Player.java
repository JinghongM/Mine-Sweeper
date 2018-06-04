import java.util.Scanner;
public class Player {
    boolean end;
    int round;
    Scanner scanner;
    Board board;
    public Player(Board board)
    {
        end=false;
        round=0;
        scanner = new Scanner(System.in);
        this.board=board;
    }
    public void input()
    {
        int x;
        int y;
        System.out.print("Round:");
        System.out.println(round++);
        System.out.println("Please input x position:");
        x=scanner.nextInt();
        while(x>=board.getxRange())
        {
            System.out.print("Invalid x position! Please try again:");
            x=scanner.nextInt();
        }
        System.out.println("Please input y position:");
        y=scanner.nextInt();
        while(y>=board.getyRange())
        {
            System.out.print("Invalid y position! Please try again:");
            y=scanner.nextInt();
        }
        board.onClick(x,y);
        return;


    }

    public void startGame()
    {
        board.showTempBoard();
        while(board.end==false)
        {
            input();
        }
        return;
    }
}
