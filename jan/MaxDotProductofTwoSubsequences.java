package com.jan;

import java.util.Arrays;

public class MaxDotProductofTwoSubsequences {
    public static void main(String[] args) {
        int [] nums1 = {2,1,-2,5};
        int [] nums2 = {3,0,-6};
        int prod = maxDotProduct(nums1,nums2);
        System.out.println(prod);
    }

    private static int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int dp [][] = new int[501][501];
        for(int [] d:dp)
            Arrays.fill(d,-100000000);
        int prod = maxProdSolve(nums1, nums2, n,m,0,0, dp);
        return prod;
    }

    private static int maxProdSolve(int[] nums1, int[] nums2, int n, int m, int i, int j, int [][] dp) {
        //base case
        if(i>=n || j>=m){
            return -100000000;
        }
        if(dp[i][j] != -100000000)return dp[i][j];
        //take i and j
        int val = nums1[i]*nums2[j];
        //take i and j and further search
        int take_i_j = val+maxProdSolve(nums1,nums2,n,m,i+1,j+1, dp);
        int take_i = maxProdSolve(nums1,nums2,n,m,i+1,j,dp);
        int take_j = maxProdSolve(nums1,nums2,n,m,i,j+1,dp);

        return dp[i][j] = Math.max(val, Math.max(take_i_j, Math.max(take_i,take_j)));
    }
}
