package com.com.striver;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindSecondSmallestandSecondLargestElementinanarray {
    public static void main(String[] args) {
        int [] arr = {1, 2, 4, 7, 7, 5};
        int [] res = findI(arr);
        System.out.println("Second Smallest: " + res[0] + ", Second Largest: " + res[1]); // Output the result

    }

    private static int[] findI(int[] arr) {
        int [] res = new int[2];
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int a:arr){
            if(a < firstSmallest){
                secondSmallest = firstSmallest;
                firstSmallest = a;
            } else if(a < secondSmallest && a != firstSmallest){
                secondSmallest = a;
            }
            if(a > firstLargest){
                secondLargest = firstLargest;
                firstLargest = a;
            } else if(a > secondLargest && a != firstLargest){
                secondLargest = a;
            }
        }
        res [0] = (secondSmallest == Integer.MAX_VALUE) ? -1 : secondSmallest;
        res [1] = (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
        return res;
    }
}
