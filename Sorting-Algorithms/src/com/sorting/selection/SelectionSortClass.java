package com.sorting.selection;

/**
 * Created by kushagrathapar on 10/12/15.
 */
public class SelectionSortClass {

    public static void main(String[] args) {
        int array[] = new int[]{0,-1,2,3,4,10,-5,-6,-7,-8};
        selectionSort(array);
        for(int i : array) {
            System.out.println(i);
        }
    }

    public static void selectionSort(int[] elements) {
        if(elements == null || elements.length < 2) {
            return;
        }
        int minIndex = -1;
        for(int j = 0; j < elements.length - 1; j++) {
            int min = elements[j];
            for (int i = j+1; i < elements.length; i++) {
                if (elements[i] < min) {
                    min = elements[i];
                    minIndex = i;
                }
            }
            elements[minIndex] = elements[j];
            elements[j] = min;
        }
    }
}
