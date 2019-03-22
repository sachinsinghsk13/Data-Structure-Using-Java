package stack;

public class StaticArrayStack implements Stack {
    private final int MAX;
    private int[] storage;
    private int tos;

    public StaticArrayStack() {
        MAX = 10;
        storage = new int[MAX];
        tos = -1;
    }

    public StaticArrayStack(int size) {
        if (size > 0)
            MAX = size;
        else
            MAX = 10;
        storage = new int[MAX];
        tos = -1;
    }

    @Override
    public void push(int item) {
        if (!isFull())
            storage[++tos] = item;
        else
            System.out.println("Stack is Full");
    }

    @Override
    public int pop() {
        if (!isEmpty())
            return storage[tos--];
        else
            System.out.println("Stack is Empty.");
        return -1;
    }

    @Override
    public int peek() {
        if (!isEmpty())
            return storage[tos];
        else
            System.out.println("Stack is Empty");
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return tos == -1;
    }

    @Override
    public boolean isFull() {
        return tos == MAX - 1;
    }

    @Override
    public int size() {
        return tos + 1;
    }

}