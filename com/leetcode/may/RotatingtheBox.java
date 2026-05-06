package com.com.leetcode.may;

public class RotatingtheBox {
    public static void main(String[] args) {
        char[][] box = {{'#','#','*','.','*','.'},{'#','#','#','*','.','.'},{'#','#','#','.','#','.'}};
        char[][] res = rotateTheBox(box);
        for(char[] row: res){
            for(char c: row){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }

    private static char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        //post rotation m =n and n = m
        int new_m =n;
        int new_n = m;
        char[][] res = new char[new_m][new_n];
        //pass 1 - form the transpose of the matrix and rotated
        //last row would be the first column
        char[][] rotated = new char[new_m][new_n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                rotated[j][m-1-i] = box[i][j];
            }
        }
        //print the rotaed matrix
        System.out.println("Printing the rotated matrix");
        for(char[] row: rotated){
            for(char c: row){
                System.out.print(c+" ");
            }
            System.out.println();
        }
        System.out.println("End of print rotated matrix");
        //fill the res with .
        for(int i=0;i<new_m;i++){
            for(int j=0;j<new_n;j++){
                res[i][j] = '.';
            }
        }
        //pass 2 - for each row in the rotated matrix, move the stones
        for(int j=0;j<new_n;j++){
            int new_i = new_m-1;
            for(int i=new_m-1;i>=0;i--){
                if(rotated[i][j] == '.'){
                    continue;
                }else if(rotated[i][j] == '#'){
                    res[new_i][j] = '#';
                    new_i--;
            }else if(rotated[i][j] == '*'){
                    new_i =i;
                    res[new_i][j] = '*';
                    new_i--;
                }
            }
        }
        return res;
    }
}
