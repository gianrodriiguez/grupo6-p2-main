package main.tads.tree;

import main.tads.linkedlist.ListaEnlazada;
public class BinarySearchTree<k extends Comparable<k>,T> implements MyBinarySearchTree <k,T> {
    NodoBST<k, T> root;

    public BinarySearchTree() {

        this.root = null;
    }
    @Override
    public void insert(k key, T value) {
        NodoBST<k,T> nuevoNodo = new NodoBST<>(key,value);
        insertHelper(key, root, nuevoNodo);
    }

    private void insertHelper(k key, NodoBST<k,T> actual, NodoBST<k,T> nuevoNodo) {
        if (actual == null && actual == root) {
            root = nuevoNodo;
            return;
        }
//        key actual - key nuevo
//            Izquierda
//                  actual > nuevo  ==> +
        if (actual.getKey().compareTo(key) > 0) { // es negativo si actual.getKey() < key
            if (actual.getleft() == null){
                actual.setleft(nuevoNodo);
            }
            else {
                insertHelper(key, actual.getleft(), nuevoNodo);
            }
        }
//        Derecha
//                  actual < nuevo  ==> -
        else  if (actual.getKey().compareTo(key) < 0) {
            if (actual.getright() == null) {
                actual.setright(nuevoNodo);
            }
            else {
                insertHelper(key, actual.getright(), nuevoNodo);
            }
        }
        else if (actual.getKey().compareTo(key) == 0) {
            System.out.println("Ya existe este key");
            return;
        }
    }

    @Override
    public T find(k key) {
        T element = findHelper(root, key);
        return element;
    }

    private T findHelper(NodoBST<k, T> actual, k key) {
        if (actual == null) {
            return null;
        }
        if (actual.getKey().compareTo(key) > 0) {
            return findHelper(actual.getleft(), key);
        } else if (actual.getKey().compareTo(key) < 0) {
            return findHelper(actual.getright(), key);
        } else {
            return actual.getValue();
        }
    }

//    private T findHelper(NodoBST<k, T> actual, k key) {
//        if (actual == null && actual == root) {
//            return null;
//        }
////                key actual - key find
//        // Izquierda
//        if (actual.getKey().compareTo(key) > 0) {
//            return findHelper(actual.getleft(), key);
//        }
//
//        //  Derecha
//        if (actual.getKey().compareTo(key) < 0) {
//            return findHelper(actual.getright(), key);
//        }
//        if (actual.getKey().compareTo(key) == 0) {
//            return actual.getValue();
//        }
//
//        return null;
//    }
    @Override
    public void delete(k key) {
        root = deleteHelper(root, key);
    }

    private NodoBST<k,T> deleteHelper(NodoBST<k,T> actual, k key) {
        if (actual == null) {
            return null;
        }
        // Izquierda
        if (actual.getKey().compareTo(key) > 0) {
            actual.setleft(deleteHelper(actual.getleft(), key));
        }
        //  Derecha
        else if (actual.getKey().compareTo(key) < 0) {
            actual.setright(deleteHelper(actual.getright(), key));
        }
        // Encontro
        else {
//            sin hijos
            if (actual.getleft() == null && actual.getright() == null) {
                actual = null;
            }// 1 hijo
            else if (actual.getright() == null) {
                actual = actual.getleft();
            }
            else if (actual.getleft() == null) {
                actual = actual.getright();
            }
//            2 hijos
            else {
                NodoBST<k,T> sucesor = findSuccessor(actual.getright());
                actual.setKey(sucesor.getKey());
                actual.setValue(sucesor.getValue());
                actual.setright(deleteHelper(actual.getright(), sucesor.getKey()));
            }
        }
        return actual;
    }

    private NodoBST<k,T> findSuccessor(NodoBST<k,T> actual) {
        if (actual == null || actual.getleft() == null) {
            return actual;
        }
        return findSuccessor(actual.getleft());
    }


    @Override
    public void print() {
        printTreeHelper(root);
        System.out.println();
    }

    private void printTreeHelper(NodoBST<k, T> current) {
        if (current == null) {
            return;
        }

        System.out.print(current.getValue());

        if (current.getleft() != null || current.getright() != null) {
            System.out.print(" (");
            printTreeHelper(current.getleft());
            System.out.print(", ");
            printTreeHelper(current.getright());
            System.out.print(")");
        }
    }

    @Override
    public int size() {
        int size = 0;
        size = sizeHelper(root,size);
        return size;
    }

    private int sizeHelper(NodoBST<k,T> actual, int size) {
        if (actual == null) {
            return size;
        }

        if (actual.getleft() != null) {
            size = sizeHelper(actual.getleft(), size);
        }
        if (actual.getright() != null) {
            size = sizeHelper(actual.getright(), size);
        }

        size += 1;
        return size;
    }

    @Override
    public int countLeaf() {
        int leafCount = 0;
        leafCount = leafHelper(root, leafCount);
        return leafCount;
    }

    private int leafHelper(NodoBST<k,T> actual, int leafCount){
        if (actual == null) {
            return leafCount;
        }

        if (actual.getleft() != null) {
            leafCount = leafHelper(actual.getleft(), leafCount);
        }
        if (actual.getright() != null) {
            leafCount = leafHelper(actual.getright(), leafCount);
        }

        else if (actual.getleft() == null && actual.getright() == null) {
            leafCount += 1;
        }

        return leafCount;
    }

    @Override
    public ListaEnlazada<k> inOrder() {
        ListaEnlazada<k> lista = new ListaEnlazada<>();
        lista = inOrderHelper(root, lista);
        return lista;
    }

    private ListaEnlazada<k> inOrderHelper(NodoBST<k,T> actual, ListaEnlazada<k> lista) {
        if (actual == null) {
            return lista;
        }

        if (actual.getleft() != null) {
            inOrderHelper(actual.getleft(), lista);
        }

        lista.add(actual.getKey());

        if (actual.getright() != null) {
            inOrderHelper(actual.getright(), lista);
        }
        return lista;
    }

    @Override
    public ListaEnlazada<k> preOrder() {
        ListaEnlazada<k> lista = new ListaEnlazada<>();
        lista = preOrderHelper(root, lista);
        return lista;
    }
    private ListaEnlazada<k> preOrderHelper(NodoBST<k,T> actual, ListaEnlazada<k> lista) {
        if (actual == null) {
            return lista;
        }


        lista.add(actual.getKey());

        if (actual.getleft() != null) {
            preOrderHelper(actual.getleft(), lista);
        }
        if (actual.getright() != null) {
            preOrderHelper(actual.getright(), lista);
        }

        return lista;
    }

    @Override
    public ListaEnlazada<k> postOrder() {
        ListaEnlazada<k> lista = new ListaEnlazada<>();
        lista = postOrderHelper(root, lista);
        return lista;
    }

    private ListaEnlazada<k> postOrderHelper(NodoBST<k,T> actual, ListaEnlazada<k> lista) {
        if (actual == null) {
            return lista;
        }

        if (actual.getleft() != null) {
            postOrderHelper(actual.getleft(), lista);
        }

        if (actual.getright() != null) {
            postOrderHelper(actual.getright(), lista);
        }

        lista.add(actual.getKey());
        return lista;
    }
}
