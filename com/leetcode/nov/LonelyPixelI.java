package com.com.leetcode.nov;

import java.util.HashSet;
import java.util.Set;

public class LonelyPixelI {
    public static void main(String[] args) {
        char [][] picture = {{'W','W','B'},{'W','B','W'},{'B','W','W'}};
        int lonely = findLonelyPixel(picture);
        System.out.println(lonely);
    }
    public static int findLonelyPixel(char[][] picture) {
        int lonely = 0;
        int m = picture.length;
        int n = picture[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B'){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B' && rowCount[i]==1 && colCount[j]==1){
                    lonely++;
                }
            }
        }
        return lonely;
    }
}
