package queues;

public class CircularArrayQueue {
    private int[] storage;
    private int front;
    private int rear;
    private int length;
    private final int MAX_SIZE;

    public CircularArrayQueue(int size) {
        MAX_SIZE = size;
        storage = new int[MAX_SIZE];
        front = rear = -1;
    }

    public boolean isFull() {
        if (front == 0 && rear == MAX_SIZE - 1)
            return true;
        else if (front == rear + 1)
            return true;
        return false;
    }

    public boolean isEmpty() {
        if (front == -1)
            return true;
        return false;
    }

    public void enQueue(int item) {
        if (isFull())
            System.out.println("Queue is Full");
        else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % MAX_SIZE;
            storage[rear] = item;
            length++;
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        } else {
            int item = storage[front];
            if (front >= rear)
                front = rear = -1;
            else
                front = (front + 1) % MAX_SIZE;
            length--;
            return item;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        } else {
            return storage[front];
        }
    }

    public int size() {
        return length;
    }
}