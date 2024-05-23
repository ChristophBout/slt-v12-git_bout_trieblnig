package org.example;

public class Board {
    private char[][] cells;
    public Board() {
        cells = new char[3][3];
        clear();
    }
    public void clear(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }
    public boolean isCellEmpty(int x, int y){
        return cells[x][y] == ' ';
    }
    public void place(int x, int y, char marker){
        if (isCellEmpty(x,y)){
            cells [x][y] = marker;
        }
    }
    public boolean isFull(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }
    public void print(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf(String.valueOf(cells[i][j]));
                if (j< 2) System.out.printf("|");
            }
            System.out.println();
            if (i< 2) System.out.println("----");
        }
    }
    public boolean hasWinner() {
        // Check row & column
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] != ' ' && cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) {
                return true;
            }
            if (cells[0][i] != ' ' && cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i]) {
                return true;
            }
        }
        // Check diagonals
        if (cells[0][0] != ' ' && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) {
            return true;
        }
        if (cells[0][2] != ' ' && cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) {
            return true;
        }
        return false;
    }
}
