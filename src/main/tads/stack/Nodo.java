package main.tads.stack;

public class Nodo<T> {

    T value;
    Nodo<T> siguiente;

    public Nodo(T value) {
        this.value = value;
        this.siguiente = null;
    }
}
