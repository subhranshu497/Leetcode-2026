package com.com.leetcode.marathan.blind.seventyfive.partOne;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int [] heights = {1,8,6,2,5,4,8,3,7};
        int area = maxArea(heights);
        System.out.println(area);
    }

    private static int maxArea(int[] heights) {
        int n = heights.length;
        int i =0;
        int j = n-1;
        int area = 0;
        while(i<j){
            int height =Math.min(heights[i], heights[j]);
            int width = j-i;
            int temp = height*width;
            area = Math.max(temp, area);
            if(heights[i]>heights[j])j--;
            else if(heights[i] < heights[j])i++;
            else{
                i++;
                j--;
            }
        }
        return area;
    }
}
