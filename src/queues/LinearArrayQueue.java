package queues;

/**
 * A queue is a useful data structure in programming.
 * Queue follows the First In First Out(FIFO) rule - the item that goes in first is the item that comes out first too.
 *
 * @author Sachin Singh
 */
public class LinearArrayQueue {
    private int[] storage;
    private int front;
    private int rear;
    private final int MAX_SIZE;

    /**
     * Constructs a Queue with specified size
     *
     * @param size size of the queue
     */
    public LinearArrayQueue(int size) {
        MAX_SIZE = size;
        storage = new int[MAX_SIZE];
        rear = front = -1;
    }

    /**
     * Construct a Queue of size 10
     */
    public LinearArrayQueue() {
        this(10);
    }

    /**
     * return true if queue has no items otherwise returns false;
     *
     * @return true is queue is empty
     */
    public boolean isEmpty() {
        if (front == -1)
            return true;
        return false;
    }

    /**
     * if queue has no more space to store items then returns true
     *
     * @return return true if queue is full
     */
    public boolean isFull() {
        if (rear == MAX_SIZE - 1)
            return true;
        return false;
    }

    /**
     * inserts a item in the queue if it has available space.
     *
     * @param item item to be inserted in the queue
     */
    public void enQueue(int item) {
        if (isFull())
            System.out.println("Queue is Full.");
        else {
            if (front == -1)
                front = 0;
            rear++;
            storage[rear] = item;
        }
    }

    /**
     * Deletes the item front of the queue if queue is not empty
     *
     * @return returns the item front of the queue if queue is empty it returns -1
     */
    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return -1;
        } else {
            int item = storage[front];
            if (front >= rear)
                front = rear = -1;
            else
                front++;
            return item;
        }
    }

    /**
     * returns the front item of queue but not deletes the item
     *
     * @return return the front item of the queue without deleting it. if queue is empty returns -1
     */
    public int peek() {
        if (isEmpty()) {
            System.out.println("No Items in Queue");
            return -1;
        } else {
            return storage[front];
        }
    }

    /**
     * @return number of items in the queue
     */
    public int size() {
        if (isEmpty())
            return 0;
        else {
            int count = 0;
            for (int i = front; i <= rear; i++)
                count++;
            return count;
        }
    }

    /**
     * Displays the queue state.
     */
    public void display() {
        if (isEmpty())
            System.out.print("Queue is Empty.");
        else {
            System.out.println("Rear : " + rear);
            for (int i = front; i <= rear; i++) {
                System.out.print(storage[i] + " ");
            }
            System.out.println();
            System.out.println("Front : " + front);
        }
    }

}