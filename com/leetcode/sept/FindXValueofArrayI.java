package com.com.leetcode.sept;

public class FindXValueofArrayI {
    public static void main(String[] args) {
        int [] A = {2,8,8,10,10,10,6,6,7,6,5,10,8,4,9,8};
        int k = 5;
       long[] res = resultArrayI(A,k);
       for(long l:res)
           System.out.print(l+", ");
    }

    private static long[] resultArrayI(int[] a, int k) {
        int n = a.length;
        long [] res = new long[k];
        for(int i=0;i<n;i++){
            int temp = a[i]%k;
            if((int)temp < k){
                res[(int) temp] +=1 ;
            }
            long prod = a[i];
            for(int j=i+1;j<n;j++){
                prod *=a[j];
                long temp1 =prod%k;
                if(temp1 < k){
                    res[(int) temp1]++;
                }
            }
        }
        return res;
    }
}
