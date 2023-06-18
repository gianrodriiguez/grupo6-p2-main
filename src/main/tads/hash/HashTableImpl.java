package main.tads.hash;

import main.tads.linkedlist.ListaEnlazada;

public class HashTableImpl<K, V> implements HashTable<K, V> {
    private int size;
    private HashNode<K, V>[] table;
    private int capacidad;
    private float incremento;

    public HashTableImpl() {
        this.capacidad = 10;
        this.table = new HashNode[capacidad];
        for (int i = 0; i < capacidad; i++) {
            table[i] = null;
        }
        this.size = 0;
        this.incremento = 0.75f;
    }

    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        int indice = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value, null);

        if (table[indice] == null) {
            table[indice] = newNode;
        } else {
            HashNode<K, V> currentNode = table[indice];
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        size++;

        float currentIncremento = (float) size / capacidad;
        if (currentIncremento > incremento) {
            resizeTable();
        }
    }

    private void resizeTable() {
        int nuevaCapacidad = capacidad * 2;
        HashNode<K, V>[] nuevaTabla = new HashNode[nuevaCapacidad];
        for (int i = 0; i < capacidad; i++) {
            HashNode<K, V> currentNode = table[i];
            while (currentNode != null) {
                int nuevoIndice = hash(currentNode.getKey(), nuevaCapacidad);
                HashNode<K, V> newNode = new HashNode<>(currentNode.getKey(), currentNode.getValue(), null);

                if (nuevaTabla[nuevoIndice] == null) {
                    nuevaTabla[nuevoIndice] = newNode;
                } else {
                    HashNode<K, V> currentNewNode = nuevaTabla[nuevoIndice];
                    while (currentNewNode.getNext() != null) {
                        currentNewNode = currentNewNode.getNext();
                    }
                    currentNewNode.setNext(newNode);
                }
                currentNode = currentNode.getNext();
            }
        }

        table = nuevaTabla;
        capacidad = nuevaCapacidad;
    }

    public ListaEnlazada<V> values() {
        ListaEnlazada<V> valuesList = new ListaEnlazada<>();
        for (HashNode<K, V> node : table) {
            HashNode<K, V> currentNode = node;
            while (currentNode != null) {
                valuesList.add(currentNode.getValue());
                currentNode = currentNode.getNext();
            }
        }
        return valuesList;
    }

    @Override
    public boolean contains(K key) {
        int indice = hash(key);
        HashNode<K, V> currentNode = table[indice];

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
        int indice = hash(key);
        HashNode<K, V> currentNode = table[indice];
        HashNode<K, V> prevNode = null;

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                if (prevNode == null) {
                    table[indice] = currentNode.getNext();
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
        return Math.abs(key.hashCode()) % capacidad;
    }

    private int hash(K key, int capacidad) {
        return Math.abs(key.hashCode()) % capacidad;
    }
}

