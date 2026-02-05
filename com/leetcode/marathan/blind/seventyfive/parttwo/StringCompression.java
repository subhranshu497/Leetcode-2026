package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class StringCompression {
    public static void main(String[] args) {
        char [] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int len = compressI(chars);
        for(char ch:chars)
            System.out.print(ch+", ");
        System.out.println(len);
    }

    private static int compressI(char[] chars) {
        int n = chars.length;
        int i =0;
        int j =0;
        //if(n==1) return 1;
        while(j<n){
            int count =0;
            char currChar = chars[j];
            while(j<n && currChar==chars[j]){
                count +=1;
                j++;
            }
            chars[i]= currChar;
            if(count >1){
                String countStr = count+"";
                int countStrLen = countStr.length();
                chars[i++] = chars[j-1];
                for(int k=0;k<countStrLen;k++){
                    chars[i++] = countStr.charAt(k);
                }
            }else i++;
        }
        return i;
    }
}
