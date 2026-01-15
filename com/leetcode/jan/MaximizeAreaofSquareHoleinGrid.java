package com.com.leetcode.jan;

import java.util.Arrays;

public class MaximizeAreaofSquareHoleinGrid {
    public static void main(String[] args) {
        int n = 2, m = 1;
        int [] hBars = {2,3}, vBars = {2};
        int res = maximizeSquareHoleArea(m,n,vBars,hBars);
        System.out.println(res);
    }

    private static int maximizeSquareHoleArea(int m, int n, int[] vBars, int[] hBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        //find the max consucative sequence length in hBars
        int h_gapSize = calculateMaxConsucativeLength(hBars);
        int v_gapSize = calculateMaxConsucativeLength(vBars);
        int side = Math.min(h_gapSize, v_gapSize);

        return side*side;
    }
    private static int calculateMaxConsucativeLength(int[] bars){
        int j=0, i=0;
        int max_len = 0;
        while(i<bars.length){
            int len=1;
            while(i<bars.length && i !=j && bars[i]-bars[i-1]==1){
                len +=1;
                i++;
            }
            max_len = Math.max(max_len, len);
            j = i;
            i++;
        }
        return max_len+1;
    }
}
