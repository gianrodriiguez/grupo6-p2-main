package main.tads.Queue;

import java.util.Comparator;

public class QueueConPrioridad<K extends Comparable<K>, V> implements MyQueue<QueueConPrioridad.Entry<K, V>, K, V> {

    private NodoConPrioridad<Entry<K, V>> head;
    private NodoConPrioridad<Entry<K, V>> tail;
    private int size;

    public QueueConPrioridad() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void enqueueConPrioridad(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value);
        NodoConPrioridad<Entry<K, V>> nuevoNodo = new NodoConPrioridad<>(entry, 0);
        if (head == null) {
            head = nuevoNodo;
            tail = nuevoNodo;
        } else {
            if (key.compareTo(head.value.getKey()) > 0) {
                nuevoNodo.siguiente = head;
                head = nuevoNodo;
            } else if (key.compareTo(tail.value.getKey()) <= 0) {
                tail.siguiente = nuevoNodo;
                tail = nuevoNodo;
            } else {
                NodoConPrioridad<Entry<K, V>> actual = head;
                while (actual.siguiente != null && key.compareTo(actual.siguiente.value.getKey()) <= 0) {
                    actual = actual.siguiente;
                }
                nuevoNodo.siguiente = actual.siguiente;
                actual.siguiente = nuevoNodo;
            }
        }
        size++;
    }

    @Override
    public void enqueue(Entry<K, V> entry) {
    }

    @Override
    public Entry<K, V> dequeue() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, V> entry = head.value;
        head = head.siguiente;
        if (head == null) {
            tail = null;
        }
        size--;
        return entry;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        NodoConPrioridad<Entry<K, V>> actual = head;
        if (actual == null) {
            System.out.println("[ ]");
        } else {
            System.out.print("[ ");
            while (actual != null) {
                System.out.print(actual.value + " ");
                actual = actual.siguiente;
            }
            System.out.println("]");
        }
    }

    @Override
    public void enqueueLeft(Entry<K, V> entry) {
        enqueue(entry);
    }

    @Override
    public Entry<K, V> dequeueLeft() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, V> entry = tail.value;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            NodoConPrioridad<Entry<K, V>> actual = head;
            while (actual.siguiente != tail) {
                actual = actual.siguiente;
            }
            actual.siguiente = null;
            tail = actual;
        }
        size--;
        return entry;
    }

    @Override
    public void enqueueRight(Entry<K, V> entry) {
    }

    @Override
    public Entry<K, V> dequeueRight() {
        return dequeue();
    }

    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }
}
