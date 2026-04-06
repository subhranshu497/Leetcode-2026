package com.com.leetcode.april;

public class DecodetheSlantedCiphertext {
    public static void main(String[] args) {
        String s = "ch   ie   pr";
        int numRows = 3;
        String res = decodeCiphertext(s, numRows);
        System.out.println(res);
    }

    private static String decodeCiphertext(String s, int numRows) {
        int cols = s.length() / numRows;
        char [][] matrix = new char[numRows][cols];
        for(int i=0;i<numRows;i++){
            for(int j=0;j<cols;j++){
                matrix[i][j] = s.charAt(i*cols+j);
            }
        }
        //to get the decoded text
        StringBuilder sb = new StringBuilder();
        for(int col=0;col<cols;col++){
            int i=0, j=col;
            while (i<numRows && j<cols){
                sb.append(matrix[i][j]);
                i++;
                j++;
            }
        }
        //remove all the trailing spaces
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
        return sb.toString();
    }
}
