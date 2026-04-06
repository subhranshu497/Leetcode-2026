package com.com.leetcode.april;

import java.util.HashMap;
import java.util.Map;

public class RobotReturntoOrigin {
    public static void main(String[] args) {
        String moves = "RRDD";
        System.out.println(judgeCircle(moves));
    }

    private static boolean judgeCircle(String moves) {
        int horizontal = 0;
        int vertical = 0;
        for (char c : moves.toCharArray()) {
            if(c== 'U') vertical +=1;
            else if(c == 'D') vertical -=1;
            else if(c == 'L') horizontal -=1;
            else if(c == 'R') horizontal +=1;
        }
        if(horizontal == 0 && vertical == 0) return true;
        return false;
    }
}
