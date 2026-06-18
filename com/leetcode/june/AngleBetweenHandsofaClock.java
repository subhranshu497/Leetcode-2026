package com.com.leetcode.june;

public class AngleBetweenHandsofaClock {
    public static void main(String[] args) {
        int hour = 12;
        int minutes = 30;
        double res = angleClock(hour, minutes);
        System.out.println(res);
    }

    private static double angleClock(int hour, int minutes) {
        //step 1 - calculate the minute angle
        //60 min--> 360 degrees
        //1 min--> 6 degrees
        double M = 360.0/60.0;
        double minuteAngle = M*minutes;
        //step 2 - calculate the hour angle
        //12 hours--> 360 degrees
        //1 hour--> 30 degrees
        double H = 360.0/12.0;
        //step 3 - calculate the hour angle with respect to the minutes
        //60 min--> 30 degrees
        //1 min--> 0.5 degrees
        double HM = 30.0/60.0;
        double hourAngle = H*hour + HM*minutes;
        //step 4 - calculate the angle between the hour and minute hand
        double angle = Math.abs(hourAngle-minuteAngle);
        return Math.min(angle, 360-angle);
    }
}
