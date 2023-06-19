package main.tads.linkedlist;

public class ListaEnlazadaDoble<T extends  Comparable<T>> implements Lista <T> {

    NodoDoble<T> primero;

    int size;

    public ListaEnlazadaDoble() {
        this.primero = null;
        this.size = 0;
    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    @Override
    public void add(T value) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(value);

        if (primero == null) {
            primero = nuevoNodo;
        } else {
            nuevoNodo.siguiente = primero;
            primero.anterior = nuevoNodo;
            primero = nuevoNodo;
        }

        size++;
    }

    @Override
    public void addFirst(T value) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(value);

        if (primero == null) {
            primero = nuevoNodo;
        } else {
            nuevoNodo.siguiente = primero;
            primero.anterior = nuevoNodo;
            primero = nuevoNodo;
        }

        size++;
    }
    @Override
    public void addAscendente(T value) {         // Agrega ascendente, solo funciona con positivos

        NodoDoble<T> nuevoNodo = new NodoDoble<>(value);
        NodoDoble<T> actual = primero;
        NodoDoble<T> ultimo = actual;

        while (actual != null && ((Comparable<T>) actual.value).compareTo(value) < 0) {
            ultimo = actual;
            actual = actual.siguiente;
        }
        if (actual == null) {
            if(ultimo == null) {
                primero = nuevoNodo;
            }
            else {
                ultimo.siguiente = nuevoNodo;
                nuevoNodo.anterior = ultimo;
            }
        }
        else {
            if (ultimo == null) {
                nuevoNodo.siguiente = primero;
                primero.anterior = nuevoNodo;
                nuevoNodo = primero;
            }
            else {
                ultimo.siguiente = nuevoNodo;
                nuevoNodo.anterior = ultimo;
                actual.anterior = nuevoNodo;
                nuevoNodo.siguiente = actual;
            }
        }
        size ++;
    }

    @Override
    public void addLast(T value) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(value);

        if (primero == null) {
            primero = nuevoNodo;
        } else {
            NodoDoble<T> actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
            nuevoNodo.anterior = actual;
        }

        size++;
    }

    @Override
    public void remove(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        if (position == 0) {
            if (primero.siguiente != null) {
                primero.siguiente.anterior = null;
            }
            primero = primero.siguiente;
        } else {
            NodoDoble<T> current = primero;
            for (int i = 0; i < position; i++) {
                current = current.siguiente;
            }
            current.anterior.siguiente = current.siguiente;
            if (current.siguiente != null) {
                current.siguiente.anterior = current.anterior;
            }
        }

        size--;
    }

    @Override
    public T get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        NodoDoble<T> current = primero;
        for (int i = 0; i < position; i++) {
            current = current.siguiente;
        }

        return current.value;
    }

    @Override
    public void print() {
        NodoDoble<T> nodoActual = primero;
        System.out.print("{");
        while (nodoActual != null) {
            System.out.print(" [" + nodoActual.value + "] ");
            nodoActual = nodoActual.siguiente;
        }
        System.out.print("}");
        System.out.println();
    }

    @Override
    public boolean lookFor(T value) {
        return false;
    }

    @Override
    public void visualizar(ListaEnlazada<Integer> listaP) {

    }

    @Override
    public void intercambiar(T value, int direccion) {
        if (direccion == -1) {

        }
    }
}
