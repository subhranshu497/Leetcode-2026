package com.com.leetcode.march;

import java.util.ArrayList;
import java.util.List;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public static void main(String[] args) {
        String n = "82734";
        int res = minPartitions(n);
        System.out.println(res);
    }

    private static int minPartitions(String n) {
        int minCount =0;
        for(int i=0;i<n.length();i++){
            int digit = Character.getNumericValue(n.charAt(i));
            minCount = Math.max(minCount, digit);
        }
        return minCount;
    }

}
