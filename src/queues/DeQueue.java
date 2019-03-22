package queues;

public interface DeQueue {
    void enQueueAtFront(int item);

    void enQueueAtRear(int item);

    int deQueueFromFront();

    int deQueueFromRear();

    int peekAtFront();

    int peekAtRear();

    boolean isFull();

    boolean isEmpty();
}