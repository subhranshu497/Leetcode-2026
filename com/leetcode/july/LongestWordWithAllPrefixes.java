package com.com.leetcode.july;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordWithAllPrefixes {
    public static void main(String[] args) {
        String [] words = {"a","banana","app","appl","ap","apply","apple"};
        String res = longestWord(words);
        System.out.println(res);
    }

    private static String longestWord(String[] words) {
        String res = "";
        int resLen = 0;
        Arrays.sort(words,(a,b)->b.length()-a.length());
        Set<String> set = new HashSet<>();
        for(String word:words){
            set.add(word);
        }
        for(String word:words){
            int len = word.length();
            if(len<resLen)break;
            boolean isValid = true;
            for(int i=1;i<=len;i++){
                String prefix = word.substring(0,i);
                if(!set.contains(prefix)){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                if(len>resLen){
                    res = word;
                    resLen = len;
                }else if(len==resLen && word.compareTo(res)<0){
                    res = word;
                }
            }
        }
        return res;
    }
}
