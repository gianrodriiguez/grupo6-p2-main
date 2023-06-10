package src.src.uy.edu.um.prog2.adt.hash;

public interface HashTable<K, V> {

    void put(K key, V value);
    boolean contains(K key);
    void remove(K key);
    int size();
}
