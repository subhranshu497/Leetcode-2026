package com.com.striver;

public class RotateArray {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        int k = 2;
        rotateI(arr, k);
        System.out.println("Array after rotation: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void rotateI(int[] arr, int k) {
        int n = arr.length;
        for(int i=0;i<k;i++){
            int temp1 = arr[k+i];
            int temp2 = arr[n-k+i];
            arr[n-k+i]=arr[i];
            arr[k+i] = temp2;
            arr[i] = temp1;
        }
    }
}
