package main.tads.heap;

import main.tads.linkedlist.ListaEnlazada;

public interface MyHeap<T extends Comparable<T>>{
    void add(T elemento);
    T delete();
    int size();
    void print();
}
