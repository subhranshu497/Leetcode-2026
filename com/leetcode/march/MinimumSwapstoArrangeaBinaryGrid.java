package com.com.leetcode.march;

public class MinimumSwapstoArrangeaBinaryGrid {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1},{1,1,0},{1,0,0}};
        int res = minSwaps(grid);
        System.out.println(res);
    }

    private static int minSwaps(int[][] grid) {
    int n = grid.length;
    int[] trailingZeros = new int[n];
    for(int i=0;i<n;i++){
        int count =0;
        for(int j=n-1;j>=0;j--){
            if(grid[i][j] == 0){
                count++;
            }else break;
        }
        trailingZeros[i] = count;
    }
    int swaps =0;
    for(int i=0;i<n;i++){
        int reqZeros = n-1-i;
        if(trailingZeros[i] >= reqZeros) continue;
        int j = i+1;
        while(j<n && trailingZeros[j] < reqZeros){
            j++;
        }
        if(j == n) return -1;
        while(j>i){
            int temp = trailingZeros[j];
            trailingZeros[j] = trailingZeros[j-1];
            trailingZeros[j-1] = temp;
            j--;
            swaps++;
        }
    }
    return swaps;
    }
}
