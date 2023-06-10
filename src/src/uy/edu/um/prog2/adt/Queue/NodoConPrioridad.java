package src.src.uy.edu.um.prog2.adt.Queue;

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
