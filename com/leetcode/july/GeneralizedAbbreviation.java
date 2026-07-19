package com.com.leetcode.july;

import java.util.List;

public class GeneralizedAbbreviation {
    public static void main(String[] args) {
        String word = "word";
        List<String> res = generateAbbreviations(word);
        System.out.println(res);
    }

    private static List<String> generateAbbreviations(String word) {
        List<String> res = new java.util.ArrayList<>();
        generateAbbreviationsBacktrack(res, word, "", 0, 0);
        return res;
    }

    private static void generateAbbreviationsBacktrack(List<String> res, String word, String s, int i, int count) {
        if (i == word.length()) {
            if (count > 0) s += count;
            res.add(s);
        } else {
            generateAbbreviationsBacktrack(res, word, s, i + 1, count + 1);
            generateAbbreviationsBacktrack(res, word, s + (count > 0 ? count : "") + word.charAt(i), i + 1, 0);
        }
    }
}
