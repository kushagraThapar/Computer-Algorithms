package com.sorting.heap.operations;

/**
 * Created by kushagrathapar on 10/18/15.
 */
public class HeapOperationsClass {


    public static void main(String[] args) {
        int[] array = new int[]{-1, 27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
        System.out.println("...Initially...");
        printHeap(array);
        maxHeapify(array, 3, array.length);
        System.out.println("...Max Heapify...");
        printHeap(array);
        buildMaxHeap(array);
        System.out.println("...Build Max Heap...");
        printHeap(array);

        System.out.println("Now this is a new array");
        array = new int[]{-1,4,1,3,2,16,9,10,14,8,7};
        System.out.println("... Initially ...");
        printHeap(array);
        System.out.println("... Build Max Heap ...");
        buildMaxHeap(array);
        printHeap(array);
    }

    public static void maxHeapify(int[] array, int i, int heapSize) {
        int left = getLeft(i);
        int right = getRight(i);
        int largest;
        if (left < heapSize && array[left] > array[i]) {
            largest = left;
        } else {
            largest = i;
        }
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeapify(array, largest, heapSize);
        }
    }

    public static int getLeft(int i) {
        return 2 * i;
    }

    public static int getRight(int i) {
        return (2 * i) + 1;
    }

    public static void printHeap(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void buildMaxHeap(int[] array) {
        for (int i = array.length / 2; i > 0; i--) {
            maxHeapify(array, i, array.length);
        }
    }
}
