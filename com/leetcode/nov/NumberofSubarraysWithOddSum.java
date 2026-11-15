package com.com.leetcode.nov;

import java.util.ArrayList;
import java.util.List;

public class NumberofSubarraysWithOddSum {
    public static void main(String[] args) {
        int [] arr = {1,3,5};
        int res = numOfSubarrays(arr);
        System.out.println(res);
    }

    private static int numOfSubarrays(int[] arr) {
       long oddCount =0;
       long evenCount = 1; //because when sum =0
        long totalOdds =0;
        long sum =0;
        int MOD = 100_000_007;
        for(int num:arr){
            sum +=num;
            if(sum % 2 ==1){
                oddCount++;
                totalOdds =(totalOdds+evenCount)%MOD;
            }else {
                evenCount++;
                totalOdds =(totalOdds+oddCount)%MOD;
            }
        }
        return (int) totalOdds;
    }

}
