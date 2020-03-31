package tree.binarytree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    @Test
    public void testConstruct() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertTrue(tree.isEmpty());
        assertEquals(tree.size(), 0);
    }

    @Test
    public void testMakeEmpty() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        // todo add more elements
        tree.makeEmpty();
        assertTrue(tree.isEmpty());
        assertEquals(tree.size(), 0);
    }

    @Test
    public void test() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(5));
        assertFalse(tree.contains(3));

        assertEquals(tree.findMin(), Integer.valueOf(1));
        assertEquals(tree.findMax(), Integer.valueOf(5));

        assertEquals(tree.size(), 4);

        tree.printTree();

        tree.remove(1);
        assertFalse(tree.contains(1));
        tree.printTree();

    }

}