package com.com.leetcode.august;

public class SimilarRGBColor {
    public static void main(String[] args) {
        String color = "#09f166";
        String res = similarRGB(color);
        System.out.println(res);
    }

    private static String similarRGB(String color) {
        StringBuilder sb = new StringBuilder("#");
        //start processing each two digit of hex component
        for(int i=1;i<color.length();i+=2){
            String subStr = color.substring(i,i+2);
            sb.append(colsestShortendCompoent(subStr));
        }
        return sb.toString();
    }

    private static String colsestShortendCompoent(String subStr) {
        int val = Integer.parseInt(subStr, 16);
        int idx = Math.round(val /17.0f);
        int closestVal = idx*17;

        return String.format("%02x", closestVal);
    }
}
