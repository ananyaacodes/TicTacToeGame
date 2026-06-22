import java.util.Scanner;

/**
 * Implements Player by asking a real person to type their move.
 * Keeps re-prompting until the move is actually valid — Board itself
 * doesn't throw or print errors, so that logic belongs here.
 */
public class HumanPlayer implements Player {

    private final char symbol;
    private final Scanner scanner;
    private final String name;

    public HumanPlayer(char symbol, String name, Scanner scanner) {
        this.symbol = symbol;
        this.name = name;
        this.scanner = scanner;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public int[] getMove(Board board) {
        while (true) {
            System.out.print(name + " (" + symbol + "), enter row and column (e.g. 1 2): ");
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");

            if (parts.length != 2) {
                System.out.println("Please enter exactly two numbers on one line, e.g. 1 2");
                continue;
            }

            int row, col;
            try {
                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid numbers, e.g. 1 2");
                continue;
            }

            if (!board.isInBounds(row, col)) {
                System.out.println("Out of range — rows and columns must be 0, 1, or 2.");
                continue;
            }
            if (!board.isCellEmpty(row, col)) {
                System.out.println("That cell is already taken — pick another.");
                continue;
            }
            return new int[] { row, col };
        }
    }
}