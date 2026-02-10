package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
    private static Map<Character, String> letterMap = new HashMap<>();
    public static void main(String[] args) {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        System.out.println(res);
    }

    private static List<String> letterCombinations(String digits) {

        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        letterComSolve(digits, 0, res, new StringBuilder());

        return res;
    }

    private static void letterComSolve(String digits, int idx, List<String> res, StringBuilder sb) {
        //base case
        if(idx==digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = letterMap.get(digits.charAt(idx));
        for(int i=0;i<letters.length();i++){
            sb.append(letters.charAt(i));
            letterComSolve(digits,idx+1,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
