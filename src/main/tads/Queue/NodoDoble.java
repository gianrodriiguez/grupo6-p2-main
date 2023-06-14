package main.tads.Queue;

public class NodoDoble<T> {

    T value;
    NodoDoble<T> anterior;
    NodoDoble<T> siguiente;

    public NodoDoble(T value) {
        this.value = value;
        this.anterior = null;
        this.siguiente = null;
    }
}
