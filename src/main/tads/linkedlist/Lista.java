package main.tads.linkedlist;

public interface Lista <T> {
    void add(T value);
    void addFirst(T value);
    void addAscendente(T value);
    void addLast(T value);
    void remove(int position);
    T get(int position);

    void print();
    void visualizar(ListaEnlazada<Integer> listaP);

    boolean lookFor(T value);
    void intercambiar(T value, int direccion);

}
