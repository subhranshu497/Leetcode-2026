package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = groupAnagrams(strs);
        System.out.println(res);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            StringBuilder sb = new StringBuilder();
            Map<Character, Integer> tMap = new HashMap<>();
            char [] chArr = str.toCharArray();
            Arrays.sort(chArr);
            for(char ch:chArr){
                tMap.put(ch, tMap.getOrDefault(ch, 0)+1);
            }
            Character [] charArr = tMap.keySet().toArray(new Character[0]);
            Integer [] intArr = tMap.values().toArray(new Integer[0]);
            for(int i=0;i<charArr.length;i++){
                sb.append(charArr[i]);
                sb.append(intArr[i]);
            }
            map.computeIfAbsent(sb.toString(),k->new ArrayList<>()).add(str);
        }
        //get all the values
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> e:map.entrySet()){
            List<String> list = e.getValue();
            res.add(list);
        }
        return res;
    }
}

