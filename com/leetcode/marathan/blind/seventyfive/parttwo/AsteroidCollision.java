package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.Map;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int [] asteroids = {8,-8};
        int [] res = asteroidCollision(asteroids);
        for(int r:res)
            System.out.print(r+", ");
    }

    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int asteroid:asteroids){
            boolean destroyed = false;
           while (!st.isEmpty() && st.peek()>0 && asteroid <0){
               int diff = asteroid+st.peek();
               if(diff <0){
                   st.pop();
                   continue;
               }else if(diff >0){
                   destroyed =true;
                   break;
               }else {
                   st.pop();
                   destroyed =true;
                   break;
               }
           }
           if(!destroyed)
               st.push(asteroid);
        }
        int [] res = new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            res[i] = st.pop();
        }
        return res;
    }
}
