package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe(){
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());
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
            if (board.hasWinner()) {
                board.print();
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                break;
            }
            if (board.isFull()) {
                board.print();
                System.out.println("It's a draw!");
                break;
            }
            switchCurrentPlayer();
        }
        scanner.close();
    }
    private void switchCurrentPlayer(){
        if (currentPlayer == player1){
            currentPlayer = player2;
        }else {
            currentPlayer = player1;
        }
    }
}
