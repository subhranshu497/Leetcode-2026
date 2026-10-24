package com.com.leetcode.oct;

public class CountDaysSpentTogether {
    public static void main(String[] args) {
        String arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19";
        int res = countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);
        System.out.println(res);
    }

    private static final int[] DAYS_BEFORE_MONTH = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    private static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveAliceDay = toDayOfYear(arriveAlice);
        int leaveAliceDay = toDayOfYear(leaveAlice);
        int arriveBobDay = toDayOfYear(arriveBob);
        int leaveBobDay = toDayOfYear(leaveBob);

        int start = Math.max(arriveAliceDay, arriveBobDay);
        int end = Math.min(leaveAliceDay, leaveBobDay);

        return Math.max(0, end - start + 1);
    }

    private static int toDayOfYear(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        return DAYS_BEFORE_MONTH[month] + day;
    }
}
