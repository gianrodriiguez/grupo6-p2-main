package main.tads.Queue;

public class Queue<T> implements MyQueue<T>{

    Nodo<T> head;
    Nodo<T> tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void enqueue(T value) {
        Nodo<T> nuevoNodo = new Nodo<>(value);

        if (head == null) {
            head = nuevoNodo;
        }
        else {
            nuevoNodo.siguiente = head;
            head = nuevoNodo;
        }
    }

    @Override
    public T dequeue() {
        Nodo<T> actual = head;
        if (head == null) {
            System.out.println("Lista vacia");
            return null;
        }
        else if (head.siguiente == null) {
            head = null;
            return actual.value;
        }
        else {
            Nodo<T> previo = head;

            while (actual.siguiente != null) {
                previo = actual;
                actual = actual.siguiente;
            }
            previo.siguiente = null;
            return actual.value;
        }
    }

    @Override
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    @Override
    public void print() {
        Nodo<T> actual = head;
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

    @Override
    public void enqueueConPrioridad(T value, int prioridad) {

    }
}
