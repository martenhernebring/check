package se.hernebring.check.model;

import se.hernebring.check.exception.InvalidStartingSquareException;
public class Board {
    public Board(String kingStartingSquare) {
        if(kingStartingSquare.length() != 2) {
            throw new InvalidStartingSquareException("King starting square string must be two characters long.");
        }
        char file = Character.toLowerCase(kingStartingSquare.charAt(0));
        char row = kingStartingSquare.charAt(1);
        if(invalidFile(file) || invalidRow(row)) {
            throw new InvalidStartingSquareException("Invalid file or row");
        }
    }

    private boolean invalidRow(char row) {
        return row > '8' || row < '1';
    }

    private boolean invalidFile(char file) {
        return file < 'a' || file > 'h';
    }
}
