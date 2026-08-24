package com.com.leetcode.august;

public class SumGame {
    public static void main(String[] args) {
        String num = "5023";
        boolean flag = sumGame(num);
        System.out.println(flag);
    }

    private static boolean sumGame(String num) {
        boolean res = false;
        //edge case - if the num doesnt have ?
        boolean flag = !num.contains("?");
        char [] charArr = num.toCharArray();
        int n = charArr.length;
        //now calculate the number of qn marks
        int qLeft = 0;
        int qRight = 0;
        int i=0;
        int j = n-1;
        int sumFirst =0;
        int sumSecond =0;
        while(i<j){
            if(charArr[i]=='?')qLeft++;
            else sumFirst +=charArr[i]-'0';
            if(charArr[j]=='?')qRight++;
            else sumSecond +=charArr[j]-'0';
            i++;
            j--;
        }
        return 2*(sumFirst-sumSecond) != 9*(qRight-qLeft);
    }
}
