package com.com.leetcode.june;

public class CandyCrush {
    public static void main(String[] args) {
        int [][] board = {{110,5,112,113,114},
                {210,211,5,213,214},
                {310,311,3,313,314},
                {410,411,412,5,414},
                {5,1,512,3,513},
                {610,4,1,613,614},
                {710,1,2,713,714},
                {810,1,2,1,1},
                {1,1,2,2,2},
                {4,1,4,4,1014}};
        int [][] result = candyCrush(board);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean shouldContinue = false;
        // Step 1 & 2: Tag Horizontal Matches (using Math.abs to match across previously flagged items)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 2; j++) {
                int val = Math.abs(board[i][j]);
                if (val != 0 && Math.abs(board[i][j+1]) == val && Math.abs(board[i][j+2]) == val) {
                    board[i][j] = board[i][j+1] = board[i][j+2] = -val;
                    shouldContinue = true;
                }
            }
        }
        // Tag Vertical Matches
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n; j++) {
                int val = Math.abs(board[i][j]);
                if (val != 0 && Math.abs(board[i+1][j]) == val && Math.abs(board[i+2][j]) == val) {
                    board[i][j] = board[i+1][j] = board[i+2][j] = -val;
                    shouldContinue = true;
                }
            }
        }
        // Step 3: Crush & Drop (Gravity Phase via Two-Pointer Write Head Strategy)
        if (shouldContinue) {
            for (int j = 0; j < n; j++) {
                int rHead = m - 1; // Write pointer
                for (int i = m - 1; i >= 0; i--) {
                    if (board[i][j] > 0) {
                        board[rHead][j] = board[i][j];
                        rHead--;
                    }
                }
                // Backfill the remaining top slots of the column with empty space (0)
                while (rHead >= 0) {
                    board[rHead][j] = 0;
                    rHead--;
                }
            }
            // Recurse until no new stable crash configurations are found
            return candyCrush(board);
        }
        return board;
    }
}
