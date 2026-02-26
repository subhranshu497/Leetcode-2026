package com.com.leetcode.feb;

import java.math.BigInteger;

public class NumberofStepstoReduceaNumberinBinaryRepresentationtoOne {
    public static void main(String[] args) {
        String s = "1101";
        int steps = numSteps(s);
        System.out.println(steps);
    }

    private static int numSteps(String s) {
        int steps =0;
        int carry =0;
        int i = s.length()-1;
        while(i>0){
            int digit = Character.getNumericValue(s.charAt(i))+carry;
            if(digit %2 ==1){
                steps +=2;
                carry =1;
            }else steps +=1;
            i--;
        }
        return steps+carry;
    }
}
