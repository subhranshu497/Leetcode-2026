package com.com.leetcode.march;

import java.util.TreeSet;

public class GetBiggestThreeRhombusSumsinaGrid {
    public static void main(String[] args) {
        int [][] grid = {{3,4,5,1,3},{3,3,4,2,3},{20,30,200,40,10},{1,5,5,4,1},{4,3,2,2,5}};
        int [] res = getBiggestThree(grid);
        for(int r: res)
            System.out.print(r+", ");
    }

    private static int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> set = new TreeSet();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //each cell is a valid rhombus of side 0
                set.add(grid[i][j]);
                if(set.size()>3)set.removeFirst();
                for (int side = 1; i-side >= 0 && i+side < m && j-side >= 0 && j+side < n; side++) {
                    int sum = 0;
                    for (int k = 0; k < side; k++) {
                        sum += grid[i - side + k][j + k];   // top to right corner
                        sum += grid[i + k][j + side - k];   // right to bottom corner
                        sum += grid[i + side - k][j - k];   // bottom to left corner
                        sum += grid[i - k][j - side + k];   // left to top corner
                    }

                    set.add(sum);
                    if(set.size()>3)set.removeFirst();
                }
            }
        }
        int [] res = new int[set.size()];
        int idx =set.size()-1;
        for(int item:set){
            res[idx--]=item;
        }
        return res;
    }
}
