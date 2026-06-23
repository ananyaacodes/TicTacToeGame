# ⭕ Tic-Tac-Toe (Java)

A console-based Tic-Tac-Toe game in Java, built around an interface-driven design rather than a single procedural script. Supports Player vs Player and Player vs Computer modes, with a simple but genuine AI opponent.

## ✨ Features

- Player vs Player or Player vs Computer modes
- Computer opponent that can actually win and block, not just play randomly
- Input validation — handles out-of-range moves, already-taken cells, and malformed input without crashing
- Clean 3x3 board display after every move

## 🧠 OOP Concepts Demonstrated

| Concept | Where |
|---|---|
| **Interface** | `Player` defines the contract (`getSymbol()`, `getMove()`) that both human and computer players must fulfill |
| **Polymorphism** | `Game` calls `player.getMove(board)` without knowing or caring whether it's a `HumanPlayer` or `ComputerPlayer` |
| **Encapsulation** | `Board`'s grid is private; the only way to change it is through `placeMove()`, which validates first |
| **2D Arrays** | The board itself is a `char[3][3]` grid |
| **Simple AI logic** | `ComputerPlayer` checks: can I win? → can I block the opponent's win? → else play randomly |

## 🛠️ Tech Stack

- **Language:** Java (no external libraries/frameworks)

## 📁 Project Structure

```
.
├── Board.java          # Owns the grid, win/draw detection, and a safe move-simulation helper for AI use
├── Player.java         # Interface — the contract every player type must fulfill
├── HumanPlayer.java     # Reads moves from console input, with input validation
├── ComputerPlayer.java # Simple AI: win > block > random
├── Game.java            # Runs the turn loop, alternating between two Player objects
└── TicTacToeApp.java   # Main class — lets you choose game mode, then starts Game
```

## ▶️ How to Run

```bash
javac *.java
java TicTacToeApp
```

> Requires Java 8 or later — no modern-syntax features are used.

## 📋 How to Play

Moves are entered as **row column** (each 0, 1, or 2), on a single line:

```
 (0,0) | (0,1) | (0,2)
-------+-------+-------
 (1,0) | (1,1) | (1,2)
-------+-------+-------
 (2,0) | (2,1) | (2,2)
```

Example: to play the top-middle cell, type `0 1`.

## 🐛 A Bug Worth Mentioning

Early input handling used two separate `Scanner.nextInt()` calls for row and column. If a move was accidentally split across two lines (e.g. typing `0`, pressing Enter, then `0 0`), a leftover number stayed queued in the input stream — silently shifting every move afterward by one cell. Fixed by reading each move as a single line and parsing it as one atomic unit, which makes this entire class of bug impossible regardless of how the input is typed.

## 🔭 Future Improvements

- [ ] Smarter AI (minimax algorithm for an unbeatable computer opponent)
- [ ] GUI version using Swing or JavaFX
- [ ] Score tracking across multiple rounds