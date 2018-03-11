package com.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by kushagrathapar on 3/10/18 at 5:13 PM.
 */
public class PostorderTreeCreation {

    public static void main(String[] args) {
        Map<Integer, Integer> parentMappings = mapParents(2);
        System.out.println("Mappings for tree of height 2");
        printMappings(parentMappings);
        parentMappings = mapParents(3);
        System.out.println("Mappings for tree of height 3");
        printMappings(parentMappings);
        System.out.println("");
        System.out.println("Mappings for tree of height 4");
        parentMappings = mapParents(4);
        printMappings(parentMappings);
        System.out.println("");
        System.out.println("Mappings for tree of height 5");
        parentMappings = mapParents(5);
        printMappings(parentMappings);
    }

    private static void printMappings(Map<Integer, Integer> parentMappings) {
        for(Map.Entry<Integer, Integer> mapping: parentMappings.entrySet()) {
            System.out.println(mapping.getKey() + " -> " + mapping.getValue());
        }
    }

    public static Map<Integer, Integer> mapParents(int height) {

        Map<Integer, Integer> parentMappings = new HashMap<>();
        Stack<Integer> currentStack = new Stack<>();
        Map<Integer, Integer> leftRightMappings = new HashMap<>();

        //  Start from reverse of the post-order list of the original perfect binary tree
        int i = (int) (Math.pow(2, height) - 1);
        int rightChild, leftChild, parent;
        while(i > 0) {
            while(currentStack.size() != height && i > 1) {
                currentStack.push(i);
                i--;
            }
            rightChild = currentStack.pop();
            leftChild = i;
            parent = currentStack.pop();
            parentMappings.put(leftChild, parent);
            parentMappings.put(rightChild, parent);
            if (currentStack.size() == 0) {
                parentMappings.put(parent, -1);
                return parentMappings;
            } else {
                int lastParent = currentStack.peek();
                parentMappings.put(parent, lastParent);
                leftRightMappings.put(lastParent, leftRightMappings.getOrDefault(lastParent, 0) + 1);
                while(leftRightMappings.get(lastParent) == 2) {
                    if (currentStack.size() > 1) {
                        parent = currentStack.pop();
                        lastParent = currentStack.peek();
                        parentMappings.put(parent, lastParent);
                        leftRightMappings.put(lastParent, leftRightMappings.getOrDefault(lastParent, 0) + 1);
                    } else {
                        parentMappings.put(currentStack.pop(), -1);
                        return parentMappings;
                    }
                }
                i--;
            }
        }
        if (currentStack.size() > 0) {
            parentMappings.put(currentStack.pop(), -1);
        }
        return parentMappings;
    }
}
