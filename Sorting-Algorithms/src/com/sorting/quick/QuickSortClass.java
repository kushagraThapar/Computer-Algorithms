package com.sorting.quick;

/**
 * Created by kushagrathapar on 10/18/15.
 */
public class QuickSortClass {

    public static void main(String[] args) {
        int array[] = new int[]{-20, -1, 2, 3, 4, 10, -5, -6, -7, -8};
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
            int partitionedIndex = findPartitionUsingLomutoScheme(array, start, end);
            quickSort(array, start, partitionedIndex - 1);
            quickSort(array, partitionedIndex + 1, end);
        }
    }

    /**
     * This is the partition method implemented using Lomuto partition scheme
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int findPartitionUsingLomutoScheme(int array[], int start, int end) {
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

    /**
     * This is the partition method implemented using Hoare partition scheme
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int findPartitionUsingHoareScheme(int array[], int start, int end) {
        int partition = 0;

        return partition;
    }
}
