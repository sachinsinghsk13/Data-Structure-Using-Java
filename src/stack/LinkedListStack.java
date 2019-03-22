package stack;

public class LinkedListStack<T> {
    private class Node {
        T data;
        Node next;
    }

    Node top;
    private int length;

    public void push(T item) {
        Node node = new Node();
        node.data = item;
        if (top != null)
            node.next = top;
        top = node;
        length++;
    }

    public T pop() {
        if (!isEmpty()) {
            T temp = top.data;
            top = top.next;
            length--;
            return temp;
        } else
            return null;
    }

    public T peek() {
        if (!isEmpty()) {
            return top.data;
        } else
            return null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return length;
    }
}