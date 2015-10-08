package com.recursion.implementation;

/**
 * Created by kushagrathapar on 10/7/15.
 */
public class RodCuttingProblemUsingRecursion {

    public static int revenue = 0;

    public static int findMaxRevenue(int prices[], int length) {
        if(length == 0) {
            return 0;
        }
        revenue = -1;
        for(int i = 1; i <= length; i++) {
            revenue = Integer.max(revenue, prices[i] + findMaxRevenue(prices, length - i));
        }
        return revenue;
    }

}
