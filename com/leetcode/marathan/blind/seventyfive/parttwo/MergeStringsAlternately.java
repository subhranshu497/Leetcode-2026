package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        String res = mergeAlternately(word1, word2);
        System.out.println(res);
    }

    private static String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        StringBuilder sb = new StringBuilder();
        int i=0, j=0;
        while(i<n1 && j<n2){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }
        String sub ="";
        if(i !=n1){
            sub = word1.substring(i,n1);
        }else if(j !=n2)sub = word2.substring(j,n2);
        return sb.toString()+sub;
    }
}
