package com.com.leetcode.july;

import java.util.Arrays;
import java.util.List;

public class NumberofPathswithMaxScore {
    private final static int MOD = 1000000007;
    private static int n;
    private static int[][] tScore;
    private static int[][] tPaths;
    public static void main(String[] args) {
        List<String> board = List.of("E23","2X2","12S");
        int [] res = numberOfPaths(board);
        System.out.println("Max Score: " + res[0] + ", Number of Paths: " + res[1]);
    }

    private static int[] numberOfPaths(List<String> board) {
        n = board.size();
        tScore = new int[n][n];
        tPaths = new int[n][n];
        for(int [] row: tScore)
            Arrays.fill(row, -1);
        int [] result = solveII(n-1, n-1, board);
        return result;
    }

    private static int[] solveII(int i, int j, List<String> board) {
        char current = board.get(i).charAt(j);
        if (current == 'E') return new int[]{0, 1}; // Base case: reached the end
        if (current == 'X') return new int[]{0, 0}; // Base case: hit an obstacle
        if (tScore[i][j] != -1) return new int[]{tScore[i][j], tPaths[i][j]}; // Return memoized result
        int upScore = 0, upPaths = 0;
        int leftScore = 0, leftPaths = 0;
        int diaScore = 0, diaPaths = 0;
        char ch = current;
        //up
        if (isValidII(i - 1, j)) {
            int[] up = solveII(i - 1, j, board);
            upScore = up[0];
            upPaths = up[1];
            if (upPaths > 0) {
                upScore += (ch == 'S' ? 0 : Character.getNumericValue(ch));
            }
        }
        //left
        if (isValidII(i, j - 1)) {
            int[] left = solveII(i, j - 1, board);
            leftScore = left[0];
            leftPaths = left[1];
            if (leftPaths > 0) {
                leftScore += (ch == 'S' ? 0 : Character.getNumericValue(ch));
            }
        }
        //diagonal
        if (isValidII(i - 1, j - 1)) {
            int[] dia = solveII(i - 1, j - 1, board);
            diaScore = dia[0];
            diaPaths = dia[1];
            if (diaPaths > 0) {
                diaScore += (ch == 'S' ? 0 : Character.getNumericValue(ch));
            }
        }
        int maxScore;
        int maxPath;
        if (upScore == leftScore && upScore == diaScore) {
            maxScore = upScore % MOD;
            maxPath = (upPaths + leftPaths + diaPaths) % MOD;
        } else if (upScore == leftScore) {
            maxScore = upScore % MOD;
            maxPath = (upPaths + leftPaths) % MOD;
            if (diaScore > maxScore || (diaScore == maxScore && diaPaths > maxPath)) {
                maxScore = diaScore % MOD;
                maxPath = diaPaths % MOD;
            }
        } else if (upScore == diaScore) {
            maxScore = upScore % MOD;
            maxPath = (upPaths + diaPaths) % MOD;
            if (leftScore > maxScore || (leftScore == maxScore && leftPaths > maxPath)) {
                maxScore = leftScore % MOD;
                maxPath = leftPaths % MOD;
            }
        }else{
            maxScore = upScore;
            maxPath = upPaths;
            if (leftScore > maxScore || (leftScore == maxScore && leftPaths > maxPath)) {
                maxScore = leftScore % MOD;
                maxPath = leftPaths % MOD;
            }
            if (diaScore > maxScore || (diaScore == maxScore && diaPaths > maxPath)) {
                maxScore = diaScore % MOD;
                maxPath = diaPaths % MOD;
            }
        }
        tScore[i][j] = maxScore % MOD;
        tPaths[i][j] = maxPath % MOD;
        return new int[]{tScore[i][j] % MOD, tPaths[i][j] % MOD};

    }
    private static boolean isValidII(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < n;
    }
}
