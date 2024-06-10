package org.example;

public class Player {
    private char marker;
    private String name;
    public Player (char marker, String name) {this.marker = marker;this.name = name;}
    public char getMarker(){
        return this.marker;
    }
    public String getName(){return this.name;}
}
