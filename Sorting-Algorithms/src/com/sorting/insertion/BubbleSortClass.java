package com.sorting.insertion;

/**
 * Created by kushagrathapar on 10/13/15.
 */
public class BubbleSortClass {
    public static void main(String[] args) {
        int array[] = new int[]{0,-1,2,3,4,10,-5,-6,-7,-8};
        bubbleSort(array);
        for(int i : array) {
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] elements) {
        if(elements == null || elements.length < 2) {
            return;
        }
        for(int i = 0; i < elements.length - 1; i++) {
            for(int j = 0; j < elements.length - 1 - i; j++) {
                if(elements[j] > elements[j+1]) {
                    int temp = elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = temp;
                }
            }
        }
    }
}
