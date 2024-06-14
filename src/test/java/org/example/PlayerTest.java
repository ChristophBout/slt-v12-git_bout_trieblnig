
package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private Player playerX;
    private Player playerO;

    @BeforeEach
    public void setUp() {
        playerX = new Player('X', "Player1");
        playerO = new Player('O', "Player2");
    }

    @Test
    public void testGetMarker() {
        assertEquals('X', playerX.getMarker(), "Player1's marker should be 'X'");
        assertEquals('O', playerO.getMarker(), "Player2's marker should be 'O'");
    }

    @Test
    public void testGetName() {
        assertEquals("Player1", playerX.getName(), "Player1's name should be 'Player1'");
        assertEquals("Player2", playerO.getName(), "Player2's name should be 'Player2'");
    }

    @Test
    public void testPlayerInitialization() {
        assertNotNull(playerX, "Player1 should be initialized");
        assertNotNull(playerO, "Player2 should be initialized");
    }


}


