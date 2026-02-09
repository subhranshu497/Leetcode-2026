package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int [] height = {1,1};
        int area = maxAreaI(height);
        System.out.println(area);
    }

    private static int maxAreaI(int[] height) {
        int n = height.length;
        int maxArea = Integer.MIN_VALUE;
        int i =0;
        int j = n-1;
        while (i<j){
            int leftH = height[i];
            int rightH = height[j];
            //now find the height
            if(height[i]<height[i+1]){
                leftH = height[i+1];
                i++;
            } else if (height[j]<height[j-1]) {
                rightH = height[j-1];
                j--;
            }
            int width = j-i;
            int h = Math.min(leftH, rightH);
            int area = h*width;
            maxArea = Math.max(maxArea, area);
            i++;
            j--;
        }
        return maxArea;
    }
}
