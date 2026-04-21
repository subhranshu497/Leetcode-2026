package com.com.striver;

public class RemoveDuplicatesinplacefromSortedArray {
    public static void main(String[] args) {
        int [] arr = {1, 1, 2, 2, 3, 4, 4, 5};
        int[] newArr = removeDuplicates(arr);
        //System.out.println("New length of the array after removing duplicates: " + newLength); // Output the result
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }

    private static int[] removeDuplicates(int[] arr) {
       int n = arr.length;
       int idx =1;
       for(int i=1;i<n;i++){
           if(arr[i] != arr[i-1]){
               arr[idx] = arr[i];
               idx++;
           }
       }
       for(int i=idx; i<n; i++){
           arr[i] = 0; // Optional: Set remaining elements to 0 or any default value
       }
       return arr;
    }
}
