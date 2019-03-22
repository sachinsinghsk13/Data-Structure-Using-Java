package sorting;

public class QuickSort {
    public static void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void quicksort(int[] arr, int beg, int end) {
        if (beg < end) {
            int p = partition(arr, beg, end);
            quicksort(arr, beg, p - 1);
            quicksort(arr, p + 1, end);
        }
    }

    private static int partition(int[] arr, int beg, int end) {
        int left = beg, loc = beg, right = end;
        boolean flag = false;
        while (!flag) {
            while ((arr[loc] <= arr[right]) && (right != loc))
                right--;
            if (right == loc)
                flag = true;
            else if (arr[loc] > arr[right]) {
                swap(arr, loc, right);
                loc = right;
            }

            if (!flag) {
                while ((arr[loc] >= arr[left]) && (left != loc))
                    left++;
                if (left == loc)
                    flag = true;
                else if (arr[loc] < arr[left]) {
                    swap(arr, left, loc);
                    loc = left;
                }
            }
        }
        return loc;
    }
}