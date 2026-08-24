package com.com.leetcode.august;

public class StoneGameVIII {
    public static void main(String[] args) {
        int [] stones = {-1,2,-3,4,-5};
        int score = stoneGameVIII(stones);
        System.out.println(score);
    }
    public static int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] prefix = stones.clone();

        //calculate prefix sum
        for(int i=1;i<n;i++){
            prefix[i] +=prefix[i-1];
        }
        //if Alice takes all the stones
        //game ends
        int best = prefix[n-1];

        for(int i=n-2;i>=1;i--){
            best = Math.max(best, prefix[i]-best);
        }
        return best;
    }
}
