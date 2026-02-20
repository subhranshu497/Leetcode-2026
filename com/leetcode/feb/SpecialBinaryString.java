package com.com.leetcode.feb;

import java.util.ArrayList;
import java.util.List;

public class SpecialBinaryString {
    public static void main(String[] args) {
        String s = "11011000";
        String res = makeLargestSpecial(s);
        System.out.println(res);
    }

    private static String makeLargestSpecial(String s) {
        int st=0;
        int sum=0;
        List<String> res = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')sum++;
            else sum--;
            if(sum==0){
                String inner = s.substring(st+1,i);
                String ss = "1"+makeLargestSpecial(inner)+"0";
                res.add(ss);
                st=i+1;
            }
        }
        return res.stream().sorted((a,b)->b.compareTo(a)).reduce("",(a,b)->a+b);
    }
}
