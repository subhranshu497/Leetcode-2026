package com.com.leetcode.nov;

public class CalculateDigitSumofaString {
    public static void main(String[] args) {
        String s = "11111222223";
        int k = 3;
        String res = digitSum(s,k);
        System.out.println(res);
    }

    private static String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i+=k){
                int j=i;
                int sum =0;
                while(j<s.length() && j<i+k){
                    char ch = s.charAt(j);
                    sum +=ch-'0';
                    j++;
                }
                sb.append(sum+"");
            }
            s = sb.toString();
        }
        return s;
    }
}
