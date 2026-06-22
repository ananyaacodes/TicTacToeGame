import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Implements Player with simple AI logic, checked in priority order:
 *   1. If I can win this turn, take that move.
 *   2. Else if the opponent could win next turn, block that cell.
 *   3. Else just pick a random empty cell.
 *
 * Notice it reuses board.wouldWin() instead of re-implementing win
 * detection itself — Board already knows how to check that.
 */
public class ComputerPlayer implements Player {

    private final char symbol;
    private final char opponentSymbol;
    private final Random random;

    public ComputerPlayer(char symbol, char opponentSymbol) {
        this.symbol = symbol;
        this.opponentSymbol = opponentSymbol;
        this.random = new Random();
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public int[] getMove(Board board) {
        // 1. Can I win right now?
        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++) {
                if (board.wouldWin(row, col, symbol)) {
                    return new int[] { row, col };
                }
            }
        }

        // 2. Would the opponent win here next turn? Block it.
        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++) {
                if (board.wouldWin(row, col, opponentSymbol)) {
                    return new int[] { row, col };
                }
            }
        }

        // 3. No urgent move — pick randomly among empty cells.
        List<int[]> emptyCells = new ArrayList<int[]>();
        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++) {
                if (board.isCellEmpty(row, col)) {
                    emptyCells.add(new int[] { row, col });
                }
            }
        }
        return emptyCells.get(random.nextInt(emptyCells.size()));
    }
}