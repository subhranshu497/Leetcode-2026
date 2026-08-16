package com.leetcode.may;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet","code");
        boolean flag = wordBreakI(s, wordDict);
        System.out.println(flag);
    }

    private static boolean wordBreakI(String s, List<String> wordDict) {
        int n = s.length();
        boolean[]dp = new boolean[n+1];
        Set<String> set = new HashSet<>();
        for(String str:wordDict)
            set.add(str);
        //base case
        dp[n] = true;
        //outer loop var is start and inner loop variable end
        //since it is bottoms up we will navigating from back
        for(int start = n-1;start>=0;start--){
            for(int end =start;end<=n;end++){
                String prefix = s.substring(start,end);
                if(set.contains(prefix)&& dp[end]) {
                    dp[start]= true;
                    //break;
                }
            }
        }
          return dp[0];
    }

//    private static boolean wordBreakI(String s, List<String> wordDict) {
//        //put all words into a set for quick search
//        Set<String> set = new HashSet<>();
//        for(String word:wordDict){
//            set.add(word);
//        }
//        int n = s.length();
//        boolean [] dp = new boolean[n+1];
//        //lets do bottom up
//        dp[n] = true;
//        for(int st=n-1;st>=0;st--){
//            for(int end=st+1;end<=n;end++){
//                String prefix = s.substring(st, end);
//                if(set.contains(prefix)&& dp[end]){
//                    dp[st]= true;
//                    break;
//                }
//            }
//        }
//        return dp[0];
//    }

//    private static boolean wordBreakI(String s, List<String> wordDict) {
//        Boolean []memo = new Boolean[s.length()+1];
//        //put all words into a set for quick search
//        Set<String> set = new HashSet<>();
//        for(String word:wordDict){
//            set.add(word);
//        }
//        //call the recursion
//       return canWordBreak(s, set,0, memo);
//    }
//
//    private static boolean canWordBreak(String s, Set<String> set, int start, Boolean [] memo) {
//        //base case
//        if(start==s.length())return true;
//        if(memo[start] !=null)return memo[start];
//        for(int end=start+1;end<=s.length();end++){
//            String prefix = s.substring(start,end);
//            if(set.contains(prefix)&&canWordBreak(s, set, end, memo)){
//
//                return memo[start] =true;
//            }
//        }
//        return memo[start] =false;
//    }
}
