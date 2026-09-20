package com.com.leetcode.sept;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

public class BuildingsWithanOceanView {
    public static void main(String[] args) {
        int [] heights = {1,3,2,4};
        int [] res = findBuildings(heights);
        for(int r:res)
            System.out.print(r+", ");
    }

    private static int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> resList = new ArrayList<>();
        for(int i=0;i<n;i++){
            boolean flag = true;
            for(int j=i+1;j<n;j++){
                if(heights[i]<=heights[j]){
                    flag = false;
                    break;
                }
            }
            if(flag)resList.add(i);
        }
        if(resList.size()==0) return new int[]{n-1};
        int [] res = new int[resList.size()];
        for(int i=0;i<resList.size();i++){
            res[i] = resList.get(i);
        }
        return res;
    }
}
