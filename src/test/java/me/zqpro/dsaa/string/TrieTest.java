package string;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yun.516@gmail.com
 */
public class TrieTest {
    private Trie trie;
    private String[] words = {"how", "hi", "her", "hello", "so", "see"};
    @Before
    public void setUp() {
        if (trie == null) {
            trie = new Trie();
            for (String word : words) {
                trie.insert(word.toCharArray());
            }
        }
    }

    @Test
    public void testFind() {
        for (String word : words) {
            assertTrue(trie.find(word.toCharArray()));
        }
        assertFalse(trie.find("abcdefg".toCharArray()));
        assertFalse(trie.find("h".toCharArray()));
        assertFalse(trie.find("ho".toCharArray()));
        assertFalse(trie.find("he".toCharArray()));
    }

    @Test
    public void testHint() {
        List<String> hint1 = trie.hint("h");
        assertTrue(hint1.contains("ow"));
        assertTrue(hint1.contains("er"));
        assertTrue(hint1.contains("i"));
    }
}