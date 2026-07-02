package com.com.leetcode.june;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class NumberofSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        String s = "abcabc";
        int count = numberOfSubstrings(s);
        System.out.println(count);
    }

    private static int numberOfSubstrings(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int count =0;
        int i=0;
        int j =0;
        while(j<n){
            char ch = s.charAt(j);
            if(ch=='a'||ch=='b'||ch=='c')
                map.put(ch, map.getOrDefault(ch,0)+1);
            while(map.size()==3){
                int rem = n-j;
                count +=rem;
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                if(map.get(s.charAt(i))==0)map.remove(s.charAt(i));
                i++;
            }
            j++;
        }
        return count;
    }

//    private static int numberOfSubstrings(String s) {
//        int n =s.length();
//        int count =0;
//        for(int i=0;i<n;i++){
//            StringBuilder sb = new StringBuilder();
//             count +=numberOfSubstringsSolve(s,sb,n,i);
//        }
//        return count;
//    }
//
//    private static int numberOfSubstringsSolve(String s, StringBuilder sb, int n, int i) {
//        //base case
//        if(i>=n)return 0;
//        int count =0;
//        sb.append(s.charAt(i));
//        if(Stream.of("a","b","c").allMatch(sb.toString()::contains)){
//            int rem = n-i;
//            count +=rem;
//            return count;
//        }
//        return count+numberOfSubstringsSolve(s,sb,n,i+1);
//    }
}
