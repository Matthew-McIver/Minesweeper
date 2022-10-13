import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean inGame = true;
        int x_pos, y_pos;
        Board gameBoard = new Board(10);
        System.out.println(gameBoard.displayScreen());
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("What column number will you choose?");
            x_pos = input.nextInt();
            System.out.println("What row number will you choose?");
            y_pos = input.nextInt();
            gameBoard.showSingleTile(x_pos, y_pos);
            gameBoard.revealingRecursion(x_pos, y_pos);
            System.out.println(gameBoard.displayScreen());
            if(gameBoard.checkBomb(x_pos, y_pos)){
                inGame = false;
                System.out.println("You lose.");
            }
        } while(inGame);
    }
}
