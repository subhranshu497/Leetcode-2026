package com.com.leetcode.may;

import java.util.*;

public class MinimumInitialEnergytoFinishTasks {
    public static void main(String[] args) {
        int [][] tasks = {{1,7},{2,8},{3,9},{4,10},{5,11},{6,12}};
        int minEnergy = minimumEffort(tasks);
        System.out.println(minEnergy);
    }

    private static int minimumEffort(int[][] tasks) {
        //step 1 - sort the task based on the buffer time in decreasing order
        Arrays.sort(tasks, (a,b)->(b[1]-b[0])-(a[1]-a[0]));
        int currEnergy = 0;
        int initEnergy =0;
        for(int [] task:tasks){
            int actual = task[0];
            int minimum = task[1];
            if (currEnergy < minimum) {
                initEnergy += (minimum - currEnergy);
                currEnergy = minimum;
            }
            // Spend the actual energy
            currEnergy -= actual;
        }
        return initEnergy;
    }

    private static int canFinishTasks(List<Integer> list, int mid) {
        int currentEnergy = mid;
        int i =0;
        for(int energy : list){
            currentEnergy -= energy; //consume energy for this task
            i++;
        }
        if(currentEnergy < 0){
            return -1; //not enough energy to finish this task
        }else if(i==list.size() - 1 && currentEnergy > 0){
            return 1; //finished all tasks, return remaining energy
        }else {
            return 0;
        }
    }
}
