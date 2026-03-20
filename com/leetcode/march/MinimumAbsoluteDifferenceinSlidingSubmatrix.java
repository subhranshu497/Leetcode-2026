package com.com.leetcode.march;

import java.net.Inet4Address;
import java.util.*;

public class MinimumAbsoluteDifferenceinSlidingSubmatrix {
    public static void main(String[] args) {
        int [][]grid = {{1,-2,3},{2,3,5}};
        int k =2;
        int [][] res = minAbsDiff(grid, k);
        for(int[] a:res){
            for(int i:a)
                System.out.print(i+", ");
            System.out.println();
        }
    }

    private static int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] ans = new int[m-k+1][n-k+1];
        for(int i=0;i<=m-k;i++){
            for(int j=0;j<=n-k;j++){
                List<Integer> subMat = new ArrayList<>();
                for(int x =i;x<i+k;x++){
                    for(int y=j;y<j+k;y++){
                        subMat.add(grid[x][y]);
                    }
                }
                Collections.sort(subMat);
                int min_diff = Integer.MAX_VALUE;
                for(int t=1;t<subMat.size();t++){
                    int a = subMat.get(t);
                    int b = subMat.get(t-1);
                    if(a != b)
                        min_diff = Math.min(min_diff, Math.abs(a-b));
                }
                ans[i][j] = (min_diff==Integer.MAX_VALUE)?0:min_diff;
            }

        }
        return ans;
    }
}
