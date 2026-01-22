package com.com.leetcode.jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumPairRemovaltoSortArrayI {
    public static void main(String[] args) {
        int [] nums = {5,2,3,1};
        int pair = minimumPairRemoval(nums);
        System.out.println(pair);
    }

    private static int minimumPairRemoval(int[] nums) {
        int count =0;
        List<Integer> list = Arrays.stream(nums)
                .boxed().collect(Collectors.toList());
        while(!isSorted(list)){
            int minSumIdx = findMinSumIndex(list);
            int sum = list.get(minSumIdx)+list.get(minSumIdx+1);
            list.set(minSumIdx,sum);
            list.remove(minSumIdx+1);
            count +=1;
        }
        return count;
    }

    private static int findMinSumIndex(List<Integer> list) {
        int minSum = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0;i<list.size()-1;i++){
            int sum = list.get(i)+list.get(i+1);
            if(sum <minSum){
                minSum = sum;
                idx = i;
            }
        }
        return idx;
    }

    private static boolean isSorted(List<Integer> list) {
        return IntStream.range(0, list.size()-1)
                .allMatch(i->list.get(i)<=list.get(i+1));
    }
}
