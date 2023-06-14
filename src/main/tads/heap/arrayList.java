package main.tads.heap;

public class arrayList<T> {
    private static final int Tamaño = 10;

    private T[] array;
    private int size;

    public arrayList() {
        this(Tamaño);
    }

    public arrayList(int tamañoInicial) {
        array = (T[]) new Object[tamañoInicial];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void add(T element) {
        if (size == array.length) {
            agrandarArray();
        }
        array[size] = element;
        size++;
    }

    public T get(int posicion) {
        if (posicion < 0 || posicion >= size) {
            System.out.println("posicion mal");
            return null;
        }
        return array[posicion];
    }

    public void set(int posicion, T element) {
        if (posicion < 0 || posicion >= size) {
            System.out.println("posicion mal");
            return;
        }
        array[posicion] = element;
    }

    public void remove(int posicion) {
        if (posicion < 0 || posicion >= size) {
            System.out.println("posicion mal");
            return;
        }
        for (int i = posicion; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    private void agrandarArray() {
        int nuevoTamaño = array.length * 2;
        T[] nuevoArray = (T[]) new Object[nuevoTamaño];

        for (int i = 0; i < size; i++) {
            nuevoArray[i] = array[i];
        }
        array = nuevoArray;
    }
}