package queues;

public class PriorityQueueArray implements PriorityQueue {
    private class Node {
        int data;
        int priority;
    }

    private final int MAX;
    private Node[] storage;
    int next;

    public PriorityQueueArray(int size) {
        MAX = size;
        storage = new Node[MAX];
        next = -1;
    }

    @Override
    public void enQueue(int item, int priority) {
        if (!isFull()) {
            Node node = new Node();
            node.data = item;
            node.priority = priority;
            storage[++next] = node;
        } else {
            System.out.println("Priority Queue is Full.");
        }
    }

    @Override
    public int deQueue() {
        if (!isEmpty()) {
            Node node = null;
            int index = 0;
            int max_priority = 100;
            for (int i = 0; i <= next; i++) {
                if (storage[i].priority < max_priority) {
                    max_priority = storage[i].priority;
                    node = storage[i];
                    index = i;
                }
            }

            if (next != 0) {
                storage[index] = storage[next];
            }

            next--;
            return node.data;
        } else {
            System.out.println("Empty.");
            return -1;
        }
    }

    @Override
    public int peek() {
        if (!isEmpty()) {
            Node node = null;
            int max_priority = 100;
            for (int i = 0; i <= next; i++) {
                if (storage[i].priority < max_priority) {
                    max_priority = storage[i].priority;
                    node = storage[i];
                }
            }
            return node.data;
        } else {
            System.out.println("Empty.");
            return -1;
        }
    }

    @Override
    public boolean isFull() {
        return next == MAX - 1;
    }

    @Override
    public boolean isEmpty() {
        return next == -1;
    }

}