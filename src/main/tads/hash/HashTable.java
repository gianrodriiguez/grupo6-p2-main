package main.tads.hash;

import main.tads.linkedlist.ListaEnlazada;

public interface HashTable<K, V> {

    void put(K key, V value);
    boolean contains(K key);
    void remove(K key);
    int size();
    ListaEnlazada<K> keysToList();
    V get(K key);
    V getOrDefault(K key, V defaultValue);
}
