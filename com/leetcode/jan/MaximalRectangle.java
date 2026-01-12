package com.com.leetcode.jan;

import java.util.Arrays;

public class MaximalRectangle {
    private static int [][] directions ={{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        char [][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int area = maximalRectangle(matrix);
        System.out.println(area);
    }

    private static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
         int maxArea =0;
         int [] height = new int[n];
         int [] right = new int[n];
         int [] left = new int[n];
        Arrays.fill(right, n);
         for(int i=0;i<m;i++){
             int curr_left =0, curr_right = n;
             //update height
             for(int j=0;j<n;j++){
                 if(matrix[i][j] == '1')height[j]++;
                 else height[j]=0;
             }
             //update right
             for(int j=n-1;j>=0;j--) {
                 if (matrix[i][j] == '1') {
                     right[j] = Math.min(right[j], curr_right);
                 } else {
                     right[j] = n;
                     curr_right = j;
                 }
             }
             //update left
             for(int j=0;j<n;j++){
                 if(matrix[i][j] == '1'){
                     left[j] = Math.max(left[j], curr_left);
                 }
                 else{
                     left[j] = 0;
                     curr_left = j+1;
                 }
             }
             //update area
             for(int j=0;j<n;j++){
                 maxArea = Math.max(maxArea, (right[j]-left[j])*height[j]);
             }
         }
         return maxArea;
    }
}
