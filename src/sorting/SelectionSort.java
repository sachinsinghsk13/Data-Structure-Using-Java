package sorting;

public class SelectionSort {
    public static void sort(int[] array) {
        /*Iterate Through complete array*/
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            /* Find index of minimun value*/
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            /* Swap value between current and min value index */
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}