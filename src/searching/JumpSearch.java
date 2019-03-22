package searching;

public class JumpSearch {

    public static int jumpSearch(int arr[], int key) {
        int step = (int) Math.round(Math.sqrt(arr.length));
        int low = 0;
        int high = arr.length - 1;
        for (int i = 0; i < step; i++) {
            if (key < arr[step])
                low = step - 1;
            else
                high = step + 1;
        }
        for (int i = low; i <= high; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

}