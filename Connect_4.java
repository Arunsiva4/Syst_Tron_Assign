import java.util.Arrays;
import java.util.Scanner;

public class Connect_4 {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final char EMPTY_SLOT = ' ';
    private static final char PLAYER1_SYMBOL = 'X';
    private static final char PLAYER2_SYMBOL = 'O';

    private char[][] board;

    public Connect_4() {
        board = new char[ROWS][COLUMNS];
        for (char[] row : board) {
            Arrays.fill(row, EMPTY_SLOT);
        }
    }

    public void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print("| " + cell + " ");
            }
            System.out.println("|");
        }
        for (int i = 0; i < COLUMNS * 4 + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 1; i <= COLUMNS; i++) {
            System.out.print("  " + i + " ");
        }
        System.out.println();
    }

    public boolean dropPiece(int column, char playerSymbol) {
        if (column < 1 || column > COLUMNS) {
            System.out.println("Invalid column. Please choose a column between 1 and " + COLUMNS);
            return false;
        }

        column--; // Adjusting for array indexing (starting from 0)

        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == EMPTY_SLOT) {
                board[i][column] = playerSymbol;
                return true;
            }
        }

        System.out.println("Column is full. Choose another column.");
        return false;
    }

    public boolean checkWin(char playerSymbol) {
        // Check for horizontal wins
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col <= COLUMNS - 4; col++) {
                if (board[row][col] == playerSymbol &&
                    board[row][col + 1] == playerSymbol &&
                    board[row][col + 2] == playerSymbol &&
                    board[row][col + 3] == playerSymbol) {
                    return true;
                }
            }
        }

        // Check for vertical wins
        for (int col = 0; col < COLUMNS; col++) {
            for (int row = 0; row <= ROWS - 4; row++) {
                if (board[row][col] == playerSymbol &&
                    board[row + 1][col] == playerSymbol &&
                    board[row + 2][col] == playerSymbol &&
                    board[row + 3][col] == playerSymbol) {
                    return true;
                }
            }
        }

        // Check for diagonal wins (bottom-left to top-right)
        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col <= COLUMNS - 4; col++) {
                if (board[row][col] == playerSymbol &&
                    board[row - 1][col + 1] == playerSymbol &&
                    board[row - 2][col + 2] == playerSymbol &&
                    board[row - 3][col + 3] == playerSymbol) {
                    return true;
                }
            }
        }

        // Check for diagonal wins (top-left to bottom-right)
        for (int row = 0; row <= ROWS - 4; row++) {
            for (int col = 0; col <= COLUMNS - 4; col++) {
                if (board[row][col] == playerSymbol &&
                    board[row + 1][col + 1] == playerSymbol &&
                    board[row + 2][col + 2] == playerSymbol &&
                    board[row + 3][col + 3] == playerSymbol) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isBoardFull() {
        for (int col = 0; col < COLUMNS; col++) {
            if (board[0][col] == EMPTY_SLOT) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Connect_4 game = new Connect_4();
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = PLAYER1_SYMBOL;

        while (true) {
            game.printBoard();

            System.out.print("Player " + currentPlayer + ", enter your move (column): ");
            int column = scanner.nextInt();

            if (game.dropPiece(column, currentPlayer)) {
                if (game.checkWin(currentPlayer)) {
                    game.printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("The game is a tie!");
                    break;
                }

                currentPlayer = (currentPlayer == PLAYER1_SYMBOL) ? PLAYER2_SYMBOL : PLAYER1_SYMBOL;
            }
        }

        scanner.close();
    }
}
