package queues;

public interface PriorityQueue {
    void enQueue(int item, int priority);

    int deQueue();

    int peek();

    boolean isFull();

    boolean isEmpty();
}