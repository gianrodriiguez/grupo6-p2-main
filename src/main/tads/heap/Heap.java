package main.tads.heap;

import main.tads.linkedlist.ListaEnlazada;

public class Heap<T extends Comparable<T>> implements MyHeap<T> {
    private arrayList<T> heap;
    private boolean esMaxHeap;

    public Heap(boolean esMaxHeap) {
        heap = new arrayList<>();
        this.esMaxHeap = esMaxHeap;
    }

    public void add(T element) {
        heap.add(element);
        subir(heap.size() - 1);
    }

    public T delete() {
        if (heap.size() == 0) {
            return null;
        }

        T root = heap.get(0);
        T ultimo = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);

        if (heap.size() > 0) {
            heap.set(0, ultimo);
            bajar(0);
        }
        return root;
    }

    public int size() {
        return heap.size();
    }

    public void print() {
        int size = heap.size();
        int profundidad = 0;
        int posicion = 0;
        int nivel = 1;

        while (posicion < size) {
            for (int i = 0; i < nivel && posicion < size; i++) {
                System.out.print(heap.get(posicion) + " ");
                posicion++;
            }
            System.out.println();
            profundidad++;
            nivel *= 2;
        }
    }

    private void subir(int posicion) {
        while (posicion > 0 && compare(heap.get(posicion), heap.get((posicion - 1) / 2)) > 0) {
            cambioLugar(posicion, (posicion - 1) / 2);
            posicion = (posicion - 1) / 2;
        }
    }

    private void bajar(int posicion) {
        int maxChildPosicion;
        int leftPosicion;
        int rightPosicion;

        while (posicion < heap.size() / 2) {
            leftPosicion = 2 * posicion + 1;
            rightPosicion = 2 * posicion + 2;
            if (rightPosicion < heap.size() && compare(heap.get(rightPosicion), heap.get(leftPosicion)) > 0) {
                maxChildPosicion = rightPosicion;
            } else {
                maxChildPosicion = leftPosicion;
            }
            if (compare(heap.get(posicion), heap.get(maxChildPosicion)) >= 0) {
                break;
            }
            cambioLugar(posicion, maxChildPosicion);
            posicion = maxChildPosicion;
        }
    }

    private void cambioLugar(int i, int j) {
        T cambio = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, cambio);
    }

    private int compare(T a, T b) {
        if (esMaxHeap) {
            return a.compareTo(b);
        } else {
            return b.compareTo(a);
        }
    }
}
