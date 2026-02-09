package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class FindtheHighestAltitude {
    public static void main(String[] args) {
        int [] gain = {-4,-3,-2,-1,4,3,2};
        int altitude = largestAltitude(gain);
        System.out.println(altitude);
    }

    private static int largestAltitude(int[] gain) {
        int n =gain.length;
        int [] totalGain = new int[n];
        totalGain[0] = gain[0];
        int maxGain = totalGain[0];
        for(int i=0;i<n-1;i++){
            totalGain[i+1]= totalGain[i]+gain[i+1];
            maxGain = Math.max(maxGain, totalGain[i+1]);
        }
        maxGain = Math.max(maxGain,0);
        return maxGain;
    }
}
