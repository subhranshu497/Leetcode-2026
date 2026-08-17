package com.com.leetcode.august;

import java.util.Arrays;

public class StoneGameV {
    public static void main(String[] args) {
        int [] stoneValue = {6,2,3,4,5,5};
        int res = stoneGameV(stoneValue);
        System.out.println(res);
    }

    private static int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int prefixSum [] = new int[n];
        prefixSum[0] = stoneValue[0];
        int [][] memo = new int[n+1][n+1];
        for(int [] me:memo){
            Arrays.fill(me,-1);
        }
        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1]+stoneValue[i];
        }
        return stoneGameVRecursion(stoneValue, prefixSum, n,0,n-1, memo);
    }

    private static int stoneGameVRecursion(int[] stoneValue, int[] prefixSum, int n, int l, int r, int [][] memo) {
        //base case
        if(l>=r)return 0;
        if(memo[l][r] !=-1)return memo[l][r];
        int score =0;
        for(int mid=l;mid<r;mid++){
            //calculate left sum
            int leftSum = prefixSum[mid]-(l>0?prefixSum[l-1]:0);
            int rightSum = prefixSum[r]-prefixSum[mid];
            //eliminate left
            if(leftSum > rightSum){
                score = Math.max(score, rightSum+stoneGameVRecursion(stoneValue,prefixSum,n,mid+1,r,memo));
            }else if(rightSum > leftSum){//eliminate right
                score = Math.max(score, leftSum+stoneGameVRecursion(stoneValue,prefixSum,n,l,mid,memo));
            }else{
                //in this case , we need to evaluate both
                score = Math.max(score,Math.max(rightSum+stoneGameVRecursion(stoneValue,prefixSum,n,mid+1,r,memo),
                        leftSum+stoneGameVRecursion(stoneValue,prefixSum,n,l,mid,memo)));
            }
        }
        return memo[l][r]= score;
    }
}
