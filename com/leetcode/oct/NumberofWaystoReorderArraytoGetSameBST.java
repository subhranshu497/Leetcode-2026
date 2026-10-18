package com.com.leetcode.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class NumberofWaystoReorderArraytoGetSameBST {
    private static long MOD =1000000007;
    private static long[][] PT;
    public static void main(String[] args) {
        int [] nums = {2,1,3};
        int ways = numOfWaysI(nums);
        System.out.println(ways);
    }

    private static int numOfWaysI(int[] nums) {
        int n = nums.length;
        PT = new long[n+1][n+1];
        //fill pascal triangle
        for(long []p:PT){
            Arrays.fill(p,1);
        }
        //start populating Pascal's triangle
        for(int i=0;i<=n;i++){
            for(int j=1;j<i;j++){
                PT[i][j] = (PT[i-1][j]+PT[i-1][j-1])%MOD;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }
        return (int)((solveNumberOfWaysI(list)-1)% MOD);
    }

    private static long solveNumberOfWaysI(List<Integer> nums) {
        int n = nums.size();
        //base case
        if(n<3)return 1;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int root = nums.get(0);
        for(int i=1;i<n;i++){
            if(nums.get(i)<root){
                left.add(nums.get(i));
            }else right.add(nums.get(i));
        }
        long x = solveNumberOfWaysI(left);
        long y = solveNumberOfWaysI(right);
        long z = PT[n-1][left.size()];
        long res = ((x*y)%MOD*z)%MOD;
        return res;
    }
}
