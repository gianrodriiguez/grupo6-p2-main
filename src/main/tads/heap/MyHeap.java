package main.tads.heap;

public interface MyHeap<T extends Comparable<T>>{
    void add(T elemento);
    T delete();
    int size();
    void print();
}
