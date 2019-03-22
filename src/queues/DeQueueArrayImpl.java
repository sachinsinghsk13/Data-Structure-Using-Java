package queues;

public class DeQueueArrayImpl implements DeQueue {
    private static final int MAX = 100;
    private int[] storage;
    private int rear;
    private int front;

    public DeQueueArrayImpl() {
        storage = new int[MAX];
        rear = front = -1;
    }

    @Override
    public void enQueueAtFront(int item) {
        if (isFull())
            System.out.println("Overflow");
        else {
            if (front == -1)
                front = rear = 0;
            else if (front == 0)
                front = MAX - 1;
            else
                front--;
            storage[front] = item;
        }
    }

    @Override
    public void enQueueAtRear(int item) {
        if (isFull())
            System.out.println("Overflow");
        else {
            if (front == -1)
                front = rear = 0;
            else if (rear == MAX - 1)
                rear = 0;
            else
                rear++;
            storage[rear] = item;
        }
    }

    @Override
    public int deQueueFromFront() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return -1;
        } else {
            int item = storage[front];
            if (front == rear)
                front = rear = -1;
            else if (front == MAX - 1)
                front = 0;
            else
                front++;
            return item;
        }
    }

    @Override
    public int deQueueFromRear() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return -1;
        } else {
            int item = storage[rear];
            if (rear == front)
                rear = front = -1;
            else if (rear == 0)
                rear = MAX - 1;
            else
                rear--;
            return item;
        }
    }

    @Override
    public int peekAtFront() {
        if (!isEmpty())
            return storage[front];
        return -1;
    }

    @Override
    public int peekAtRear() {
        if (!isEmpty())
            return storage[rear];
        return -1;
    }

    @Override
    public boolean isFull() {
        return ((front == 0 && rear == MAX - 1) || front == rear + 1);
    }

    @Override
    public boolean isEmpty() {
        return (front == -1);
    }

}