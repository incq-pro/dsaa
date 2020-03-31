package tree.avltree;

import org.junit.Test;

import static org.junit.Assert.*;

public class AvlTreeTest {
    @Test
    public void test() {
        AvlTree<Integer> tree = new AvlTree<>();
        for(int i = 0; i < 10; i++) {
            tree.insert(i);
        }
    }
}