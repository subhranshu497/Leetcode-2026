package com.com.leetcode.feb;

import java.util.List;

public class ValidWordSquare {
    public static void main(String[] args) {
        List<String> words = List.of( "abcd","bnrt","crmy","dtye");
        boolean flag = validWordSquare(words);
        System.out.println(flag);
    }

    private static boolean validWordSquare(List<String> words) {
        for(int i=0;i<words.size();i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<words.size();j++){
                if(i<words.get(j).length()){
                    sb.append(words.get(j).charAt(i));
                }
            }
            if(!words.get(i).equals(sb.toString()))return false;
        }
        return true;
    }
}
