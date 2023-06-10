package Test.linkedlistTest;

import org.junit.Before;
import org.junit.Test;
import uy.edu.um.prog2.adt.linkedlist.ListaEnlazada;

import static org.junit.Assert.assertEquals;

public class linkedListTest {
    private ListaEnlazada lista;

    @Before
    public void setUp() {
        lista = new ListaEnlazada();
    }

    @Test
    public void testAddYGet() {
        lista.add("1");
        lista.add("2");
        assertEquals("1", lista.get(0));
        assertEquals("2", lista.get(1));
    }

    @Test
    public void testRemove() {
        lista.add("1");
        lista.add("2");
        lista.remove(0);
    }
}


