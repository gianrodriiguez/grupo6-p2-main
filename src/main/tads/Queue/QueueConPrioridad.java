package src.main.tads.Queue;

public class QueueConPrioridad <T> implements MyQueue<T> {

    NodoConPrioridad<T> head;
    NodoConPrioridad<T> tail;

    public QueueConPrioridad() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void enqueueConPrioridad(T value, int prioridad) {
        NodoConPrioridad<T> nuevoNodo = new NodoConPrioridad<>(value,prioridad);

        if (head == null) {
            head = nuevoNodo;
        }
        else {
            NodoConPrioridad<T> actual = head;
            NodoConPrioridad<T> previo = actual;

            while (actual != null && prioridad <= actual.prioridad) {
                previo = actual;
                actual = actual.siguiente;
            }
            if (actual == null) {
                previo.siguiente = nuevoNodo;
                tail = nuevoNodo;
            }
            else {
                if (previo == actual) {
                    nuevoNodo.siguiente = head;
                    head = nuevoNodo;
                }
                else {
                    previo.siguiente = nuevoNodo;
                    nuevoNodo.siguiente = actual;
                }
            }
        }
    }
    @Override
    public void enqueue(T value) {
    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void print() {
        NodoConPrioridad<T> actual = head;
        if (actual == null) {
            System.out.println("[ ]");
        }
        else {
            System.out.println();

            while (actual != null) {
                System.out.print(" [ " + actual.value + " ] ");
                actual = actual.siguiente;
            }
        }
    }

    @Override
    public void enqueueLeft(T value) {

    }

    @Override
    public T dequeueLeft() {
        return null;
    }

    @Override
    public void enqueueRight(T value) {

    }

    @Override
    public T dequeueRight() {
        return null;
    }
}
