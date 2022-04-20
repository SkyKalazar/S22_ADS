package Stack;

import java.util.EmptyStackException;

public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addToFront(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        Node<T> temp = head;
        head = head.getNext();
        size--;

        return temp.getData();
    }
}
