package com.com.leetcode.jan;

import java.util.List;

public class ConstructtheMinimumBitwiseArrayII {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2,3,5,7);
        int [] res = minBitwiseArrayI(nums);
        for(int r:res)
            System.out.print(r+", ");
    }

    private static int[] minBitwiseArrayI(List<Integer> nums) {
       int [] res = new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            boolean found = false;
            if(nums.get(i)==2){
                res[i]=-1;
                continue;
            }
            for(int j=1;j<32;j++){
                if((nums.get(i) & (1<<j))>0) continue; //jth bit is set
                //set it to 0
                res[i]= (nums.get(i) ^(1<<(j-1)));
                found = true;
                break;
            }
            if(!found) res[i] = -1;
        }
        return res;
    }
}
