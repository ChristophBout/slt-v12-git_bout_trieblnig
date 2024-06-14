package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class MainTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @Test
    public void testMainOutput() {
        String input = "Player1\nPlayer2\n0\n0\n0\n1\n0\n2\n1\n0\n1\n1\n1\n2\n2\n0\n";
        ByteArrayInputStream inStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inStream);

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));

        try {
            Main.main(new String[]{});
            String output = outStream.toString();

            assertTrue(output.contains("Hello Player 1!"), "Output should contain 'Hello Player 1!'");
            assertTrue(output.contains("Hello Player 2"), "Output should contain 'Hello Player 2'");
            assertTrue(output.contains("Lets Play Tic Tac Toe"), "Output should contain 'Lets Play Tic Tac Toe'");
        } finally {
            // Restore original System.in and System.out
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

}
