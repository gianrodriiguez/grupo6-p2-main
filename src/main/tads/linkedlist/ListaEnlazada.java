package main.tads.linkedlist;

public class ListaEnlazada<T> implements Lista<T> {
    private Nodo<T> primero;
    private int size;

    public ListaEnlazada() {
        this.size = 0;
        this.primero = null;
    }

    public int size() {
        return size;
    }

    @Override
    public boolean contains(T value) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.value.equals(value)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // ADD ELEMENT IN posicion i
    @Override
    public void add(T value) {
        Nodo<T> nuevoNodo = new Nodo<T>(value);

        if (primero == null) {
            primero = nuevoNodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        size++;
    }

    // REMOVE ELEMENT IN posicion i
    @Override
    public void remove(int posicion) {
        if (primero == null) {
            return;
        } else if (posicion == 0) {
            primero = primero.siguiente;
            size--;
        } else if (posicion > 0 && posicion < size) {
            Nodo<T> actual = primero;
            int i = 0;

            while (i < posicion - 1) {
                actual = actual.siguiente;
                i++;
            }

            actual.siguiente = actual.siguiente.siguiente;
            size--;
        }
    }

    // GET ELEMENT IN posicion i
    @Override
    public T get(int posicion) {
        if (Math.abs(posicion) >= size) {
            return null;
        } else {
            if (posicion == 0) {
                return primero.value;
            } else if (posicion > 0) {
                int i = 0;
                Nodo<T> actual = primero;
                while (i < posicion) {
                    actual = actual.siguiente;
                    i++;
                }
                return actual.value;
            }
            return null;
        }
    }

    @Override
    public void print() {
        Nodo<T> nodoActual;
        nodoActual = primero;
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
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.value.equals(value)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public void addFirst(T value) {
        Nodo<T> nuevoNodo = new Nodo<>(value);

        if (primero == null) {
            primero = nuevoNodo;
        }
        else {
            nuevoNodo.siguiente = primero;
            primero = nuevoNodo;
        }
        size ++;
    }

    @Override
    public void addLast(T value) {

        Nodo<T> nodoNuevo = new Nodo<>(value);
        Nodo<T> actual = primero;

        if (primero == null) {
            primero = nodoNuevo;
        }
        else {
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nodoNuevo;
        }
        size++;
    }

    @Override
    public void addAscendente(T value) {
        Nodo<T> nuevoNodo = new Nodo<>(value);
        Nodo<T> actual = primero;
        Nodo<T> previo = actual;

        if (actual == null) {
            primero = nuevoNodo;
        }
        else {    //cambie actual.siguiente por actual aca        //        A > B ?  if true 1, false -1, else 0
            while (actual != null && ((Comparable<T>) actual.value).compareTo(value) < 0) {
                previo = actual;
                actual = actual.siguiente;
            }
            if (actual == null) {   // Mas grande de la lista, llego al final
                previo.siguiente = nuevoNodo;
            }
            else {
                if (previo == actual) {     // Mas chico de la lista, quedo al principio
                    nuevoNodo.siguiente = actual;
                    primero = nuevoNodo;
                }
                else {
                    previo.siguiente = nuevoNodo;
                    nuevoNodo.siguiente = actual;
                }
            }
        }
        size++;
    }

    @Override
    public void visualizar(ListaEnlazada<Integer> listaP) {

        Nodo<Integer>  actualP = listaP.primero;
//        Nodo<T> actualL = primero;

        int j = 0;
        Integer i = 0;
        while (actualP != null) {
            if (i == actualP.value) {
                System.out.println(get(j)); //actualL.value
                actualP = actualP.siguiente;
                i++;
                j++;
            }
            else {
                i++;
                j++;
            }
        }
    }

    @Override
    public void intercambiar(T value, int direccion) {
    }
}
