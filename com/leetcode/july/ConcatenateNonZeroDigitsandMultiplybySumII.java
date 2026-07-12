package com.com.leetcode.july;

public class ConcatenateNonZeroDigitsandMultiplybySumII {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        String s = "9876543210";
        int[][] queries = {{0,9}};
        int[] res = concatenateAndMultiplyI(s, queries);
        for(int r:res){
            System.out.println(r);
        }
    }

    private static int[] concatenateAndMultiplyI(String s, int[][] queries) {
        int[] res = new int[queries.length];
        int m = s.length();
        int j =0;
        for(int[] query:queries){
            int l = query[0];
            int r = query[1];
            StringBuilder sb = new StringBuilder();
            long sum = 0;
            for(int i=l;i<=r;i++){
                char ch = s.charAt(i);
                int digit = ch - '0';
                if(digit != 0){
                    sb.append(digit);
                }
                sum += digit;
            }
            long concatenatedNumber = 0;
            for (int i = 0; i < sb.length(); i++) {
                int digit = sb.charAt(i) - '0';
                concatenatedNumber = (concatenatedNumber * 10 + digit) % MOD;
            }
            res[j] = (int)((((concatenatedNumber%MOD) * (sum%MOD)))%MOD);
            j++;
        }
        return res;
    }
}
