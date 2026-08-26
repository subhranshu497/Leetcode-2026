package com.com.leetcode.august;

public class ShortestandLexicographicallySmallestBeautifulString {
    public static void main(String[] args) {
        String s = "1100001110111100100";
        int k =8;
        String res = shortestBeautifulSubstring(s,k);
        System.out.println(res);
    }

    private static String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int oneCount =0;
        String res = "";
        int l=0;
        int r=0;
        while (r<n){
            if(s.charAt(r)=='1')oneCount +=1;
            while(oneCount==k){
                //check for lexicographically smaller string
                String temp = s.substring(l,r+1);
                if(res.isEmpty())res=temp;
                else if(temp.length()<res.length())
                    res = temp;
                else if(temp.length()==res.length()){
                    boolean smaller = checkLexicographicallySmaller(res,temp);
                    if(!smaller)res = temp;
                }
                if(s.charAt(l)=='1')oneCount -=1;
                l++;
            }
            r++;
        }
        return res;
    }

    private static boolean checkLexicographicallySmaller(String s1, String s2) {
        int n = s1.length();
        int i =0;
        while(i<n){
            if(s1.charAt(i)<s2.charAt(i))return true;
            if(s1.charAt(i)>s2.charAt(i))return false;
            i++;
        }
        return false;
    }
}
