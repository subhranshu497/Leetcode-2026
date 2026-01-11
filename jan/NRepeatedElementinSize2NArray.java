package com.jan;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementinSize2NArray {
    public static void main(String[] args) {
        int [] nums = {1,2,3,3};
        int res = repeatedNTimes(nums);
        System.out.println(res);
    }

    private static int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            if(!set.contains(num))set.add(num);
            else return num;
        }
        return 0;
    }
}
