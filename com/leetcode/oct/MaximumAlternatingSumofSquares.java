package com.com.leetcode.oct;

import java.util.Arrays;

public class MaximumAlternatingSumofSquares {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long [] absNums = new long [n];
        for(int i=0;i<n;i++){
            absNums[i] = Math.abs(nums[i]);
        }
        //long [] desc = new long [n];
        absNums = Arrays.stream(absNums)
                .boxed()
                .sorted((a, b) -> Long.compare(b, a))
                .mapToLong(Long::longValue)
                .toArray();

        long res = 0;
        int i=0, j=n-1;
        while(i<=j){
            long sq1 = absNums[i]*absNums[i];
            if(i==j){
                res +=sq1;
            }
            else {
                long sq2 = absNums[j]*absNums[j];
                res +=sq1-sq2;
            }
            i++;
            j--;
        }
        return res;
    }
}
