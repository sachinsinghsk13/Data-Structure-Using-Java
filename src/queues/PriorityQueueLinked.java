package queues;

public class PriorityQueueLinked implements PriorityQueue {
    private static class Node {
        int data;
        int priority;
        Node next;

        Node(int d, int p) {
            this.data = d;
            this.priority = p;
        }
    }

    private Node head;

    @Override
    public void enQueue(int item, int priority) {
        Node node = new Node(item, priority);
        if (head != null) {
            if (node.priority < head.priority) {
                node.next = head;
                head = node;
            } else {
                Node temp = head;
                while (temp.next != null && node.priority >= temp.next.priority)
                    temp = temp.next;
                node.next = temp.next;
                temp.next = node;
            }
        } else {
            head = node;
        }
    }

    @Override
    public int deQueue() {
        if (!isEmpty()) {
            int item = head.data;
            head = head.next;
            return item;
        } else
            return -1;
    }

    @Override
    public int peek() {
        if (!isEmpty())
            return head.data;
        else
            return -1;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

}