package com.com.leetcode.jan;

public class FourDivisors {
    public static void main(String[] args) {
        int [] nums = {21,4,7};
        int res = sumFourDivisors(nums);
    }
    public static int sumFourDivisors(int[] nums) {
        int res =0;
        for(int num:nums){
            if(sumOne(num) !=-1)
                res +=sumOne(num);
        }
        return res;
    }
    private static int sumOne(int num){
        int cube = (int)Math.round(Math.cbrt(num));
        if((long)cube*cube*cube == num && isPrime(cube))
            return 1+cube+(cube*cube)+(cube*cube*cube);
        for(int i = 2;i*i <= num;i++){
            if(num % i == 0){
                int a =i;
                int b = num/i;
                if(a !=b && isPrime(a) && isPrime(b))
                    return 1+a+b+num;
                return -1;
            }
        }
        return -1;
    }
    private static boolean isPrime(int x){
        if(x < 2) return false;
        for(int i=2;i*i <= x;i++){
            if(x % i == 0) return false;
        }
        return true;
    }
}
