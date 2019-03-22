package sorting;

public class MergeSort {
    public static void sort(int[] array, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;
            sort(array, l, mid);
            sort(array, mid + 1, h);
            merge(array, l, mid, h);
        }
    }

    private static void merge(int[] array, int l, int m, int h) {
        int sizeL = m - l + 1;
        int sizeR = h - m;

        int[] arrayL = new int[sizeL];
        int[] arrayR = new int[sizeR];

        for (int i = 0; i < sizeL; i++)
            arrayL[i] = array[l + i];


        for (int i = 0; i < sizeR; i++)
            arrayR[i] = array[m + i + 1];

        int i = 0, j = 0, k = l;

        while (i < sizeL && j < sizeR) {
            if (arrayL[i] < arrayR[j])
                array[k++] = arrayL[i++];
            else
                array[k++] = arrayR[j++];
        }

        while (i < sizeL) {
            array[k++] = arrayL[i++];
        }

        while (j < sizeR) {
            array[k++] = arrayR[j++];
        }
    }
}