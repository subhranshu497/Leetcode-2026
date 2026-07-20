package com.com.leetcode.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shift2DGrid {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;
        List<List<Integer>> res = shiftGrid(grid, k);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(0).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    //using extra space
    private static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        int K = k % total; // for normalization
        int [] tempArr = new int[total];
        //run the loop to fill the tempArr
        int idx = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                tempArr[idx++] = grid[i][j];
            }
        }
        //reverse the array three times
        reverseII(tempArr, 0, total-1);
        reverseII(tempArr, 0, K-1);
        reverseII(tempArr, K, total-1);
        //fill the grid with the tempArr
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<m;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(tempArr[i*n+j]);
            }
            result.add(row);
        }
        return result;
    }

    private static void reverseII(int[] tempArr, int i, int j) {
        while(i<j) {
            int temp = tempArr[i];
            tempArr[i] = tempArr[j];
            tempArr[j] = temp;
            i++;
            j--;
        }
    }
}
