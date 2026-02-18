package com.com.leetcode.feb;

public class BinaryNumberwithAlternatingBits {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(hasAlternatingBits(n));
    }

    private static boolean hasAlternatingBits(int n) {
        int res = n ^(n>>1);
       return (res & (res+1))==0;
    }

//    private static boolean hasAlternatingBits(int n) {
//        StringBuilder sb = new StringBuilder();
//        while(n != 0){
//            int rem = n%2;
//            n = n/2;
//            sb.append(rem);
//        }
//        String s = sb.reverse().toString();
//        for(int i=0;i<s.length()-1;i++){
//            if(s.charAt(i)== s.charAt(i+1))return false;
//        }
//        return true;
//    }
}
