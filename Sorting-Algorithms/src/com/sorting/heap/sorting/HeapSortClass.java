package com.sorting.heap.sorting;

import com.sorting.heap.operations.HeapOperationsClass;

/**
 * Created by kushagrathapar on 10/18/15.
 */
public class HeapSortClass {

    public static void main(String[] args) {
        int[] array = new int[]{-1,4,1,3,2,16,9,10,14,8,7};
        System.out.println("... Initially ...");
        HeapOperationsClass.printHeap(array);
        System.out.println("... Heap Sort ...");
        heapSort(array);
        HeapOperationsClass.printHeap(array);
    }

    public static void heapSort(int[] array) {
        int heapSize = array.length;
        HeapOperationsClass.buildMaxHeap(array);
        for(int i = array.length - 1; i > 1; i--) {
            int temp = array[1];
            array[1] = array[i];
            array[i] = temp;
            heapSize--;
            HeapOperationsClass.maxHeapify(array, 1, heapSize);
        }
    }
}
