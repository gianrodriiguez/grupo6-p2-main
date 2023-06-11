package src.main.tads.linkedlist;

public class ListaEnlazadaCircular<T extends Comparable<T>> implements Lista<T> {

    NodoDoble<T> primero;
    int size;

    public ListaEnlazadaCircular() {
        this.primero = null;
        this.size = 0;
    }

    @Override
    public void add(T value) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(value);

        if (primero == null) {
            primero = nuevoNodo;
            primero.siguiente = primero;
            primero.anterior = primero;
        }
        else {
            NodoDoble<T> actual = primero;

            while (actual.siguiente != primero) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
            nuevoNodo.anterior = actual;
            nuevoNodo.siguiente = primero;
            primero.anterior = nuevoNodo;
        }
        size ++;
    }

    @Override
    public void remove(int position){
        NodoDoble<T> actual = primero;

        if (primero == null) {
            return;
        }
        if (position == 0) {
            NodoDoble<T> previo = actual.anterior;
            NodoDoble<T> proximo = actual.siguiente;
            previo.siguiente = proximo;
            proximo.anterior = previo;
            size--;
        }
        else if (position > 0){
            int i = 0;

            if (actual.siguiente == null) {
                throw new IllegalArgumentException("El indice es incorrecto");

            } else if (actual.siguiente != null) {
                while (i < position - 1) {
                    actual = actual.siguiente;
                    i++;
                }
                actual.siguiente = actual.siguiente.siguiente;
                size--;
            }
        }
    }

    @Override
    public void addFirst(T value) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(value);

        if (primero == null) {
            primero = nuevoNodo;
            primero.siguiente = primero;
            primero.anterior = primero;
        } else {
            nuevoNodo.siguiente = primero;
            nuevoNodo.anterior = primero.anterior;
            primero.anterior.siguiente = nuevoNodo;
            primero.anterior = nuevoNodo;
            primero = nuevoNodo;
        }
        size++;
    }

    @Override
    public void addAscendente(T value) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(value);

        if (primero == null) {
            primero = nuevoNodo;
            primero.siguiente = primero;
            primero.anterior = primero;
        } else if (value.compareTo(primero.value) <= 0) {
            nuevoNodo.siguiente = primero;
            nuevoNodo.anterior = primero.anterior;
            primero.anterior.siguiente = nuevoNodo;
            primero.anterior = nuevoNodo;
            primero = nuevoNodo;
        } else {
            NodoDoble<T> actual = primero;

            while (actual.siguiente != primero && value.compareTo(actual.siguiente.value) > 0) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            nuevoNodo.anterior = actual;
            actual.siguiente.anterior = nuevoNodo;
            actual.siguiente = nuevoNodo;
        }
        size++;

    }

    @Override
    public void addLast(T value) {

    }

    @Override
    public T get(int position) {

        if (Math.abs(position) > size) {
            System.out.println("Ingrese posicion menor al numero de elementos de la lista");
            return null;
        }

        else {
            NodoDoble<T> actual = primero;
            int i = 0;

            if (position >= 0) {
                while (i < position) {
                    actual = actual.siguiente;
                    i++;
                }
                return actual.value;
            }
            else {
                while (i > position) {
                    actual = actual.anterior;
                    i--;
                }
                return actual.value;
            }
        }
    }

    @Override
    public void print() {
        NodoDoble<T> actual = primero;
        System.out.print("{");
        while (actual != null && actual.siguiente != primero) {
            System.out.print(" [" + actual.value + "] ");
            actual = actual.siguiente;
        }
        System.out.print(" [" + actual.value + "] ");
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
    public void intercambiar(T value, int position) {
        NodoDoble<T> actual = primero;
        NodoDoble<T> previo = actual;

        while (actual.value != value) {
            previo = actual;
            actual = actual.siguiente;
        }
        if (actual.siguiente == primero) {          // Se complica si previo = primero.siguiente

            actual.siguiente = primero.siguiente;
            actual.anterior = primero;
            primero.anterior = previo;
            primero.siguiente = actual;
            primero = actual;

        }
        else {
            NodoDoble<T> proximo = actual.siguiente;
            actual.siguiente = proximo.siguiente;
            actual.anterior = proximo;
            proximo.siguiente = actual;
            proximo.anterior = previo;
            previo.siguiente = proximo;

        }
    }
}
