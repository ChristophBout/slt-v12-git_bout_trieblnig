
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
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        ByteArrayInputStream inputStream = new ByteArrayInputStream("Player1\nPlayer2\n".getBytes());
        System.setIn(inputStream);

        game = new TicTacToe();
    }


    @Test
    public void testEnd() {
        game.end();

        String consoleOutput = output.toString();
        assertTrue(consoleOutput.contains("Thank you for playing"), "Output should contain end message");
    }

    @Test
    public void testStart_GameOver() {
        simulateGameOver("Player1", true); // Simulate Player1 wins

        assertThrows(NoSuchElementException.class, () -> game.start(), "start() should end after game over");
    }

    private void simulateGameOver(String winnerName, boolean isWinner) {
        Board mockBoard = new Board();
        mockBoard.place(0, 0, 'X'); // Simulate a winning move
        game.setBoard(mockBoard);

        Player winner = isWinner ? game.getPlayer1() : game.getPlayer2();
        game.setCurrentPlayer(winner);

        ByteArrayInputStream inputStream = new ByteArrayInputStream("0 0\n".getBytes()); // Simulate restart input
        System.setIn(inputStream);
    }



}


