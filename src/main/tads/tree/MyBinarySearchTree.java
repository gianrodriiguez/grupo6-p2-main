package main.tads.tree;

import main.tads.linkedlist.ListaEnlazada;

public interface MyBinarySearchTree<k,T> {
    void insert(k key, T value);
    T find(k key);
    void delete(k key);
    void print();
    int size();
    int countLeaf();
    ListaEnlazada<k> inOrder();
    ListaEnlazada<k> preOrder();
    ListaEnlazada<k> postOrder();
}
