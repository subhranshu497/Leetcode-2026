package com.com.leetcode.july;

import java.util.List;

public class MaximizeActiveSectionwithTradeII {
    public static void main(String[] args) {
        String s = "0100"; // 101001
        int [][] queries = {{1, 2}, {0, 1}, {1, 0}};
        List<Integer> res = maxActiveSectionsAfterTradeII(s, queries);
    }

    private static List<Integer> maxActiveSectionsAfterTradeII(String s, int[][] queries) {
        //Build the segment tree for the string s
        //then based on the queries, we will update the segment tree and get the max active sections after each query
        return null;
    }
}
