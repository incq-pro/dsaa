package pro.incq.dsaa.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author yun.516@gmail.com
 */
public class Trie2Test {
    @Test
    public void test() {
        Trie2 trie2 = new Trie2();
        trie2.add("hello".toCharArray());
        trie2.add("he".toCharArray());
        trie2.add("her".toCharArray());
        trie2.add("so".toCharArray());

        assertTrue(trie2.contains("he".toCharArray()));
        assertTrue(trie2.contains("so".toCharArray()));
        trie2.remove("he".toCharArray());
        assertFalse(trie2.contains("he".toCharArray()));
        trie2.remove("so".toCharArray());
        assertFalse(trie2.contains("so".toCharArray()));

    }
}