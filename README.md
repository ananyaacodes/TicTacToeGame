# TicTacToeGame

Simple console-based Tic-Tac-Toe game written in Java.

## What this is

This repository contains a small Java implementation of Tic-Tac-Toe with a human player and a simple computer player. Use the `TicTacToeApp` main class to run the game from a terminal or from your IDE.

## Prerequisites

- Java JDK 11 or newer installed and `java`/`javac` on your PATH.
- (Optional) IDE that supports Java (IntelliJ IDEA, VS Code with Java extensions, Eclipse, etc.).

To check Java is available, run in PowerShell:

```powershell
java -version
javac -version
```

## Build and run (PowerShell)

1. Open PowerShell in the project folder (where the `.java` files live).

2. Compile the Java sources:

```powershell
javac *.java
```

This will produce `.class` files in the same folder.

3. Run the game (the main class is `TicTacToeApp`):

```powershell
java TicTacToeApp
```

Follow the on-screen prompts to play.

## Run from an IDE

- Open the project folder in your IDE.
- Import as a Java project if required.
- Run the `TicTacToeApp` class (right-click on file -> Run, or use the Run configuration for the main class).

## Notes & Troubleshooting

- If you get permission/auth errors when compiling or running, ensure `javac` and `java` are installed and the PATH is configured correctly.
- If files are added later and you prefer a separate build/output directory, consider using a build tool (Maven/Gradle) or compile into a `bin` folder like:

```powershell
javac -d bin *.java
java -cp bin TicTacToeApp
```

## Suggested next steps

- Add a `README.md` description (you're viewing it now!).
- Add a `.gitignore` to exclude IDE files and compiled `.class` files (I can add one for you).
- Add a license if you want to share the project publicly.

---

If you'd like, I can add a Java `.gitignore` and a short `LICENSE` (MIT) now and commit them for you.