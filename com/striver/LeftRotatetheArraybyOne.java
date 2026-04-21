package com.com.striver;

public class LeftRotatetheArraybyOne {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};
        leftRotateByOne(arr);
        System.out.print("Array after left rotation by one: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void leftRotateByOne(int[] arr) {
        int n = arr.length;
        if (n == 0) return; // Handle empty array case
        int firstElement = arr[0]; // Store the first element
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i]; // Shift elements to the left
        }
        arr[n - 1] = firstElement; // Place the first element at the end
    }
}
