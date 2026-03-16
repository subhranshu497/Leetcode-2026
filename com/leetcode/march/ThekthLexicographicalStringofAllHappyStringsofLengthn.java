package com.com.leetcode.march;

import java.util.ArrayList;
import java.util.List;

public class ThekthLexicographicalStringofAllHappyStringsofLengthn {
    public static void main(String[] args) {
        int n =3, k=9;
        String res = getHappyString(n,k);
        System.out.println(res);
    }

    private static String getHappyString(int n, int k) {
        StringBuilder current = new StringBuilder();
        List<String> res = new ArrayList<>();
        getHappyStringSolve(current,res,n);

        return  res.size() < k?"":res.get(k-1);
    }

    private static void getHappyStringSolve(StringBuilder current, List<String> res, int n) {
        //base case
        if(current.length()==n){
            res.add(current.toString());
            return;
        }
        for(char ch ='a';ch<='c';ch++){
            if(current.length()>0 && current.length()-1==ch) continue;
            getHappyStringSolve(current.append(ch),res,n);
            current.deleteCharAt(current.length()-1);
        }
    }
}
