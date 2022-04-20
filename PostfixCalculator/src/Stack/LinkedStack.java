package Stack;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

    private LinkedList<T> list;

    public LinkedStack() {
        list = new LinkedList<T>();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T input) {
        list.addToFront(input);
    }

    @Override
    public T pop() throws EmptyStackException {
        return list.removeFirst();
    }
}
