package com.sorting.merge;

import com.util.Utility;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import static com.util.Utility.printSystemDetails;

public class CopiedMultithreadingMergeSort extends RecursiveAction {

    private static final int SIZE = 2100000000;
    private static final ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
    private static final int SEQUENTIAL_THRESHOLD = 100000;

    private final int[] numbers;
    private final int startPos, endPos;
    private final int[] result;

    public static void main(String[] args) {
        Utility.printSystemDetails();
        int[] array = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt();
        }
        long startTime = System.currentTimeMillis();
        forkJoinPool.invoke(new CopiedMultithreadingMergeSort(array, 0, array.length - 1));
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

    public CopiedMultithreadingMergeSort(int[] numbers, int startPos, int endPos) {
        this.numbers = numbers;
        this.startPos = startPos;
        this.endPos = endPos;
        this.result = new int[numbers.length];
    }

    private void merge(CopiedMultithreadingMergeSort left, CopiedMultithreadingMergeSort right) {
        int i = 0, leftPos = 0, rightPos = 0, leftSize = left.size(), rightSize = right.size();
        while (leftPos < leftSize && rightPos < rightSize)
            result[i++] = (left.result[leftPos] <= right.result[rightPos])
                    ? left.result[leftPos++]
                    : right.result[rightPos++];
        while (leftPos < leftSize)
            result[i++] = left.result[leftPos++];
        while (rightPos < rightSize)
            result[i++] = right.result[rightPos++];
    }

    public int size() {
        return endPos - startPos;
    }

    protected void compute() {
        if (size() < SEQUENTIAL_THRESHOLD) {
            System.arraycopy(numbers, startPos, result, 0, size());
            Arrays.sort(result, 0, size());
        } else {
            int midpoint = size() / 2;
            CopiedMultithreadingMergeSort left = new CopiedMultithreadingMergeSort(numbers, startPos, startPos + midpoint);
            CopiedMultithreadingMergeSort right = new CopiedMultithreadingMergeSort(numbers, startPos + midpoint, endPos);
            invokeAll(left, right);
            merge(left, right);
        }
    }
}
