package com.com.leetcode.feb;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public static void main(String[] args) {
        int turnedOn = 2;
        List<String> res = readBinaryWatch(turnedOn);
        System.out.println(res);
    }

    private static List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for(int hh=0;hh<=11;hh++){
            int setbitsinhour = Integer.bitCount(hh);
            for(int mm=0;mm<=59;mm++){
                int setbitsinMinutes = Integer.bitCount(mm);
                if(setbitsinhour+setbitsinMinutes ==turnedOn){
                    StringBuilder sb = new StringBuilder();
                    sb.append(hh);
                    sb.append(":");
                    if(mm<10)sb.append(0);
                    sb.append(mm);
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }
}
