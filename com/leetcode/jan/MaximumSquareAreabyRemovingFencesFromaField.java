package com.com.leetcode.jan;

import java.util.*;

public class MaximumSquareAreabyRemovingFencesFromaField {
    public static void main(String[] args) {
        int m = 4, n = 3;
        int [] hFences = {2,3}, vFences = {2};
        int area = maximizeSquareArea(m,n,hFences, vFences);
        System.out.println(area);
    }

    private static int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        List<Integer> hFences_copy = new ArrayList<>();
        List<Integer> vFences_copy = new ArrayList<>();
        hFences_copy.add(1);
        hFences_copy.add(m);
        vFences_copy.add(1);
        vFences_copy.add(n);
        for(int x:hFences)hFences_copy.add(x);
        for(int x:vFences)vFences_copy.add(x);
        Set<Integer> hSet = new HashSet<>();
        Collections.sort(hFences_copy);
        Collections.sort(vFences_copy);
        // now form the
        for(int i=0;i<hFences_copy.size();i++){
            for(int j=i+1;j<hFences_copy.size();j++){
                hSet.add(hFences_copy.get(j)-hFences_copy.get(i));
            }
        }
        int maxSide =0;
        for(int i=0;i<vFences_copy.size();i++){
            for(int j=i+1;j<vFences_copy.size();j++){
                int height = vFences_copy.get(j)-vFences_copy.get(i);
                if(hSet.contains(height))
                    maxSide = Math.max(maxSide, height);
            }
        }

        if(maxSide==0) return -1;
        long area = (long) maxSide*maxSide;
        return (int)(area%1000000007);
    }

}
