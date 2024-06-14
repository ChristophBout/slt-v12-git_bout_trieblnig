package org.example;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private TicTacToe game;
    private ByteArrayOutputStream output;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to capture output
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // Simulate input for player names
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Player1\nPlayer2\n".getBytes());
        System.setIn(inputStream);

        // Create a new TicTacToe game instance
        game = new TicTacToe();
    }

    @Test
    public void testRestart() {
        // Mock a game state
        game.start();
        game.end();

        // Capture the output before restart
        String outputBeforeRestart = output.toString();

        // Restart the game
        game.restart();

        // Check if the board is cleared after restart
        Board board = game.getBoard();
        assertTrue(board.isFull(), "Board should be cleared after restart");

        // Check if the game starts again after restart
        game.start();
        game.end();

        // Capture the output after restart
        String outputAfterRestart = output.toString();

        // Assert that the output after restart should contain restart message
        assertTrue(outputAfterRestart.contains("Restart?"), "Output should contain restart message");

        // Assert that the output before restart and after restart are different
        assertNotEquals(outputBeforeRestart, outputAfterRestart, "Output should be different before and after restart");
    }

    @Test
    public void testEnd() {
        // Call the end method
        game.end();

        // Check the output contains the end message
        String consoleOutput = output.toString();
        assertTrue(consoleOutput.contains("Thank you for playing"), "Output should contain end message");
    }

    @Test
    public void testStart_GameOver() {
        // Mock a scenario where the game is over
        simulateGameOver("Player1", true); // Simulate Player1 wins

        // Check if the start method ends after game over
        assertThrows(NoSuchElementException.class, () -> game.start(), "start() should end after game over");
    }

    @Test
    public void testStart_ValidInput() {
        // Mock valid input for player moves
        simulatePlayerMoves("0 0\n1 1\n");

        // Start the game and check output
        game.start();
        String consoleOutput = output.toString();

        assertTrue(consoleOutput.contains("Current Player: X Player1"), "Output should contain current player info");
        assertTrue(consoleOutput.contains("Player X Player1 wins!"), "Output should contain winning message");
    }

    // Helper method to simulate player moves
    private void simulatePlayerMoves(String moves) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(moves.getBytes());
        System.setIn(inputStream);
    }

    // Helper method to simulate game over scenario
    private void simulateGameOver(String winnerName, boolean isWinner) {
        Board mockBoard = new Board();
        mockBoard.place(0, 0, 'X'); // Simulate a winning move
        game.setBoard(mockBoard);

        // Mock currentPlayer based on winner
        Player winner = isWinner ? game.getPlayer1() : game.getPlayer2();
        game.setCurrentPlayer(winner);

        ByteArrayInputStream inputStream = new ByteArrayInputStream("0 0\n".getBytes()); // Simulate restart input
        System.setIn(inputStream);
    }
}
