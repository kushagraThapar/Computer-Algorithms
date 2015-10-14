package com.searching.binarysearch;

import com.sorting.merge.MergeSortClass;

/**
 * Created by kushagrathapar on 10/13/15.
 */
public class BinarySearchClass {

    public static void main(String[] args) {
        int array[] = new int[]{0,-1,2,3,4,10,-5,-6,-7,-8};
        int resultArray[] = MergeSortClass.mergeSort(array, 0, array.length - 1);
        System.out.println(binarySearch(resultArray, 0, resultArray.length - 1, 0));
    }

    public static boolean binarySearch(int[] elements, int start, int end, int searchElement) {
        if(start > end) {
            return false;
        }
        int mid = (start + end) / 2;
        if(searchElement < elements[mid]) {
            return binarySearch(elements, start, mid - 1, searchElement);
        } else if(searchElement > elements[mid]){
            return binarySearch(elements, mid + 1, end, searchElement);
        } else {
            return true;
        }
    }
}
