package com.com.striver;

public class CheckifanArrayisSorted {
    public static void main(String[] args) {
        int [] arr = {1, 2, 6, 4, 5};
        boolean isSorted = checkSorted(arr);
        System.out.println("Is the array sorted? " + isSorted); // Output the result
    }

    private static boolean checkSorted(int[] arr) {
        int inc =-1;
        int dec =-1;
         for(int i=1; i<arr.length; i++){
            if(arr[i] >= arr[i-1]){
                inc = 1;
            } else if(arr[i] <= arr[i-1]){
                dec = 1;
            }
            if(inc == 1 && dec == 1){
                return false;
            }
        }
        return true;
    }
}
