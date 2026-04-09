package com.com.leetcode.april;

public class PourWater {
    public int[] pourWater(int[] heights, int volume, int k) {
        for (int i = 0; i < volume; i++) {
            int index = k;

            // Move left
            for (int j = k - 1; j >= 0; j--) {
                if (heights[j] > heights[index]) break;
                if (heights[j] < heights[index]) index = j;
            }

            // If no movement left, move right
            if (index == k) {
                for (int j = k + 1; j < heights.length; j++) {
                    if (heights[j] > heights[index]) break;
                    if (heights[j] < heights[index]) index = j;
                }
            }

            // Pour water at the selected index
            heights[index]++;
        }
        return heights;
    }
}
