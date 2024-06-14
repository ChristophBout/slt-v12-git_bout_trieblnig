
package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testClear() {
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0), "Cell (0,0) should be empty after clearing the board");
    }

    @Test
    public void testIsCellEmpty() {
        assertTrue(board.isCellEmpty(0, 0), "Cell (0,0) should be empty initially");
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0), "Cell (0,0) should not be empty after placing a marker");
    }

    @Test
    public void testPlace() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0), "Cell (0,0) should not be empty after placing a marker");
        assertEquals('X', board.cells[0][0], "Cell (0,0) should contain the marker 'X'");
    }

    @Test
    public void testIsFull() {
        assertFalse(board.isFull(), "Board should not be full initially");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull(), "Board should be full after all cells are filled");
    }

    @Test
    public void testHasWinner_Row() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertTrue(board.hasWinner(), "There should be a winner if a row is filled with the same marker");
    }

    @Test
    public void testHasWinner_Column() {
        board.place(0, 0, 'X');
        board.place(1, 0, 'X');
        board.place(2, 0, 'X');
        assertTrue(board.hasWinner(), "There should be a winner if a column is filled with the same marker");
    }

    @Test
    public void testHasWinner_Diagonal1() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');
        assertTrue(board.hasWinner(), "There should be a winner if a diagonal is filled with the same marker");
    }

    @Test
    public void testHasWinner_Diagonal2() {
        board.place(0, 2, 'X');
        board.place(1, 1, 'X');
        board.place(2, 0, 'X');
        assertTrue(board.hasWinner(), "There should be a winner if the other diagonal is filled with the same marker");
    }

    @Test
    public void testNoWinner() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');
        board.place(1, 0, 'O');
        board.place(1, 1, 'X');
        board.place(1, 2, 'O');
        board.place(2, 0, 'O');
        board.place(2, 1, 'X');
        board.place(2, 2, 'O');
        assertFalse(board.hasWinner(), "There should be no winner in this board setup");
    }



}

