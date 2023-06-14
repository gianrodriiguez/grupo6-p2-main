package main.tads.tree;

public class NodoBST<k extends Comparable<k>,T>{
    NodoBST<k,T> left;
    NodoBST<k,T> right;
    T value;
    k key;

    public NodoBST(k key, T value) {
        this.left = null;
        this.right = null;
        this.key = key;
        this.value = value;
    }

    public NodoBST<k, T> getleft() {
        return left;
    }

    public void setleft(NodoBST<k, T> left) {
        this.left = left;
    }

    public NodoBST<k, T> getright() {
        return right;
    }

    public void setright(NodoBST<k, T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public k getKey() {
        return key;
    }

    public void setKey(k key) {
        this.key = key;
    }
}

