package string;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yun.516@gmail.com
 */
public class StringMatchTest {

    @Test
    public void bf() {
        assertEquals(0, StringMatch.bf("abcdefg", "abc"));
        assertEquals(1, StringMatch.bf("zabcdefg", "abc"));
        assertEquals(5, StringMatch.bf("zabcdefg", "efg"));
        assertEquals(-1, StringMatch.bf("zabcdefg", "efgx"));
    }

    @Test
    public void nk() {
        assertEquals(0, StringMatch.nk("abcdefg", "abc"));
        assertEquals(1, StringMatch.nk("zabcdefg", "abc"));
        assertEquals(5, StringMatch.nk("zabcdefg", "efg"));
        assertEquals(-1, StringMatch.nk("zabcdefg", "efgx"));
    }

    @Test
    public void bm() {
        assertEquals(0, StringMatch.bm("abcdefg", "abc"));
        assertEquals(1, StringMatch.bm("zabcdefg", "abc"));
        assertEquals(5, StringMatch.bm("zabcdefg", "efg"));
        assertEquals(-1, StringMatch.bm("zabcdefg", "efgx"));
    }
    @Test
    public void kmp() {
        assertEquals(0, StringMatch.kmp("abcdefg", "abc"));
        assertEquals(1, StringMatch.kmp("zabcdefg", "abc"));
        assertEquals(5, StringMatch.kmp("zabcdefg", "efg"));
        assertEquals(-1, StringMatch.kmp("zabcdefg", "efgx"));
    }
}