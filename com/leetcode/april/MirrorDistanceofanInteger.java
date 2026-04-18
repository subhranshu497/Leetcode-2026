package com.com.leetcode.april;

public class MirrorDistanceofanInteger {
    public static void main(String[] args) {
        int x= 25;
        int res = mirrorDistance(x);
        System.out.println(res); // Output the result
    }

    private static int mirrorDistance(int x) {
        int num = x;
        int rev_x = 0;
        while(x>0){
            rev_x = 10*rev_x + x%10;
            x/=10;
        }
        return Math.abs(rev_x - num);
    }
}
