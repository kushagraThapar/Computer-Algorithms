package com.recursion.execution;

import com.recursion.implementation.RodCuttingProblemUsingRecursion;

/**
 * Created by kushagrathapar on 10/7/15.
 */
public class RodCuttingExecutionUsingRecursion {
    public static void main(String[] args) {
        int length = 10;
        int prices[] = new int[]{0,1,3,8,9,10,17,17,20,24,30,32,34,35,35,38,40,44,49,50,51,51,56,80,82,85,90};
        int revenue = RodCuttingProblemUsingRecursion.findMaxRevenue(prices, length);
        System.out.println("Maximum Revenue is -> [" + revenue + "]");
    }
}
