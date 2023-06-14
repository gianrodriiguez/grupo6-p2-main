package main.tads.stack;

import java.util.EmptyStackException;

public class Stack<T> implements MyStack<T> {

    Nodo<T> top;

    public Stack() {
        this.top = null;
    }

    @Override
    public void print() {
        Nodo<T> actual = top;
        if (actual == null) {
            System.out.println("[ ]");
        }
        else {
            System.out.println("[ " + actual.value + " ] top");
            actual = actual.siguiente;
            while (actual != null) {
                System.out.println("[ " + actual.value + " ]");
                actual = actual.siguiente;
            }
        }
    }

    @Override // LAST IN FIRST OUT
    public void push(T value) {
        Nodo<T> nuevoNodo = new Nodo<>(value);
        Nodo<T> actual = top;

        if (actual == null) {
            top = nuevoNodo;
        }
        else {
            nuevoNodo.siguiente = top;
            top = nuevoNodo;
        }
    }

    @Override
    public void pop() throws EmptyStackException {
        if (top == null) {
            throw new EmptyStackException();
        }
        else {
            top = top.siguiente;
        }
    }

    @Override
    public T top() {
        if (top == null) {
            return null;
        }
        return top.value;
    }

    @Override
    public boolean isEmpty() {
        return (top == null);
    }

    @Override
    public void makeEmpty() {
        if (top != null) {
            top = null;
        }
    }

}
