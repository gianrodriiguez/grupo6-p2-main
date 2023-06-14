package main.tads.stack;

import java.util.EmptyStackException;

public interface MyStack<T> {
    void pop() throws EmptyStackException;
    T top();
    void push(T element);
    boolean isEmpty();
    void makeEmpty();
    void print();

}
