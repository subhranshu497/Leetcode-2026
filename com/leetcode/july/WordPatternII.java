package com.com.leetcode.july;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII {
    public static void main(String[] args) {
        String pattern = "abab";
        String str = "redblueredblue";
        boolean res = wordPatternMatch(pattern, str);
        System.out.println(res);
    }

    private static boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> used = new HashSet<>();
        return backtrack(pattern, s, 0, 0, map, used);
    }

    private static boolean backtrack(String pattern, String s, int pi, int si, Map<Character, String> map, Set<String> used) {
        //base case if both completed together - true
        if (pi == pattern.length() && si == s.length()) {
            return true;
        }
        //if one completed and other not - false
        if (pi == pattern.length() || si == s.length()) {
            return false;
        }
        char ch = pattern.charAt(pi);

        //case 1 = if the character is already mapped
        if(map.containsKey(ch)){
            String mappedStr = map.get(ch);
            //check if the mapped string matches the substring in s
            if(s.startsWith(mappedStr, si)){
                return backtrack(pattern, s, pi+1, si + mappedStr.length(), map, used);
            }else{
                return false;
            }
        }
        //case 2 = if the character is not mapped
        for(int k = si; k < s.length(); k++){
            String subStr = s.substring(si, k+1);
            //if the substring is already used, skip
            if(used.contains(subStr))continue;
            //map the character to the substring
            map.put(ch, subStr);
            used.add(subStr);
            //recurse
            if(backtrack(pattern, s, pi+1, k+1, map, used)){
                return true;
            }
            //backtrack
            map.remove(ch);
            used.remove(subStr);
        }
        return false;
    }
}
