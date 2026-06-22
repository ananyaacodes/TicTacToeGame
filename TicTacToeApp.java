import java.util.Scanner;

public class TicTacToeApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- TIC TAC TOE ---");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Computer");
        System.out.print("Choose mode: ");
        int mode = sc.nextInt();
        sc.nextLine(); // consume leftover newline before HumanPlayer starts using nextLine()

        Player playerX;
        Player playerO;

        if (mode == 2) {
            playerX = new HumanPlayer('X', "You", sc);
            playerO = new ComputerPlayer('O', 'X');
            System.out.println("You are X. Computer is O.");
        } else {
            playerX = new HumanPlayer('X', "Player 1", sc);
            playerO = new HumanPlayer('O', "Player 2", sc);
        }

        System.out.println("Enter moves as: row column (each 0, 1, or 2)\n");

        Game game = new Game(playerX, playerO);
        game.play();

        sc.close();
    }
}