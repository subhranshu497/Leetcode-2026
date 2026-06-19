package com.com.leetcode.june;

public class FindtheHighestAltitude {
    public static void main(String[] args) {
        int [] gain = {-5,1,5,0,-7};
        int res = largestAltitudeI(gain);
        System.out.println(res);
    }

    private static int largestAltitudeI(int[] gain) {
        int res = Integer.MIN_VALUE;
        int sum =0;
        for(int alt:gain){
            sum +=alt;
            res=Math.max(sum,res);
        }
        return res<0?0:res;
    }
}
