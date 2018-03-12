package com.kushagrathapar;

import com.util.PostorderTreeCreation;

import java.util.Map;

/**
 * Created by kushagrathapar on 3/11/18 at 10:28 AM.
 */
public class FluxChain {

    public static void main(String[] args) {
        int[] inputArray;
        int[] outputArray;
        int height;

        //  Input - 1
        height = 3;
        inputArray = new int[]{1, 4, 7};
        outputArray = answer(height, inputArray);
        printArray(outputArray);

        //  Input - 2
        height = 3;
        inputArray = new int[]{7, 3, 5, 1};
        outputArray = answer(height, inputArray);
        printArray(outputArray);

        //  Input - 3
        height = 5;
        inputArray = new int[]{19, 14, 28};
        outputArray = answer(height, inputArray);
        printArray(outputArray);
    }

    public static int[] answer(int h, int[] q) {
        Map<Integer, Integer> parentMappings = PostorderTreeCreation.mapParents(h);
        int[] results = new int[q.length];
        for(int i = 0; i < q.length; i++) {
            results[i] = parentMappings.get(q[i]);
        }
        return results;
    }

    private static void printArray(int[] array) {
        for(int i : array) {
            System.out.println(i);
        }
    }
}
