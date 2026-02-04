package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        String [] wordDict = {"leet","code"};
        System.out.println(wordBreak(s, wordDict));
    }

    private static boolean wordBreak(String s, String[] wordDict) {
        int n = s.length();
        Set<String> wordDictionary = new HashSet<>();
        Boolean[] memo = new Boolean[n+1];
        for(String str:wordDict)
            wordDictionary.add(str);
        boolean [] t= new boolean[n+1];
        t[0] =true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                String word = s.substring(j,i);
                if(t[j] && wordDictionary.contains(word)){
                    t[i] = true;
                    break;
                }
            }
        }
        //prit the t array
        for(boolean f:t)
            System.out.print(f+", ");
        return t[n];
    }

//    private static boolean wordBreak(String s, String[] wordDict) {
//        int n = s.length();
//        Set<String> wordDictionary = new HashSet<>();
//        Boolean[] memo = new Boolean[n+1];
//        for(String str:wordDict)
//            wordDictionary.add(str);
//        return wordBreakSolve(s, wordDictionary,n,0, memo);
//    }
//
//    private static boolean wordBreakSolve(String s, Set<String> wordDictionary, int n, int st,Boolean[] memo) {
//        //base case
//        if(st==n)return true;
//        if(st>n)return false;
//        if(memo[st] != null)return memo[st];
//        for(int end=st+1;end<=n;end++){
//            String sub = s.substring(st,end);
//            if(wordDictionary.contains(sub)){
//                if(wordBreakSolve(s,wordDictionary,n,end, memo))return memo[st]=true;
//            }
//        }
//        return memo[st]=false;
//    }
}
