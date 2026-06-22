/**
 * Runs the match. Notice this class never checks "is this a HumanPlayer
 * or a ComputerPlayer?" anywhere — it just calls player.getMove(board).
 * That's the interface paying off: Game works identically regardless
 * of which Player implementation it's holding.
 */
public class Game {

    private final Board board;
    private final Player playerX;
    private final Player playerO;

    public Game(Player playerX, Player playerO) {
        this.board = new Board();
        this.playerX = playerX;
        this.playerO = playerO;
    }

    public void play() {
        Player current = playerX;
        board.printBoard();

        while (true) {
            int[] move = current.getMove(board);
            board.placeMove(move[0], move[1], current.getSymbol());

            System.out.println();
            board.printBoard();

            if (board.checkWin(current.getSymbol())) {
                System.out.println("\nPlayer " + current.getSymbol() + " wins!");
                return;
            }
            if (board.isFull()) {
                System.out.println("\nIt's a draw!");
                return;
            }

            current = (current == playerX) ? playerO : playerX;
        }
    }
}