package com.com.leetcode.july;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumProductofTwoDigits {
    public static void main(String[] args) {
        int n = 29;
        int res = maxProductI(n);
        System.out.println(res);
    }

    private static int maxProductI(int n) {
        String str = String.valueOf(n);
        char [] arr = str.toCharArray();
        Arrays.sort(arr);
        return (arr[arr.length-1]-'0')*(arr[arr.length-2]-'0');
    }
}
