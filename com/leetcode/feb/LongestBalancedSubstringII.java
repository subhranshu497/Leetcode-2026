package com.com.leetcode.feb;

import java.util.HashMap;
import java.util.Map;

public class LongestBalancedSubstringII {
    public static void main(String[] args) {
        String s = "aabcc";
        int res = longestBalancedII(s);
        System.out.println(res);
    }

    private static int longestBalancedII(String s) {
        char[] charArr = s.toCharArray();
        int res = 0;
        int count =0;
        for (int i = 1; i < s.length(); i++) {
            if (charArr[i] == charArr[i - 1]) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 1;
            }
        }
        res = Math.max(res, count);
        // Case: Balancing pairs (a&b, b&c, a&c)
        res = Math.max(res, findCorrect2(charArr, 'a', 'b'));
        res = Math.max(res, findCorrect2(charArr, 'b', 'c'));
        res = Math.max(res, findCorrect2(charArr, 'a', 'c'));

        // Case: Balancing all three (a & b & c)
        res = Math.max(res, findCorrect3(charArr));

        return res;
    }
    private static int findCorrect2(char[] arr, char c1, char c2) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0, max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == c1) count++;
            else if (arr[i] == c2) count--;
            else {
                // Intruder found! Reset the tracking
                map.clear();
                map.put(0, i); // New base index
                count = 0;
                continue;
            }

            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return max;
    }
    private static int findCorrect3(char[] arr) {
        Map<String, Integer> map = new HashMap<>();
        map.put("0_0", -1);
        int a = 0, b = 0, c = 0, max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a') a++;
            else if (arr[i] == 'b') b++;
            else c++;

            String key = (a - b) + "_" + (a - c);
            if (map.containsKey(key)) {
                max = Math.max(max, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }
        return max;
    }
}
