package main.tads.linkedlist;

public interface Lista <T> {
    void add(T value);
    boolean contains(T value);
    void addLast(T value);
    void remove(int position);
    T get(int position);
    void print();
    boolean isEmpty();
    void visualizar(ListaEnlazada<Integer> listaP);
    boolean lookFor(T value);
    void intercambiar(T value, int direccion);
    void addFirst(T value);
    void addAscendente(T value);

}
