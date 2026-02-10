package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        int n =9;
        int k =3;
        List<List<Integer>> res= combinationSum3(n,k);
        System.out.println(res);
    }

    private static List<List<Integer>> combinationSum3(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        comsumIIISolve(n,k,res, 1,0,new ArrayList<>());
        return res;
    }

    private static void comsumIIISolve(int target, int k, List<List<Integer>> res, int i, int sum, List<Integer> ds) {
        //base case
        if(ds.size()==k){
            if(sum==target)
                res.add(new ArrayList<>(ds));
            return;
        }
        for(int idx = i;idx<=9;idx++){
            //if(idx>target)break;
            //take
            ds.add(idx);
            sum += idx;
            comsumIIISolve(target, k, res, idx + 1, sum, ds);
            sum -=ds.get(ds.size()-1);
            ds.remove(ds.size()-1);
        }
    }
}
