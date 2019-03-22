package stack;

public interface Stack {
    void push(int item);

    int pop();

    int peek();

    boolean isEmpty();

    boolean isFull();

    int size();
}