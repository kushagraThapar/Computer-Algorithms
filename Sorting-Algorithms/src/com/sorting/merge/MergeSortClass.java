package com.sorting.merge;

import java.util.Random;

import static com.util.Utility.printSystemDetails;

/**
 * Created by kushagrathapar on 10/12/15.
 */
public class MergeSortClass {

    private static final int SIZE = 2100000000;

    public static void main(String[] args) {
        printSystemDetails();
        int[] array = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt();
        }
        long startTime = System.currentTimeMillis();
        mergeSort(array, 0, array.length - 1);
        printSystemDetails();
        long endTime = System.currentTimeMillis();
        long milliTime = endTime - startTime;
        System.out.println("Time taken to merge sort sequentially : { " + (milliTime / 1000.0) + " } seconds");
        System.out.println("Testing merge sort correctness");
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                System.out.println("ERROR");
                System.exit(1);
            }
        }
    }

    public static void mergeSort(int[] elements, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(elements, start, mid);
        mergeSort(elements, mid + 1, end);
        mergeTwoArrays(elements, start, mid, mid + 1, end);
    }

    public static void mergeTwoArrays(int[] elements, int start1, int end1, int start2, int end2) {
        int i = start1, j = start2, k = start1;
        while (i <= end1 && j <= end2) {
            if (elements[i] < elements[j]) {
                elements[k++] = elements[i++];
            } else {
                elements[k++] = elements[j++];
            }
        }
        while (i <= end1) {
            elements[k++] = elements[i++];
        }

        while (j <= end2) {
            elements[k++] = elements[j++];
        }
    }
}
