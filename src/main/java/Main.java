import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int gridSize;
        boolean inGame = true;
        int x_pos, y_pos;
        System.out.println("Please enter the size of the grid you'd like, with your number being the length of one side.");
        gridSize = input.nextInt();
        Board gameBoard = new Board(gridSize);
        System.out.println(gameBoard.displayScreen());
        do {
            System.out.println("What row number will you choose?");
            x_pos = input.nextInt();
            System.out.println("What column number will you choose?");
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
