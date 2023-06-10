package src.src.uy.edu.um.prog2.adt.hash;

public class HashTableImpl<K, V> implements HashTable<K, V> {
    private int size;
    private HashNode<K, V>[] table;
    private int capacity;

    public HashTableImpl(int capacity) {
        this.table = new HashNode[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
        this.capacity = capacity;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value, null);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            HashNode<K, V> currentNode = table[index];
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        size++;
    }

    @Override
    public boolean contains(K key) {
        int index = hash(key);
        HashNode<K, V> currentNode = table[index];

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public void remove(K key) {
        int index = hash(key);
        HashNode<K, V> currentNode = table[index];
        HashNode<K, V> prevNode = null;

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                if (prevNode == null) {
                    table[index] = currentNode.getNext();
                } else {
                    prevNode.setNext(currentNode.getNext());
                }
                size--;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}

