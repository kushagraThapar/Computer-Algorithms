package com.sorting.quick;

/**
 * Created by kushagrathapar on 10/18/15.
 */
public class QuickSortClass {

    public static void main(String[] args) {
        int array[] = new int[]{0, -1, 2, 3, 4, 10, -5, -6, -7, -8};
        System.out.println("... Initially ...");
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println("... Finally ...");
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int partitionedIndex = findPartition(array, start, end);
            quickSort(array, start, partitionedIndex - 1);
            quickSort(array, partitionedIndex + 1, end);
        }
    }

    public static int findPartition(int array[], int start, int end) {
        int i = start - 1, temp;
        int element = array[end];
        for (int j = start; j < end; j++) {
            if ((array[j] <= element)) {
                temp = array[j];
                i++;
                array[j] = array[i];
                array[i] = temp;
            }
        }
        i++;
        array[end] = array[i];
        array[i] = element;
        return i;
    }
}
