package stack;

public class DynamicArrayStack implements Stack {
    private int MAX;
    private int[] storage;
    private int tos;

    public DynamicArrayStack() {
        MAX = 10;
        storage = new int[MAX];
        tos = -1;
    }

    public DynamicArrayStack(int size) {
        if (size > 0)
            MAX = size;
        else
            MAX = 10;
        storage = new int[MAX];
        tos = -1;
    }

    private void increseCapacity() {
        int[] temp = new int[2 * MAX];
        for (int i = 0; i < storage.length; i++)
            temp[i] = storage[i];
        storage = temp;
        MAX *= 2;
    }

    @Override
    public void push(int item) {
        if (tos == MAX - 1)
            increseCapacity();
        storage[++tos] = item;
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
        return false;
    }

    @Override
    public int size() {
        return tos + 1;
    }

}