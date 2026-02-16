package com.com.leetcode.feb;

public class AddBinary {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        String res = addBin(a,b);
        System.out.println(res);
    }

    private static String addBin(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }
}
