package Test.TestBinarySearchTree;

import org.junit.Before;
import org.junit.Test;
import uy.edu.um.prog2.adt.tree.BinarySearchTree;

import static org.junit.Assert.*;

public class TestBinarySearchTree {
    private BinarySearchTree<Integer, String> tree;

    @Before
    public void setUp() {
        tree = new BinarySearchTree<>();
    }

    @Test
    public void testInsert() {
        tree.insert(10, "10");
        tree.insert(20, "20");
        tree.insert(30, "30");

        assertEquals("10", tree.find(10));
        assertEquals("20", tree.find(20));
        assertEquals("30", tree.find(30));
    }

    @Test
    public void testDelete() {
        tree.delete(10);  // delete arbol vacio
        tree.insert(10, "10");
        tree.insert(20, "20");
        tree.insert(30, "30");
        // se inserto?
        assertEquals("10", tree.find(10));
        assertEquals("20", tree.find(20));
        assertEquals("30", tree.find(30));
        tree.delete(10);
        assertNull(tree.find(10)); // Fue borrado?
        tree.delete(20);
        assertNull(tree.find(20));   // Idem
        tree.delete(30);
        assertNull(tree.find(30)); // Idem
    }

}