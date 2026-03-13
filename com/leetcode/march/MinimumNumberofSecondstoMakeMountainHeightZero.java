package com.com.leetcode.march;

public class MinimumNumberofSecondstoMakeMountainHeightZero {
    public static void main(String[] args) {
        int [] workerTimes = {3,2,2,4};
        int mountainHeight =10;
        long res = minNumberOfSeconds(workerTimes, mountainHeight);
        System.out.println(res);
    }

    private static long minNumberOfSeconds(int[] workerTimes, int mountainHeight) {
        long l =0;
        long h = (long) 1e16;
        long ans = h;
        while(l<=h){
            long mid = l+(h-l)/2;
            if(canFinish(mid,mountainHeight,workerTimes)){
                ans = mid;
                h = mid-1;
            }else
                l =mid+1;
        }
        return ans;
    }

    /**
     * calculation of the formula
     * workerTime[i] = t
     * t*1+t*2+t*3....+t*h
     * t(h*(h+1)/2) <= mid
     * h^2 +h <=(2*mid)/t
     * add (1/2)^2 both side of the equation
     * h^2 + h +(1/2)^2 <=(2*mid)/t + (1/2)^2
     * (h+0.5)^2 <=(2*mid)/t + 0.25
     * h <= Math.sqrt ((2*mid)/t + 0.25) -0.5
     */
    private static boolean canFinish(long mid, int mountainHeight, int[] workerTimes) {
        int n = workerTimes.length;
        float h =0;
        for(int t:workerTimes){
            h += Math.sqrt(((2*mid)/t)+0.25)-0.5;
            if(h >=mountainHeight)return true;
        }
        return false;

    }
}
