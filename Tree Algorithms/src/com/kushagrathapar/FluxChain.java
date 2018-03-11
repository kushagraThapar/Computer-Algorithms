package com.kushagrathapar;

import com.util.PostorderTreeCreation;
import org.junit.Assert;

import java.util.Map;

/**
 * Created by kushagrathapar on 3/11/18 at 10:28 AM.
 */
public class FluxChain {

    public static void main(String[] args) {
        int[] inputArray;
        int[] expectedOutputArray;
        int[] outputArray;
        int height;

        //  TEST - 1
        height = 3;
        inputArray = new int[]{1, 4, 7};
        expectedOutputArray = new int[]{3, 6, -1};

        outputArray = answer(height, inputArray);
        Assert.assertArrayEquals(outputArray, expectedOutputArray);

        //  TEST - 2
        height = 3;
        inputArray = new int[]{7, 3, 5, 1};
        expectedOutputArray = new int[]{-1, 7, 6, 3};

        outputArray = answer(height, inputArray);
        Assert.assertArrayEquals(outputArray, expectedOutputArray);


        //  TEST - 3
        height = 5;
        inputArray = new int[]{19, 14, 28};
        expectedOutputArray = new int[]{21, 15, 29};

        outputArray = answer(height, inputArray);
        Assert.assertArrayEquals(outputArray, expectedOutputArray);

    }

    public static int[] answer(int h, int[] q) {
        Map<Integer, Integer> parentMappings = PostorderTreeCreation.mapParents(h);
        int[] results = new int[q.length];
        for(int i = 0; i < q.length; i++) {
            results[i] = parentMappings.get(q[i]);
        }
        return results;
    }
}
