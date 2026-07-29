package com.com.leetcode.july;

public class SmallestPalindromicRearrangementII {
    private static long maxK = 1000001;
    public static void main(String[] args) {
        String s = "abba";
        int k = 2;
        String res = smallestPalindromeII(s, k);
        System.out.println(res);
    }

    private static String smallestPalindromeII(String s, int k) {
        int [] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        char mid = s.charAt(s.length()/2);
        int [] halfFreq = new int[26];
        int halfLen = 0;
        //form the half freq array
        for(int i =0;i<26;i++){
            halfFreq[i] = freq[i]/2;
            halfLen += halfFreq[i];
        }
        //calculate the total permutation of half
        long totalPerm = calculatePermutation(halfFreq);
        //edge case
        if(k>totalPerm)return "";
        StringBuilder firstHalf = new StringBuilder();
        for(int pos =0;pos<halfLen;pos++){
            for(int ch=0;ch<26;ch++){
                if(halfFreq[ch]>0){
                    halfFreq[ch]--;
                    long perms = calculatePermutation(halfFreq);
                    if(perms >= k){
                        firstHalf.append((char)('a'+ch));
                        break;
                    }else{
                        k -=perms;
                        halfFreq[ch]++;
                    }
                }
            }
        }
        String fh = firstHalf.toString();
        String rev = new StringBuilder(firstHalf).reverse().toString();
        String midS = (s.length()%2 !=0)?String.valueOf(mid):"";
        return fh+midS+rev;
    }
    private static long calculatePermutation(int [] counts){
        int total =0;
        for(int count:counts){
            total +=count;
        }
        long res =1;
        for(int i=0;i<26;i++){
            int count = counts[i];
            res = res * calculateFactorial(total, count);
            if(res >=maxK) return maxK;
            total -=count;
        }
        return res;
    }
    private static long calculateFactorial(int total, int count){
        if(count > total) return 0;
        if(count > total-count) count = total-count;
        long res =1;
        for(int i=1;i<=count;i++){
            res = res* (total-i+1)/i;
            if(res >= maxK) return maxK;
        }
        return res;
    }
}
