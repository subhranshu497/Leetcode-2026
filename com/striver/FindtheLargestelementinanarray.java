package com.com.striver;

public class FindtheLargestelementinanarray {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};
        int res = largest(arr);
        System.out.println(res); // Output the result
    }

    private static int largest(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int a:arr)
            max = Math.max(max, a);
        return max;
    }
}
