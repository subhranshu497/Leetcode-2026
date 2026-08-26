package com.com.hr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimumAbsDiff {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(-2);
        arr.add(4);
        int ans = minimumAbsoluteDifference(arr);
        System.out.println(ans);
    }
    public static int minimumAbsoluteDifference(List<Integer> arr) {
        int n = arr.size();
        if(n==0)return 0;
        arr.sort(Comparator.naturalOrder());
        List<Integer> diff = new ArrayList<>();
        for(int i=1;i<n;i++){
            int d = Math.abs(arr.get(i)-arr.get(i-1));
            diff.add(d);
        }
        diff.sort(Comparator.naturalOrder());
        return diff.get(0);

    }
}
