package com.com.leetcode.june;

public class WeightedWordMapping {
    public static void main(String[] args) {
        int [] weights = {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        String [] words = {"abcd","def","xyz"};
        String res = mapWordWeights(weights, words);
        System.out.println(res);
    }

    private static String mapWordWeights(int[] weights, String[] words) {
        StringBuilder sb = new StringBuilder();
        for(String word :words){
            int sum = 0;
            for(char c : word.toCharArray()){
                sum += weights[c-'a'];
            }
            int rem = sum%26;
            int fIdx = 25-rem;
            char fChar =(char)('a'+fIdx);
            sb.append(fChar);
        }
        return sb.toString();
    }
}
