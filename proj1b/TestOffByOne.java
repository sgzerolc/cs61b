import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testIsequalCars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('b', 'a'));
        assertTrue(offByOne.equalChars('&', '%'));

        assertFalse(offByOne.equalChars('c', 'e'));
        assertFalse(offByOne.equalChars('k', 'q'));
        assertFalse(offByOne.equalChars('v', 'v'));
    }
}
