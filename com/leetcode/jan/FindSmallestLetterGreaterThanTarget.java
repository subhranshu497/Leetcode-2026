package com.com.leetcode.jan;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char [] letters = {'c','f','j'};
        char target = 'a';
        char res = nextGreatestLetter(letters, target);
        System.out.println(res);
    }

    private static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        for(int i=0;i<n;i++){
            if(letters[i]>target)return letters[i];
        }
        return letters[0];
    }
}
