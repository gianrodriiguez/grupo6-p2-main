package src.main.tads.hash;

public interface HashTable<K, V> {

    void put(K key, V value);
    boolean contains(K key);
    void remove(K key);
    int size();
}
