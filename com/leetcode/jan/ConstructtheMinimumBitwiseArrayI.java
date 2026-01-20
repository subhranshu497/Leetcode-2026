package com.com.leetcode.jan;

import java.util.Arrays;
import java.util.List;

public class ConstructtheMinimumBitwiseArrayI {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2,3,5,7);
        int [] res = minBitwiseArray(nums);
    }

    private static int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int [] res = new int[n];
        Arrays.fill(res, -1);
        int j=0;
        for(int i=0;i<n;i++){
            int num = nums.get(i);
            for(int x=0;x<num;x++){
                if((x | (x+1))==num){
                    res[j]=x;
                    break;
                }
            }
            j++;
        }
        return res;
    }
}
