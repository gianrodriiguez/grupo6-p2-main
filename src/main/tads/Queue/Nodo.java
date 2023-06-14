package main.tads.Queue;

public class Nodo <T>{

    T value;
    Nodo<T> siguiente;

    public Nodo(T value) {
        this.value = value;
        this.siguiente = null;
    }
}
