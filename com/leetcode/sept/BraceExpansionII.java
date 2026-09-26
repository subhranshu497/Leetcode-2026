package com.com.leetcode.sept;

import java.util.ArrayList;
import java.util.List;

public class BraceExpansionII {
    public static void main(String[] args) {
        String expression = "{a,b}{c,{d,e}}";
        List<String> res = braceExpansionII(expression);
        System.out.println(res);
    }

    private static List<String> braceExpansionII(String expression) {
        //split the string by }
        String [] strArr = expression.split("\\}");
        List<String> res = new ArrayList<>();

        return res;
    }
}
