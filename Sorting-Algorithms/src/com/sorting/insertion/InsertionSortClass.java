package com.sorting.insertion;

/**
 * Created by kushagrathapar on 10/12/15.
 */
public class InsertionSortClass {
    public static void main(String[] args) {
        int array[] = new int[]{0,-1,2,3,4,10,-5,-6,-7,-8};
        insertionSort(array);
        for(int i : array) {
            System.out.println(i);
        }
    }

    public static void insertionSort(int[] elements) {
        if(elements == null || elements.length < 2) {
            return;
        }
        int j;
        for(int i = 1; i < elements.length; i++) {
            j = i;
            while(j > 0 && elements[j] < elements[j-1]) {
                int element = elements[j];
                elements[j] = elements[j-1];
                elements[j-1] = element;
                j--;
            }
        }
    }
}
