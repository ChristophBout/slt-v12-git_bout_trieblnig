package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter name for Player 1 (X): ");
        String player1Name = scanner.nextLine();

        player1 = new Player('X', player1Name);
        System.out.printf("Enter name for Player 2 (O): ");
        String player2Name = scanner.nextLine();
        player2 = new Player('O', player2Name);
        currentPlayer = player1;
        board = new Board();
    }
    public void restart(){
        board.clear();
        start();
    }
    public void end(){
        System.out.println("Thank you for playing");
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;
        while (playing) {
            board.print();
            System.out.printf("Current Player: " + currentPlayer.getMarker());
            System.out.printf(" " +currentPlayer.getName());
            processPlayerMove(scanner);
            playing = checkGameOver(scanner);
        }
    }

    private void processPlayerMove(Scanner scanner) {
        int row, col;
        while (true) {
            System.out.print("row (0-2): ");
            row = scanner.nextInt();
            System.out.print("column (0-2): ");
            col = scanner.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board.isCellEmpty(row, col)) {
                break;
            } else {
                System.out.println("Invalid input or cell is not empty. Try again.");
            }
        }
        board.place(row, col, currentPlayer.getMarker());
    }

    private boolean checkGameOver(Scanner scanner) {
        if (board.hasWinner()) {
            board.print();
            System.out.printf("Player " + currentPlayer.getMarker());
            System.out.printf(" " + currentPlayer.getName());
            System.out.printf(" wins!");
            return promptRestart(scanner);
        } else if (board.isFull()) {
            board.print();
            System.out.println("The game is a tie!");
            return promptRestart(scanner);
        } else {
            switchCurrentPlayer();
            return true;
        }
    }

    private boolean promptRestart(Scanner scanner) {
        System.out.print("Restart? Yes = 0 || Anything else to quit: ");
        int restart = scanner.nextInt();
        if (restart == 0) {
            restart();
            return true;
        } else {
            end();
            return false;
        }
    }

    private void switchCurrentPlayer(){
        if (currentPlayer == player1){
            currentPlayer = player2;
        }else {
            currentPlayer = player1;
        }
    }
}