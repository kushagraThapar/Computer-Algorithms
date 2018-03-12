package test;

import org.junit.Assert;
import org.junit.Test;

import static com.kushagrathapar.FluxChain.answer;

/**
 * Created by kushagrathapar on 3/12/18 at 11:02 AM.
 */
public class FluxChainUnitTests {

    @Test
    public void fluxChainTest3() {
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
    }

    @Test(expected = AssertionError.class)
    public void fluxChainTest3Fail() {
        int[] inputArray;
        int[] expectedOutputArray;
        int[] outputArray;
        int height;

        //  TEST - 1
        height = 3;
        inputArray = new int[]{1, 4, 7};
        expectedOutputArray = new int[]{4, 1, 2};

        outputArray = answer(height, inputArray);
        Assert.assertArrayEquals(outputArray, expectedOutputArray);
    }

    @Test
    public void fluxChainTest4() {
        int[] inputArray;
        int[] expectedOutputArray;
        int[] outputArray;
        int height;

        //  TEST - 1
        height = 4;
        inputArray = new int[]{14, 4, 7, 15, 12};
        expectedOutputArray = new int[]{15, 6, 15, -1, 13};

        outputArray = answer(height, inputArray);
        Assert.assertArrayEquals(outputArray, expectedOutputArray);
    }

    @Test
    public void fluxChainTest5() {
        int height = 5;
        int[] inputArray = new int[]{19, 14, 28};
        int[] expectedOutputArray = new int[]{21, 15, 29};

        int[] outputArray = answer(height, inputArray);
        Assert.assertArrayEquals(outputArray, expectedOutputArray);
    }
}
