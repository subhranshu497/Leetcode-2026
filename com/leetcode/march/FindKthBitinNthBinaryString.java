package com.com.leetcode.march;

public class FindKthBitinNthBinaryString {
    public static void main(String[] args) {
        int n = 4;
        int k = 11;
        char res = findKthBit(n, k);
        System.out.println(res);
    }

    private static char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        for(int i=1;i<n;i++){
            String processed = reverse(invert(sb.toString()));
            sb.append("1").append(processed);
        }
        System.out.println(sb.toString());
        return sb.charAt(k-1);
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    private static String invert(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c=='0'){
                sb.append('1');
            }else sb.append('0');
        }
        return sb.toString();
    }
}
