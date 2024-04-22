package exercise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReversedSequenceTest {
    CharSequence text = new ReversedSequence("abcdef");
    @Test
    void testToString() {
        assertEquals(text.toString(), "fedcba");
    }
    void testCharAt() {
        assertEquals(text.charAt(1), 'e');
    }
    void testLength() {
        assertEquals(text.length(), 6);
    }
    void testSubSequence() {
        assertEquals(text.subSequence(1, 4).toString(), "edc");
    }
}
