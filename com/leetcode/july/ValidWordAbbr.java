package com.com.leetcode.july;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidWordAbbr {
    Map<String, Set<String>> map;
    public ValidWordAbbr(){
        map = new HashMap<>();
    }
    public ValidWordAbbr(String[] dictionary) {
        for(String word:dictionary){
            String abbr = getAbbreviation(word);
            map.computeIfAbsent(abbr, k->new HashSet<>()).add(word);
        }
    }

    private String getAbbreviation(String word) {
        StringBuilder sb = new StringBuilder();
        int n = word.length();
        if(n<=2)return word;
        sb.append(word.charAt(0));
        sb.append(n-2);
        sb.append(word.charAt(n-1));
        return sb.toString();
    }

    public boolean isUnique(String word) {
        String abbr = getAbbreviation(word);
        if(!map.containsKey(abbr))return true;
        Set<String> set = map.get(abbr);
        if(set.contains(word))return true;
        return false;
    }
}
