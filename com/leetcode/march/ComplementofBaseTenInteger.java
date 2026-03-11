package com.com.leetcode.march;

public class ComplementofBaseTenInteger {
    public static void main(String[] args) {
        int n = 5;
        int res = bitwiseComplement(n);
        System.out.println(res);
    }

    private static int bitwiseComplement(int n) {
        String str = Integer.toBinaryString(n);
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            if(str.charAt(i)=='0')
                sb.append(1);
            else sb.append(0);
        }
        int res = Integer.parseInt(sb.toString(),2);
        return res;
    }
}
