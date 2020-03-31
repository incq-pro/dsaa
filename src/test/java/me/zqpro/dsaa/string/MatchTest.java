package string;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yun.516@gmail.com
 */
public class MatchTest {
    @Test
    public void testBF() {
        Match m = new BruteForceMatch();
        testMatch(m);
    }

    @Test
    public void testRK() {
        Match m = new RabinKarpMatch();
        testMatch(m);
    }

    @Test
    public void testBM() {
        Match m = new BoyerMooreMatch();
        testMatch(m);
    }

    @Test
    public void testKMP() {
        Match m = new KMPMatch();
        testMatch(m);
    }

    private void testMatch(Match m) {
        char[] a = "abcdefefef".toCharArray();
        assertEquals(0, m.match(a, "a".toCharArray()));
        assertEquals(5, m.match(a, "f".toCharArray()));
        assertEquals(0, m.match(a, "ab".toCharArray()));
        assertEquals(0, m.match(a, a));
        assertEquals(-1, m.match(a, "ba".toCharArray()));
        assertEquals(-1, m.match(a, "abcdefg".toCharArray()));
        assertEquals(5, m.match(a, "fefef".toCharArray()));
    }
}