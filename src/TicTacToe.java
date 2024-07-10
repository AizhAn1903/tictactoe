import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}

    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameEnded = false;


        while (!gameEnded) {
            printBoard();
            playerMove(currentPlayer,scanner);
            gameEnded = checkWinner(currentPlayer);

            if (gameEnded) {
                printBoard();
                System.out.println("Игрок " + currentPlayer + " победил");
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                if (isBoardFull()) {
                    printBoard();
                    System.out.println("Игра заканчивается вничью!");
                    break;
                }
            }
        }
    }

    public static void printBoard(){
        System.out.println("Board: ");
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j]);
                if (j < 2 ) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2 ) System.out.println("----------");
        }
    }

    public static void playerMove(char currentPlayer, Scanner scanner) {
        int row = -1;
        int col = -1;

        while (true) {
            System.out.println("Игрок " + currentPlayer + " введите свой ход (строка и столбец)");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;

            if (row >= 0 && col >=0 && row < 3 && col < 3 && board[row][col] == ' ' ) {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("Этот шаг недействителен");
            }
        }
    }

    public static boolean checkWinner(char currentPlayer) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
        }

        }
        if ((board[0][0] == currentPlayer && board [1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] ==currentPlayer )) {
            return true;
        }
        return false;
        }


        public static boolean isBoardFull(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return  false;
                }
            }
        }
        return true;
        }


    }

