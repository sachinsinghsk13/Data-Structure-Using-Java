package searching;

public class LinearSearch {
    // complexity :- O(n)
    // Iterative way
    public static int search(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    // recursive way
    public static int search(int[] arr, int n, int key) {
        if (n < 0)
            return -1;
        else if (arr[n] == key)
            return n;
        else
            return search(arr, n - 1, key);
    }
}