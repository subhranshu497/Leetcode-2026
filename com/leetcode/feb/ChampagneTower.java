package com.com.leetcode.feb;

import java.util.Arrays;

public class ChampagneTower {
    public static void main(String[] args) {
        int poured = 1, query_row = 1, query_glass = 1;
        double ans = champagneTower(poured, query_row, query_glass);
        System.out.println(ans);
    }

    private static double champagneTower(int poured, int queryRow, int queryGlass) {
        double [][] memo = new double[101][101];
        for(double[] arr:memo){
            Arrays.fill(arr, -1);
        }
        return Math.min(1.0, champangeTowerSolve(poured,queryRow,queryGlass, memo));
    }

    private static double champangeTowerSolve(int p,int i, int j, double[][] memo) {
        //base case
        if(i<0 || j<0 || i<j)return 0.0;
        if(i==0 && j==0) return p;
        if(memo[i][j] !=-1)return memo[i][j];
        double leftUp = (champangeTowerSolve(p, i-1,j-1, memo)-1)/2.0;
        double rightUp = (champangeTowerSolve(p, i-1,j, memo)-1)/2.0;

        if(leftUp <0) leftUp=0.0;
        if(rightUp<0) rightUp =0.0;

        return memo[i][j]= leftUp+rightUp;
    }
}
