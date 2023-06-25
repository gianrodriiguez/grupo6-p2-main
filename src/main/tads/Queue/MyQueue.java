package main.tads.Queue;

import java.util.Comparator;

public interface MyQueue<T, K, V> {
    void enqueue(T value);
    T dequeue();
    boolean isEmpty();
    void print();
    void enqueueLeft(T value);
    T dequeueLeft();
    void enqueueRight(T value);
    T dequeueRight();
    void enqueueConPrioridad(K key, V value);
    int size();
}