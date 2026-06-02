package com.com.leetcode.june;

public class EarliestFinishTimeforLandandWaterRidesI {
    public static void main(String[] args) {
        int [] landStartTime = {5}, landDuration = {3}, waterStartTime = {1}, waterDuration = {10};
        int result = earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        System.out.println(result);
    }

    private static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        //select the ride with the earliest start time
        int startTime = 0;
        if(landStartTime[0] < waterStartTime[0]) {
            startTime = landStartTime[0];
            startTime += landDuration[0];
            if(startTime <= waterStartTime[0]) {
                startTime += waterDuration[0];
            } else {
                int waitTime = waterStartTime[0]-startTime;
                startTime += waitTime;
                startTime += waterDuration[0];
            }
        } else if(landStartTime[0] > waterStartTime[0]) {
             startTime = waterStartTime[0];
             startTime += waterDuration[0];
                if(startTime <= landStartTime[0]) {
                    startTime += landDuration[0];
                } else {
                    startTime += landStartTime[0];
                    startTime += landDuration[0];
                }
        }else{
            startTime = landStartTime[0];
            startTime += Math.max(landDuration[0], waterDuration[0]);
        }
        return startTime;
    }
}
