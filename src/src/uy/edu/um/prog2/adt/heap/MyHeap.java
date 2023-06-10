package src.src.uy.edu.um.prog2.adt.heap;

public interface MyHeap<T extends Comparable<T>>{
    void add(T elemento);
    T delete();
    int size();
    void print();
}
