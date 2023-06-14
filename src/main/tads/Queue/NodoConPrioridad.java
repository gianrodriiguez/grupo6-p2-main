package main.tads.Queue;

public class NodoConPrioridad<T> {
    T value;
    int prioridad;
    NodoConPrioridad<T> siguiente;

    public NodoConPrioridad(T value, int prioridad) {
        this.value = value;
        this.prioridad = prioridad;
        this.siguiente = null;
    }

}
