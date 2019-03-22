package sorting;

public class InsertionSort {
    public static void sort(int[] array) {
        // Iterate through complete array
        for (int i = 1; i < array.length; i++) {
            int j = i;
            // pick up current item and place it to its proper sorted position
            while (j != 0 && array[j] < array[j - 1]) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }
    }
}