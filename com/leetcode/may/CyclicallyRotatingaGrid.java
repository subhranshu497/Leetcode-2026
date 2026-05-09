package com.com.leetcode.may;

import java.util.ArrayList;
import java.util.List;

public class CyclicallyRotatingaGrid {
    public static void main(String[] args) {
        int [][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int k = 2;
        int [][] rotatedGrid = rotateGrid(grid, k);
        for (int i = 0; i < rotatedGrid.length; i++) {
            for (int j = 0; j < rotatedGrid[0].length; j++) {
                System.out.print(rotatedGrid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        //step -1 : find the number of layers in the grid
        int layers = Math.min(m/2, n/2);
        //step -2 : for each layer, extract the elements in a list and rotate it
        for(int layer=0;layer<layers;layer++){
            List<Integer> list= new ArrayList<>();
            //find top, bottom, left and right pointer
            int top = layer;
            int bottom = m - layer - 1;
            int left = layer;
            int right = n - layer - 1;
            //extract the elements in the current layer and add to the list
            //top row left to rigth
            for(int j=left;j<=right;j++){
                list.add(grid[top][j]);
            }
            //right column top to bottom
            for(int i=top+1;i<=bottom;i++){
                list.add(grid[i][right]);
            }
            //bottom row right to left
            for(int j=right-1;j>=left;j--){
                list.add(grid[bottom][j]);
            }
            //left column bottom to top
            for(int i=bottom-1;i>top;i--){
                list.add(grid[i][left]);
            }
            //step -3 : rotate the list by k positions
            int size = list.size();
            int K = k % size;
            List<Integer> rotatedList = new ArrayList<>();
            //rotate counter clocwise
            for(int i=K;i<size;i++){
                rotatedList.add(list.get(i));
            }
            for(int i=0;i<K;i++){
                rotatedList.add(list.get(i));
            }
            //step -4 : copy the rotated list back to the grid
            int index = 0;
            //top row left to rigth
            for(int j=left;j<=right;j++){
                grid[top][j] = rotatedList.get(index++);
            }
            //right column top to bottom
            for(int i=top+1;i<=bottom;i++){
                grid[i][right] = rotatedList.get(index++);
            }
            //bottom row right to left
            for(int j=right-1;j>=left;j--){
                grid[bottom][j] = rotatedList.get(index++);
            }
            //left column bottom to top
            for(int i=bottom-1;i>top;i--){
                grid[i][left] = rotatedList.get(index++);
            }
        }
        return grid;
    }
}
