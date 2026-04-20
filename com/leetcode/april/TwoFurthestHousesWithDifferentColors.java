package com.com.leetcode.april;

public class TwoFurthestHousesWithDifferentColors {
    public static void main(String[] args) {
        int [] colors = {4,4,4,11,4,4,11,4,4,4,4,4};
        int res = maxDistanceI(colors);
        System.out.println(res); // Output the result
    }

    private static int maxDistanceI(int[] colors) {
        int n = colors.length;
        int maxDist =0;
        int i = 0;
        int j = n-1;
        while (i<j){
            if(colors[i] != colors[j]){
                maxDist = Math.max(maxDist, j-i);
                break;
            }
            else j--;
        }
        j = n-1;
        while (i<j){
            if(colors[i] != colors[j]){
                maxDist = Math.max(maxDist, j-i);
                break;
            }
            else{
                i++;
            }
        }
        return maxDist;
    }
}
