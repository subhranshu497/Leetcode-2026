package com.com.leetcode.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        int low = 1000;
        int high = 13000;
        List<Integer> res = sequentialDigits(low, high);
        System.out.println(res);
    }

    private static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        //take the first digit from low and high
        char startDigit = String.valueOf(low).charAt(0);
        //ran the loop from startDigit to endDigit
        for(int i = 1;i<= 9;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<=9;j++){
                sb.append(j);
                int num = Integer.parseInt(sb.toString());
                if(num >= low && num <= high){
                    res.add(num);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
