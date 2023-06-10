package src.src.uy.edu.um.prog2.adt.Queue;

public class QueueDoble<T> implements MyQueue<T> {
    NodoDoble<T> head;
    NodoDoble<T> tail;
    public QueueDoble() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void print() {
        if (head == null) {
            System.out.println("[ ]");
        }
        else {
            NodoDoble<T> actual = head;
            System.out.println();
            System.out.print(" [ " + actual.value + " ] ");
            actual = actual.siguiente;
            while (actual != head && actual != null) {
                System.out.print(" [ " + actual.value + " ] ");
                actual =actual.siguiente;
            }
        }
    }

    @Override
    public void enqueueLeft(T value) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(value);
        NodoDoble<T> actual = head;

        if (head == null) {
            head = nuevoNodo;
        }
        else if (head.siguiente == null) {
            head.siguiente = nuevoNodo;
            head.anterior = nuevoNodo;
            nuevoNodo.siguiente = head;
            nuevoNodo.anterior = head;
            tail = actual;
            head = nuevoNodo;
        }
        else {
            tail.siguiente = nuevoNodo;
            head.anterior = nuevoNodo;
            nuevoNodo.anterior = tail;
            nuevoNodo.siguiente = head;
            head = nuevoNodo;
            }
        }


    @Override
    public void enqueueRight(T value) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(value);
        NodoDoble<T> actual = tail;

        if (head == null) {
            head = nuevoNodo;
        }
        else if (head.siguiente == null) {
            head.siguiente = nuevoNodo;
            head.anterior = nuevoNodo;
            nuevoNodo.siguiente = head;
            nuevoNodo.anterior = head;
            tail = nuevoNodo;
        }
        else {
            tail.siguiente = nuevoNodo;
            nuevoNodo.anterior = tail;
            nuevoNodo.siguiente = head;
            head.anterior = nuevoNodo;
            tail = nuevoNodo;
        }
    }
    @Override
    public T dequeueLeft() {
        if (head.siguiente == null) {
            NodoDoble<T> deletedNode = head;
            head = null;
            return deletedNode.value;
        }
        else {
            if (tail.anterior == head) {
                NodoDoble<T> deletedNode = head;
                tail.siguiente = null;
                tail.anterior = null;
                head = tail;
                return deletedNode.value;
            }
            else {
                NodoDoble<T> deletedNode = head;
                NodoDoble<T> actual = head.siguiente;
                actual.anterior = tail;
                tail.siguiente = actual;
                head = actual;
                return deletedNode.value;
            }
        }
    }

    @Override
    public T dequeueRight() {

        if (head.siguiente == null) {
            NodoDoble<T> deletedNode = head;
            head = null;
            return deletedNode.value;
        }
        else {
            if (tail.anterior == head) {
                NodoDoble<T> deletedNode = tail;
                head.siguiente = null;
                head.anterior = null;
                return deletedNode.value;
            }
            else {
                NodoDoble<T> deletedNode = tail;
                NodoDoble<T> actual = tail.anterior;
                actual.siguiente = head;
                head.anterior = actual;
                tail = actual;
                return deletedNode.value;
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
    public void enqueueConPrioridad(T value, int prioridad) {

    }
}
