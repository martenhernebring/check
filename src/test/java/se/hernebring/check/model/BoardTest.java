package se.hernebring.check.model;

import org.junit.jupiter.api.Test;
import se.hernebring.check.exception.InvalidStartingSquareException;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void boardExists() {
        Board b = new Board("e1");
        assertNotNull(b);
    }

    @Test
    void tooHighStartingFileThrowsInvalidStartingSquareException() {
        Exception exception = assertThrows(InvalidStartingSquareException.class,
                () -> new Board("i1"));
        assertEquals(exception.getMessage(), "Invalid file or row");
    }

    @Test
    void tooLowStartingFileThrowsInvalidStartingSquareException() {
        assertThrows(InvalidStartingSquareException.class,
                () -> new Board("@1"));
    }

    @Test
    void capitalFileShouldBeValid() {
        assertDoesNotThrow(() -> new Board("A1"));
    }

    @Test
    void tooHighStartingRowThrowsInvalidStartingSquareException() {
        assertThrows(InvalidStartingSquareException.class,
                () -> new Board("e9"));
    }

    @Test
    void tooLowStartingRowThrowsInvalidStartingSquareException() {
        assertThrows(InvalidStartingSquareException.class,
                () -> new Board("e0"));
    }

    @Test
    void tooShortKingStartingSquareTextShouldBeInvalid() {
        Exception exception = assertThrows(InvalidStartingSquareException.class,
                () -> new Board("e"));
        assertEquals(exception.getMessage(), "King starting square string must be two characters long.");
    }

    @Test
    void tooLongKingStartingSquareTextShouldBeInvalid() {
        assertThrows(InvalidStartingSquareException.class,
                () -> new Board("e1b"));
    }

}
