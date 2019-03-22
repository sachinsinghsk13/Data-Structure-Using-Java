package queues;

public class DeQueueLinkedImpl implements DeQueue {
    private static class Node {
        int data;
        Node next;

        Node(int item) {
            this.data = item;
        }
    }

    private Node rear;
    private Node front;

    @Override
    public void enQueueAtFront(int item) {
        Node node = new Node(item);
        if (isEmpty()) {
            front = rear = node;
            node.next = node;
        } else {
            node.next = front;
            rear.next = node;
            front = node;
        }
    }

    @Override
    public void enQueueAtRear(int item) {
        Node node = new Node(item);
        if (isEmpty()) {
            front = rear = node;
            node.next = node;
        } else {
            node.next = rear.next;
            rear.next = node;
            rear = node;
        }
    }

    @Override
    public int deQueueFromFront() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return -1;
        } else {
            int item = front.data;
            if (front == rear)
                front = rear = null;
            else
                front = front.next;
            return item;
        }
    }

    @Override
    public int deQueueFromRear() {
        if (isEmpty()) {
            System.out.println("Underflow!");
            return -1;
        } else {
            int item = rear.data;
            if (rear.next == rear)
                rear = front = null;
            else {
                Node temp_ref = rear.next;
                while (temp_ref.next != rear)
                    temp_ref = temp_ref.next;
                temp_ref.next = rear.next;
                rear = temp_ref;
            }
            return item;
        }
    }

    @Override
    public int peekAtFront() {
        if (!isEmpty())
            return front.data;
        return -1;
    }

    @Override
    public int peekAtRear() {
        if (!isEmpty())
            return rear.data;
        return -1;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (rear == null && front == null);
    }

}