package com.sorting.merge;

import java.util.Arrays;
import java.util.Random;

import static com.util.Utility.printSystemDetails;

public class DemoArraysParallelSort {

    private static final int SIZE = 2100000000;

    public static void main(String[] args) {
        printSystemDetails();
        int[] array = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt();
        }
        long startTime = System.currentTimeMillis();
        Arrays.parallelSort(array);
        printSystemDetails();
        long endTime = System.currentTimeMillis();
        long milliTime = endTime - startTime;
        System.out.println("Time taken to sort using Arrays.parallelSort : { " + (milliTime / 1000.0) + " } seconds");
    }
}
