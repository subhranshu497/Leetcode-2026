package com.com.leetcode.sept;

public class CircleandRectangleOverlapping {
    public static void main(String[] args) {
        int radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1;
        boolean res = checkOverlap(radius,xCenter,yCenter,x1,y1,x2,y2);
        System.out.println(res);
    }
    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x = Math.max(x1, Math.min(xCenter, x2))-xCenter;
        int y = Math.max(y1, Math.min(yCenter, y2))-yCenter;

        return ((x*x)+(y*y)) <= (radius*radius);
    }
}
