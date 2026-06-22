/**
 * Owns the 3x3 grid and everything related to checking it — printing,
 * placing moves, detecting wins/draws. Neither Player implementation
 * needs to know HOW a win is detected; they just ask Board.
 */
public class Board {

    public static final int SIZE = 3;
    private final char[][] grid;

    public Board() {
        grid = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = '-'; // '-' means empty
            }
        }
    }

    public boolean isCellEmpty(int row, int col) {
        return isInBounds(row, col) && grid[row][col] == '-';
    }

    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    // Returns false instead of throwing — for a small game, a simple
    // boolean is enough; we don't need custom exceptions here like the
    // bank project did.
    public boolean placeMove(int row, int col, char symbol) {
        if (!isCellEmpty(row, col)) {
            return false;
        }
        grid[row][col] = symbol;
        return true;
    }

    public char getCell(int row, int col) {
        return grid[row][col];
    }

    public boolean isFull() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // Checks all 3 rows, 3 columns, and both diagonals for three-in-a-row.
    public boolean checkWin(char symbol) {
        // Rows and columns
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) {
                return true; // row i
            }
            if (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) {
                return true; // column i
            }
        }
        // Diagonals
        if (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) {
            return true;
        }
        if (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol) {
            return true;
        }
        return false;
    }

    // Lets ComputerPlayer ask "if I placed here, would I win?" WITHOUT
    // permanently changing the board. Win-checking logic stays in ONE
    // place (checkWin above) instead of being duplicated inside the AI.
    public boolean wouldWin(int row, int col, char symbol) {
        if (!isCellEmpty(row, col)) {
            return false;
        }
        grid[row][col] = symbol;       // temporarily place
        boolean result = checkWin(symbol);
        grid[row][col] = '-';          // undo — board is unchanged afterward
        return result;
    }

    public void printBoard() {
        for (int row = 0; row < SIZE; row++) {
            StringBuilder line = new StringBuilder();
            for (int col = 0; col < SIZE; col++) {
                line.append(" ").append(grid[row][col]).append(" ");
                if (col < SIZE - 1) {
                    line.append("|");
                }
            }
            System.out.println(line.toString());
            if (row < SIZE - 1) {
                System.out.println("-----------");
            }
        }
    }
}