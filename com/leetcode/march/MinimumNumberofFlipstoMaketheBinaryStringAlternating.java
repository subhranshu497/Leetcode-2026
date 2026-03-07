package com.com.leetcode.march;

public class MinimumNumberofFlipstoMaketheBinaryStringAlternating {
    public static void main(String[] args) {
        String s = "11100";
        int count = minFlips(s);
        System.out.println(count);
    }

    private static int minFlips(String s) {
        int n = s.length();
        int flip = Integer.MAX_VALUE;
        int flip1 = 0;
        int flip2 = 0;
        String str = s+s; //1110011100
        //form two alternating strings
        StringBuilder alt1 = new StringBuilder();//0101010101
        StringBuilder alt2 = new StringBuilder();//1010101010
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                alt1.append('0');
                alt2.append('1');
            } else {
                alt1.append('1');
                alt2.append('0');
            }
        }
        int j = 0, i = 0;
        //start the sliding window
        while(j < 2*n) {
            // expand window
            if(str.charAt(j) != alt1.charAt(j)) flip1++; //
            if(str.charAt(j) != alt2.charAt(j)) flip2++;

            // shrink window
            if(j - i + 1 > n) {
                if(str.charAt(i) != alt1.charAt(i)) flip1--;
                if(str.charAt(i) != alt2.charAt(i)) flip2--;
                i++;
            }

            // window size n
            if(j - i + 1 == n)
                flip = Math.min(flip, Math.min(flip1, flip2));
            j++;
        }
            return flip;
    }
}
