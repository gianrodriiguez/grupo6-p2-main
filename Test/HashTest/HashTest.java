package Test.HashTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.hash.HashTableImpl;

import static org.junit.jupiter.api.Assertions.*;

public class HashTest {

    private HashTable<String, Integer> hashTable;
    @BeforeEach
    public void setUp() {
        hashTable = new HashTableImpl<>(10);
    }
    @Test
    public void testPutAndContains() {
        hashTable.put("a", 5);
        hashTable.put("b", 7);
        hashTable.put("c", 3);

        assertTrue(hashTable.contains("a"));
        assertTrue(hashTable.contains("b"));
        assertTrue(hashTable.contains("c"));
        assertFalse(hashTable.contains("d"));
    }
    @Test
    public void testRemoveAndContains() {
        hashTable.put("a", 5);
        hashTable.put("b", 7);
        hashTable.put("c", 3);
        assertEquals(3, hashTable.size());
        assertTrue(hashTable.contains("b"));
        hashTable.remove("b");
        assertEquals(2, hashTable.size());
        assertFalse(hashTable.contains("b"));
    }

    @Test
    public void testSize() {
        assertEquals(0, hashTable.size());
        hashTable.put("a", 5);
        hashTable.put("b", 7);
        assertEquals(2, hashTable.size());
        hashTable.remove("a");
        assertEquals(1, hashTable.size());
    }
}
