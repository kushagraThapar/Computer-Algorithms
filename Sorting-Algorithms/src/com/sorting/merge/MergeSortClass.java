package com.sorting.merge;

/**
 * Created by kushagrathapar on 10/12/15.
 */
public class MergeSortClass {

    public static void main(String[] args) {
        int array[] = new int[]{0, -1, 2, 3, 4, 10, -5, -6, -7, -8};
        int result[] = mergeSort(array, 0, array.length - 1);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] mergeSort(int elements[], int start, int end) {
        if (start == end) {
            return new int[]{elements[start]};
        }
        int mid = (start + end) / 2;
        int a[] = mergeSort(elements, start, mid);
        int b[] = mergeSort(elements, mid + 1, end);
        return mergeTwoArrays(a, b);
    }

    public static int[] mergeTwoArrays(int a[], int b[]) {
        int resultArray[] = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            resultArray[k++] = a[i] < b[j] ? a[i++] : b[j++];
        }
        while (i < a.length) {
            resultArray[k++] = a[i++];
        }

        while (j < b.length) {
            resultArray[k++] = b[j++];
        }

        return resultArray;
    }
}
