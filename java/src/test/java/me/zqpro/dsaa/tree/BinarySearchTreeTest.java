package me.zqpro.dsaa.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author yun.516@gmail.com
 */
public class BinarySearchTreeTest {

    @Test
    public void test() {
        BinarySearchTree tree = new BinarySearchTree();

        assertNull(tree.find(0));
        assertNull(tree.find(100));

        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);

        for (int i = 1; i <= 7; i++) {
            assertEquals(i, tree.find(i).data);
        }

        assertNull(tree.find(0));
        assertNull(tree.find(100));

        tree.delete(2);
        assertNull(tree.find(2));
        assertEquals(1, tree.find(1).data);
        assertEquals(4, tree.find(4).data);
        assertEquals(3, tree.find(3).data);

        tree.delete(3);
        assertNull(tree.find(3));

        tree.delete(7);
        assertNull(tree.find(7));

        tree.delete(4);
        assertNull(tree.find(4));


    }
}