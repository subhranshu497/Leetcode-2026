package com.jan;

public class MaximumMatrixSum {
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{-1,-2,-3},{1,2,3}};
        long res = maxMatrixSum(matrix);
        System.out.println(res);
    }

    private static long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int countNegative = 0;
        int minAbs = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum +=Math.abs(matrix[i][j]);
                if(matrix[i][j] <0){
                    countNegative +=1;
                }
                minAbs = Math.min(minAbs, Math.abs(matrix[i][j]));
            }
        }
        if(countNegative % 2 ==0) return sum;

        return sum-2L*minAbs;
    }
}
