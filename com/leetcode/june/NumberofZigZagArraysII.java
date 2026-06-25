package com.com.leetcode.june;

public class NumberofZigZagArraysII {
    static int [][][] memo;
    private static int MOD = 1000000007;
    public static void main(String[] args) {
        int l=4 , r = 5, n=3;
        int m = r-l+1;
        int res = countZigZagArrays(m, n);
        System.out.println(res);
    }

    private static int countZigZagArrays(int m, int n) {
        memo = new int [n+1][m+2][2];
        //define the final state of the memoization table
        //always once n is reached , that would be one valid zigzag array
        //this was the base case in the recursive solution
        for(int i=1;i<=m;i++){
            memo[n][i][0] = 1;
            memo[n][i][1] = 1;
        }
        //fill the memoization table in reverse order
        for(int i=n-1;i>=1;i--){
            long[] prefixNextInc = new long[m+2];
            long[] suffixNextDec = new long[m+2];
            //fill the prexix sum for increasing
            for(int x=1;x<=m;x++){
                prefixNextInc[x] = (prefixNextInc[x-1]+memo[i+1][x][0])%MOD;
            }
            //fill the suffix sum for decreasing
            for(int x=m;x>=1;x--){
                suffixNextDec[x] = (suffixNextDec[x+1]+memo[i+1][x][1])%MOD;
            }
            for(int prev=1;prev<=m;prev++){
                //isInc ==1
                memo[i][prev][1] = (int)(prefixNextInc[m]-prefixNextInc[prev]+MOD)%MOD;
                //isInc ==0
                memo[i][prev][0] = (int)(suffixNextDec[1]-suffixNextDec[prev]+MOD)%MOD;
            }
        }
        //pick the res from the first row of the memoization table
        int res =0;
        for(int i=1;i<=m;i++){
            //increasing
            res =(res+ memo[1][i][1])%MOD;
            //decreasing
            res =(res+ memo[1][i][0])%MOD;
        }
        return res;
    }

    //using dp TC = O(n*m*m) SC = O(n*m*2) - TLE
//    private static int countZigZagArrays(int m, int n) {
//        memo = new int [n+1][m+2][2];
//        //define the final state of the memoization table
//        //always once n is reached , that would be one valid zigzag array
//        //this was the base case in the recursive solution
//        for(int i=1;i<=m;i++){
//            memo[n][i][0] = 1;
//            memo[n][i][1] = 1;
//        }
//        //fill the memoization table in reverse order
//        for(int i=n-1;i>=1;i--){
//            for(int prev=1;prev<=m;prev++){
//                for(int isInc=0;isInc<=1;isInc++){
//                    long res =0;
//                    //check for increasing
//                    if(isInc==1){
//                        for(int nextVal=prev+1;nextVal<=m;nextVal++){
//                            res = (res+memo[i+1][nextVal][0])%MOD;
//                        }
//                    }else{
//                        for(int nextVal=prev-1;nextVal>=1;nextVal--){
//                            res = (res+memo[i+1][nextVal][1])%MOD;
//                        }
//                    }
//                    memo[i][prev][isInc] = (int)(res%MOD);
//                }
//            }
//        }
//        //pick the res from the first row of the memoization table
//        int res =0;
//        for(int i=1;i<=m;i++){
//            //increasing
//            res =(res+ memo[1][i][1])%MOD;
//            //decreasing
//            res =(res+ memo[1][i][0])%MOD;
//        }
//        return res;
//    }

//    private static int countZigZagArrays(int m, int n) {
//        int res =0;
//        memo = new int[2001][2001][2];
//        for(int [][] mTwo:memo){
//            for(int [] mOne:mTwo){
//                Arrays.fill(mOne,-1);
//            }
//        }
//        //have to check for all starting numbers from l to r l=1 , r =m
//        for(int i=1;i<=m;i++){
//            //increasing
//            res =(res+countZigZagArraysHelper(1,i+1,m,n,1))%MOD;
//            //decreasing
//            res =(res+countZigZagArraysHelper(1,i+1,m,n,0))%MOD;
//        }
//        return res;
//    }
//
//    private static int countZigZagArraysHelper(int i, int prev, int m, int n, int isInc) {
//        //base case
//        //i.e we have filled all the n elements
//        if(i==n)return 1;
//        if(memo[i][prev][isInc]!=-1)return memo[i][prev][isInc];
//        long res =0;
//        //check if it is increasing
//        if(isInc==1) {
//            //then nextVal will be prev+1 to m
//            for (int nextVal = prev + 1; nextVal <= m; nextVal++) {
//                res = (res+countZigZagArraysHelper(i + 1, nextVal, m, n, 0))%MOD;
//            }
//        }else{
//            //then nextVal will be prev-1 to 1
//            for (int nextVal = prev - 1; nextVal >= 1; nextVal--) {
//                res = (res+countZigZagArraysHelper(i + 1, nextVal, m, n, 1))%MOD;
//            }
//        }
//        return memo[i][prev][isInc] = (int)(res%MOD);
//    }
}
