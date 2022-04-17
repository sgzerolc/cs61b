import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offbytwo = new OffByN(2);
    static CharacterComparator offbytheree = new OffByN(3);

    @Test
    public void testIsequalChars() {
        assertTrue(offbytwo.equalChars('a', 'c'));
        assertTrue(offbytwo.equalChars('f', 'd'));

        assertFalse(offbytwo.equalChars('a','a'));
        assertFalse(offbytwo.equalChars('c', 't'));

        assertTrue(offbytheree.equalChars('a', 'd'));
        assertTrue(offbytheree.equalChars('g', 'd'));

        assertFalse(offbytheree.equalChars('a', 'a'));
        assertFalse(offbytheree.equalChars('c', 't'));
    }
}
