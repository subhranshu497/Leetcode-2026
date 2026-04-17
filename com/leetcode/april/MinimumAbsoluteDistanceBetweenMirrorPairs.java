package com.com.leetcode.april;

import java.util.HashMap;
import java.util.Map;

public class MinimumAbsoluteDistanceBetweenMirrorPairs {
    public static void main(String[] args) {
        int [] nums = {21,120};
        int result = minAbsoluteDistance(nums);
        System.out.println(result); // Output the result
    }

    private static int minAbsoluteDistance(int[] nums) {
        Map<Integer, Integer> reversedSeen = new HashMap<>();
        int n = nums.length;
        int minDist = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            int current = nums[j];
            if (reversedSeen.containsKey(current)) {
                int i = reversedSeen.get(current);
                minDist = Math.min(minDist, j - i);
            }
            int rev = reverseI(current);
            reversedSeen.put(rev, j);
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private static int removeTrailingZeros(int num) {
        while(num%10==0)
            num/=10;
        return num;
    }

    private static int reverseI(int num) {
        String str = String.valueOf(num);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)!='0')
                return Integer.parseInt(sb.substring(i));
            else{
                sb.deleteCharAt(i);
                i--;
            }
        }
        return 0;
    }
}
