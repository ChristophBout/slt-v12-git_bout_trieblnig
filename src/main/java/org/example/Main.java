package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Christoph!");
        System.out.println("Hello Felix");
        System.out.println("Lets Play Tic Tac Toe\nChristoph U are Player 1 (x) Felix U are Player 2(0)");
        TicTacToe game = new TicTacToe();
        game.start();
    }

}