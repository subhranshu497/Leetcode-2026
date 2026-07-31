package com.com.leetcode.july;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumNumberofPushestoTypeWordII {
    public static void main(String[] args) {
        String word = "xyzxyzxyzxyz";
        int res = minimumPushesI(word);
        System.out.println(res);
    }

    private static int minimumPushesI(String word) {
        Map<Character, Integer> map = new HashMap<>();
        int res =0;
        for(char c:word.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);
        //collect the freq
        List<Integer> freq = new ArrayList<>();
        for(Map.Entry<Character, Integer> e:map.entrySet()){
            freq.add(e.getValue());
        }
        Collections.sort(freq, Collections.reverseOrder());
        for(int i=0;i<freq.size();i++){
            int press = (i/8)+1;
            res += press*freq.get(i);
        }
        return res;
    }

}
