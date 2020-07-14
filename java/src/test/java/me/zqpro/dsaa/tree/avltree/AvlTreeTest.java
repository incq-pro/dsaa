package me.zqpro.dsaa.tree.avltree;

import org.junit.Test;

public class AvlTreeTest {
    @Test
    public void test() {
        AvlTree<Integer> tree = new AvlTree<>();
        for(int i = 0; i < 10; i++) {
            tree.insert(i);
        }
    }
}