package com.com.leetcode.jan;

public class SeparateSquaresI {
    public static void main(String[] args) {
        int[][] squares = {{0,0,1},{2,2,1}};
        double res = separateSquares(squares);
        System.out.println(res);
    }

    public static double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = -Double.MAX_VALUE;
        double totalArea = 0.0;

        for (int[] square : squares) {
            double y = square[1];
            double l = square[2];

            totalArea += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double resultY = 0.0;

        while (high - low > 1e-5) {
            double midY = low + (high - low) / 2.0;
            resultY = midY;

            if (checkArea(squares, midY, totalArea)) {
                // bottom area is more than half, move down
                high = midY;
            } else {
                low = midY;
            }
        }

        return resultY;
    }
    private static boolean checkArea(int[][] squares, double midY, double totalArea) {
        double bottomArea = 0.0;

        for (int[] square : squares) {
            double y = square[1];
            double l = square[2];

            double bottomY = y;
            double topY = y + l;

            if (midY >= topY) {
                // full square below
                bottomArea += l * l;
            } else if (midY > bottomY) {
                // partial square below
                bottomArea += (midY - bottomY) * l;
            }
        }

        return bottomArea >= totalArea / 2.0;
    }


}
