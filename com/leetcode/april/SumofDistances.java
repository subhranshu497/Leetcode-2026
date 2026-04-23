package com.com.leetcode.april;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumofDistances {
    public static void main(String[] args) {
        int [] nums = {1, 3, 1, 1, 2};
        long [] res = distanceI(nums);
        for(long a: res){
            System.out.print(a + " ");
        }
    }

    private static long[] distanceI(int[] nums) {
        int n = nums.length;
        long [] res = new long[n];
        Map<Integer, Long> count = new HashMap<>();
        Map<Integer, Long> sum = new HashMap<>();
        //left to right
        for(int i=0;i<n;i++){
            int num = nums[i];
            long freq = count.getOrDefault(num, 0L);
            long sumSoFar = sum.getOrDefault(num, 0L);
            res[i] += freq * i - sumSoFar;
            count.put(num, freq + 1);
            sum.put(num, sumSoFar + i);
        }
        count.clear();
        sum.clear();
        //right to left
        for(int i=n-1;i>=0;i--){
            int num = nums[i];
            long freq = count.getOrDefault(num, 0L);
            long sumSoFar = sum.getOrDefault(num, 0L);
            res[i] += sumSoFar - freq * i;
            count.put(num, freq + 1);
            sum.put(num, sumSoFar + i);
        }
        return res;
    }
}
