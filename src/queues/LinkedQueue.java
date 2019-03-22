package queues;

public class LinkedQueue {
    private class Node {
        int data;
        Node next;
    }

    private Node rear;
    private Node front;
    private int length;

    public boolean isEmpty() {
        if (front == null)
            return true;
        return false;
    }

    public void enQueue(int item) {
        if (rear != null) {
            Node node = new Node();
            node.data = item;
            node.next = null;
            rear.next = node;
            rear = node;
            length++;
        } else {
            rear = new Node();
            rear.data = item;
            rear.next = null;
            front = rear;
            length++;
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        } else {
            int item = front.data;
            front = front.next;
            if (front == null)
                front = rear = null;
            length--;
            return item;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        } else {
            return front.data;
        }
    }

    public int size() {
        return length;
    }
}