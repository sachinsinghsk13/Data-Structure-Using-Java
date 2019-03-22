package arrays;

public class StaticArrayList implements SequentialList {
    private final int MAXSIZE;
    private int[] storage;
    private int length;

    public StaticArrayList(int size) {
        if (size > 0)
            MAXSIZE = size;
        else
            MAXSIZE = 15;
        storage = new int[MAXSIZE];
        length = 0;
    }

    public StaticArrayList() {
        this(15);
    }

    @Override
    public void insert(int item) {
        if (!isFull()) {
            storage[length++] = item;
        } else {
            System.out.println("List is Full.");
        }
    }

    @Override
    public void insert(int index, int item) {
        if (!isFull()) {
            if (index >= 0 && index <= length) {
                int temp = length;
                while (temp > index) {
                    storage[temp] = storage[temp - 1];
                    temp--;
                }
                storage[temp] = item;
                length++;
            } else {
                System.out.println("Invalid Index.");
            }
        } else {
            System.out.println("List is Full");
        }
    }

    @Override
    public int remove(int index) {
        if (!isEmpty()) {
            if (index >= 0 && index < length) {
                int temp = storage[index];
                while (index < length - 1) {
                    storage[index] = storage[index + 1];
                    index++;
                }
                length--;
                return temp;
            } else {
                System.out.println("Invalid Index");
                return -2;
            }
        } else {
            System.out.println("List is Empty.");
            return -1;
        }
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean isFull() {
        return length == MAXSIZE;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public int get(int index) {
        if (!isEmpty()) {
            if (index >= 0 && index < length) {
                return storage[index];
            } else {
                System.out.println("Invalid Index.");
                return -1;
            }
        } else {
            System.out.println("List is Empty.");
            return -1;
        }
    }

}