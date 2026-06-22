package com.com.leetcode.june;

public class MaximumNumberofBalloons {
    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        int res = maxNumberOfBalloons(text);
        System.out.println(res);
    }

    private static int maxNumberOfBalloons(String text) {
        //check for the negative case
        if(text.length()<7)return 0;
        if(!text.contains("b")||!text.contains("a")||!text.contains("l")||!text.contains("o")||!text.contains("n")) return 0;
        int b =0,a=0,l=0,o=0,n=0;
        for(char ch:text.toCharArray()){
            if(ch=='b') b++;
            else if(ch=='a') a++;
            else if(ch=='l') l++;
            else if(ch=='o') o++;
            else if(ch=='n') n++;
        }
        l = l/2;
        o = o/2;
        return Math.min(b,Math.min(a,Math.min(l,Math.min(o,n))));
    }
}
