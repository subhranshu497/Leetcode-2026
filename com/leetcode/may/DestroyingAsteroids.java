package com.com.leetcode.may;

import java.util.Arrays;

public class DestroyingAsteroids {
    public static void main(String[] args) {
        int [] asteroids = {97};
        int mass = 5;
        boolean result = asteroidsDestroyed(mass, asteroids);
        System.out.println(result);
    }

    private static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currMass = mass;
        for(int astroid:asteroids){
            if(astroid<=currMass){
                currMass += astroid;
            } else {
                return false;
            }
        }
        return true;
    }

    //correct solution
//    private static boolean asteroidsDestroyed(int mass, int[] asteroids) {
//        Arrays.sort(asteroids);
//        int pivot = findPivot(asteroids, mass);
//        //check going backward
//        int j = pivot;
//        long currMass = mass;
//        int count = 0;
//        while(j>=0 && asteroids[j] <= currMass){
//            currMass += asteroids[j];
//            count++;
//            j--;
//        }
//        //now move forward from the pivot point and check if we can destroy the remaining asteroids
//        int i = pivot + 1;
//        while(i<asteroids.length && asteroids[i] <= currMass){
//            currMass += asteroids[i];
//            count++;
//            i++;
//        }
//        return count == asteroids.length;
//    }

//    private static boolean asteroidsDestroyed(int mass, int[] asteroids) {
//        Arrays.sort(asteroids);
//        //step 1 - find the pivot point where plat mass is less than or equal to the asteroid mass
//        //apply binary search to find the pivot point
//        int pivot = findPivot(asteroids, mass);
//        int n = asteroids.length;
//        int count = 0;
//        while(count < n){
//            boolean destroyed = false;
//            int i = pivot;
//            //check forward
//            while(i<n && asteroids[i] <= mass){
//                mass += asteroids[i];
//                destroyed = true;
//                asteroids[i] = 0;
//                count++;
//                i++;
//            }
//            int j = pivot - 1;
//            //keep track of the i pointer and check backward
//            if(i<n){
//                pivot = i;
//            }
//            //check backward
//            while (j>=0 && asteroids[j] !=0){
//                mass += asteroids[j];
//                count++;
//                j--;
//                destroyed = true;
//            }
//            if(!destroyed){
//                break;
//            }
//        }
//        return count == n;
//    }

    private static int findPivot(int[] asteroids, int mass) {
        int pivot = 0;
        int l = 0;
        int r = asteroids.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(asteroids[mid] <= mass){
                pivot = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return pivot;
    }
}
