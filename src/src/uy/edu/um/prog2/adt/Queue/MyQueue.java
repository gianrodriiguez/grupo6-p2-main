package src.src.uy.edu.um.prog2.adt.Queue;

public interface MyQueue<T> {
    void enqueue (T value);
    T dequeue ();
    boolean isEmpty();
    void print();
    void enqueueLeft (T value);
    T dequeueLeft ();
    void enqueueRight (T value);
    T dequeueRight ();
    void enqueueConPrioridad(T value, int prioridad);

}
