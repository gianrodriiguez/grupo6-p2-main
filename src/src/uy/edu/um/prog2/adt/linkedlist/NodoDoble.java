package src.src.uy.edu.um.prog2.adt.linkedlist;

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
