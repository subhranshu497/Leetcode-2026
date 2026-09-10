package com.com.leetcode.sept;

import java.util.*;

public class HighFive {
    public static void main(String[] args) {
        int [][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int [][] res = highFive(items);
        for(int [] r:res)
            System.out.print(r[0]+", "+r[1]);
    }

    private static int[][] highFive(int[][] items) {
        //write a comparator to arrange in assending order of 0th index , if 0th idx value is same then arrage in decending order of 1st index
        Arrays.sort(items, (a,b)->{
            if(a[0] != b[0])
                return Integer.compare(a[0],b[0]);
            else return Integer.compare(b[1],a[1]);
        });
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        for(int item[]:items){
            int studId = item[0];
            int mark = item[1];
            map.computeIfAbsent(studId, k->new ArrayList<>()).add(mark);
        }
        int [][] res = new int[map.size()][2];
        int idx = 0;
        for(Map.Entry<Integer, List<Integer>>e:map.entrySet()){
            int key = e.getKey();
            List<Integer> list = e.getValue();
            int sum =0;
            int i =0;
            for(;i<Math.max(i,5);i++){
                sum +=list.get(i);
            }
            int avg = sum/i;
            res[idx][0] =key;
            res[idx][1] = avg;
            idx++;
        }
        return res;
    }
}
