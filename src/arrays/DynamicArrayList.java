package arrays;

public class DynamicArrayList implements SequentialList {
    private int MAXSIZE;
    private int[] storage;
    private int length;

    private void increseCapacity() {
        int[] temp = new int[2 * MAXSIZE];
        for (int i = 0; i < storage.length; i++)
            temp[i] = storage[i];
        storage = temp;
        MAXSIZE *= 2;
    }

    public DynamicArrayList(int size) {
        if (size > 0)
            MAXSIZE = size;
        else
            MAXSIZE = 15;
        storage = new int[MAXSIZE];
        length = 0;
    }

    public DynamicArrayList() {
        this(15);
    }

    @Override
    public void insert(int item) {
        if (!isFull()) {
            storage[length++] = item;
        } else {
            increseCapacity();
            insert(item);
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
            increseCapacity();
            insert(index, item);
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