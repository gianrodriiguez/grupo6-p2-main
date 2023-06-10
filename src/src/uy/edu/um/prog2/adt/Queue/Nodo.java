package src.src.uy.edu.um.prog2.adt.Queue;

public class Nodo <T>{

    T value;
    Nodo<T> siguiente;

    public Nodo(T value) {
        this.value = value;
        this.siguiente = null;
    }
}
