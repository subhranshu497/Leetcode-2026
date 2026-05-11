package com.com.leetcode.may;

import java.util.List;

public class SeparatetheDigitsinanArray {
    public static void main(String[] args) {
        int [] nums = {13,25,83,77};
        int [] result = separateDigits(nums);
        for(int num : result){
            System.out.print(num + " ");
        }
    }

    private static int[] separateDigits(int[] nums) {
        List<Integer> list = new java.util.ArrayList<>();
        for(int num : nums){
            String str = String.valueOf(num);
            for(char ch : str.toCharArray()){
                list.add(ch - '0'); //convert char to int
            }
        }
        //convert list to array using stream
       return list.stream().mapToInt(i -> i).toArray();

    }
}
