/**
 * Any kind of player — human or computer — must be able to do two things:
 * report its own symbol, and produce a move when asked. Game.java will
 * call getMove() on whichever Player it's dealing with, without caring
 * which implementation it actually is.
 *
 * This is different from the Account/Bank inheritance you used before:
 * HumanPlayer and ComputerPlayer don't share any actual code (no common
 * fields or default behavior to inherit) — they just need to GUARANTEE
 * they both know how to produce a move. That's exactly when an interface
 * is the right tool instead of a base class.
 */
public interface Player {
    char getSymbol();
    int[] getMove(Board board); // returns {row, col}
}